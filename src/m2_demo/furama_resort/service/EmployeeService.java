package m2_demo.furama_resort.service;

import m2_demo.furama_resort.model.Employee;
import m2_demo.furama_resort.repository.EmployeeRepo;
import m2_demo.furama_resort.repository.IEmployeeRepo;

import java.util.List;

public class EmployeeService implements IEmployeeService{
    private static IEmployeeRepo employeeRepo = new EmployeeRepo();

    @Override
    public List<Employee> getAll(){
        return employeeRepo.getAll();
    }

    @Override
    public boolean add(Employee employee){
        if (employee==null){
            return false;
        }
        if (employee.getId()==null
                ||employee.getName()==null
                ||employee.getBirthday()==null
                ||employee.getSexual()==null
                ||employee.getIdPerson()==null
                ||employee.getPhone()==null
                ||employee.getEmail()==null
                ||employee.getLevel()==null
                ||employee.getPosition()==null
                ||employee.getSalary()<0
        ){
            return false;
        }
        for (Employee e : employeeRepo.getAll()){
            if (e.getId().equals(employee.getId())){
                System.out.println("id is already exists");
                return false;
            }
        }
        return employeeRepo.add(employee);
    }

    @Override
    public boolean edit(Employee employee){
        if (employee==null){
            return false;
        }
        if (employee.getId()==null
                ||employee.getName()==null
                ||employee.getBirthday()==null
                ||employee.getSexual()==null
                ||employee.getPhone()==null
                ||employee.getEmail()==null
                ||employee.getLevel()==null
                ||employee.getPosition()==null
                ||employee.getSalary()<0
        ){
            return false;
        }
        boolean isExists = false;
        for (Employee e: employeeRepo.getAll()){
            if (e.getId().equals(employee.getId())){
                isExists = true;
                break;
            }
        } if (!isExists){
            System.out.println("Not found id to edit");
            return false;
        }
        return employeeRepo.edit(employee);
    }
}
