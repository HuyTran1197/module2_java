package m2_demo.furama_resort.repository;

import m2_demo.furama_resort.model.Customer;
import m2_demo.furama_resort.util.ReadAndWriteFileFurama;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo implements ICustomerRepo{
    private final String CUSTOMER_FILE = "src/m2_demo/furama_resort/data/customer.csv";

    @Override
    public List<Customer> getAll(){
        List<Customer> customerList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFileFurama.readFileCSV(CUSTOMER_FILE);
            String[] arr;
            for (String line : stringList){
                arr=line.split(",");
                Customer customer = new Customer(arr[0],arr[1],
                        arr[2],arr[3],
                        arr[4],arr[5],
                        arr[6],arr[7],arr[8]
                        );
                customerList.add(customer);
            }
        } catch (IOException e) {
            System.out.println("file read fail");
        }
        return customerList;
    }

    @Override
    public boolean add(Customer customer){
        List<String> list = new ArrayList<>();
        list.add(customer.getInfoToCSV());
        try {
            ReadAndWriteFileFurama.writeListStringToCSV(CUSTOMER_FILE,list,true);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return true;
    }

    @Override
    public boolean edit(Customer customer){
        List<Customer> customerList = getAll();
        boolean isSuccessEdit = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId().equals(customer.getId())){
                customerList.set(i,customer);
                isSuccessEdit = true;
                break;
            }
        }
        if (isSuccessEdit){
            List<String> stringList = new ArrayList<>();
            for (Customer c : customerList){
                stringList.add(c.getInfoToCSV());
            }
            try {
                ReadAndWriteFileFurama.writeListStringToCSV(CUSTOMER_FILE,stringList,false);
            } catch (IOException e) {
                System.out.println("file write fail");
                return false;
            }
        }
        return isSuccessEdit;
    }
}
