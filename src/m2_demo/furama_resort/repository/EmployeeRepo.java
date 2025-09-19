package m2_demo.furama_resort.repository;

import m2_demo.furama_resort.model.Employee;
import m2_demo.furama_resort.util.ReadAndWriteFileFurama;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo implements IEmployeeRepo{
    private final String EMPLOYEE_FILE = "src/m2_demo/furama_resort/data/employee.csv";

    @Override
    public List<Employee> getAll(){
        List<Employee> employeeList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFileFurama.readFileCSV(EMPLOYEE_FILE);
            String[] arr;
            for (String line : stringList){
                arr=line.split(",");
                Employee employee = new Employee(arr[0],
                        arr[1],
                        arr[2],
                        arr[3],
                        arr[4],
                        arr[5],
                        arr[6],
                        arr[7],
                        arr[8],
                        Integer.parseInt(arr[9])
                        );
                employeeList.add(employee);
            }
        } catch (IOException e) {
            System.out.println("file read fail");
        }
        return employeeList;
    }

    @Override
    public boolean add(Employee employee){
        List<String> list = new ArrayList<>();
        list.add(employee.getInfoToCSV());
        try {
            ReadAndWriteFileFurama.writeListStringToCSV(EMPLOYEE_FILE,list,true);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return true;
    }

    @Override
    public boolean edit(Employee employee){
        List<Employee> employeeList = getAll();
        boolean isSuccessEdit = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(employee.getId())){
                employeeList.set(i,employee);
                isSuccessEdit = true;
                break;
            }
        }
        if (isSuccessEdit){
            List<String> stringList = new ArrayList<>();
            for (Employee e : employeeList){
                stringList.add(e.getInfoToCSV());
            }
            try {
                ReadAndWriteFileFurama.writeListStringToCSV(EMPLOYEE_FILE,stringList,false);
            } catch (IOException e) {
                System.out.println("file write fail");
                return false;
            }
        }
        return isSuccessEdit;
    }
}
