package ss8_model_view_controller.repository;

import ss8_model_view_controller.entity.Customer;
import ss8_model_view_controller.ultil.ReadAndWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository{
    private final String CUSTOMER_FILE = "src/ss8_model_view_controller/data/customer.csv";
    @Override
    public List<Customer> findAll(){
        List<Customer> customerList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFile.readFileCSV(CUSTOMER_FILE);
            String[] arr = null;
            for (int i = 0; i < stringList.size(); i++) {
                arr = stringList.get(i).split(",");
                Customer customer = new Customer(Integer.parseInt(arr[0]),arr[1],arr[2],arr[3]);
                customerList.add(customer);
            }
        } catch (IOException e) {
            System.out.println("file read be fail");
        }

        return customerList;
    }
    @Override
    public boolean add(Customer customer){
        List<String> list = new LinkedList<>();
        list.add(customer.getInfoToCSV());
        try {
            ReadAndWriteFile.writeListStringToCSV(CUSTOMER_FILE,list,true);
        } catch (IOException e) {
            System.out.println("loi ghi file");
            return false;
        }
        return true;
    }
    @Override
    public boolean delete(int id){
        // code xoa
        boolean isSuccessDelete = false;
        List<Customer> customerList = findAll();
        for (int i = 0; i < customerList.size(); i++) {
            if (id == customerList.get(i).getId()){
                customerList.remove(i);
                isSuccessDelete = true;
                break;
            }
        }
        // chuyen doi customList sang listString
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < customerList.size(); i++) {
            stringList.add(customerList.get(i).getInfoToCSV());
        }
        try {
            ReadAndWriteFile.writeListStringToCSV(CUSTOMER_FILE,stringList,false);
        } catch (IOException e) {
            System.out.println("file write fail");
        }
        return isSuccessDelete;
    }
}
