package m2_demo.furama_resort.service;

import m2_demo.furama_resort.model.Customer;
import m2_demo.furama_resort.repository.CustomerRepo;
import m2_demo.furama_resort.repository.ICustomerRepo;

import java.util.List;

public class CustomerService implements ICustomerService{
    public static ICustomerRepo customerRepo = new CustomerRepo();

    @Override
    public List<Customer> getAll(){
        return customerRepo.getAll();
    }

    @Override
    public boolean add(Customer customer){
        if (customer==null){
            return false;
        } if (customer.getId()==null
                ||customer.getName()==null
                ||customer.getBirthday()==null
                ||customer.getSexual()==null
                ||customer.getIdPerson()==null
                ||customer.getPhone()==null
                ||customer.getEmail()==null
                ||customer.getTypeCus()==null
                ||customer.getAddress()==null
        ){
            return false;
        }
        for (Customer c : customerRepo.getAll()){
            if (c.getId().equals(customer.getId())){
                System.out.println("id is already exists");
                return false;
            }
        }
        return customerRepo.add(customer);
    }

    @Override
    public boolean edit(Customer customer){
        if (customer==null){
            return false;
        } if (customer.getId()==null
                ||customer.getName()==null
                ||customer.getBirthday()==null
                ||customer.getSexual()==null
                ||customer.getIdPerson()==null
                ||customer.getPhone()==null
                ||customer.getEmail()==null
                ||customer.getTypeCus()==null
                ||customer.getAddress()==null
        ){
            return false;
        }
        boolean isExists = false;
        for (Customer c : customerRepo.getAll()){
            if (c.getId().equals(customer.getId())){
                isExists = true;
                break;
            }
        }
        if (!isExists){
            System.out.println("not found id to edit customer");
            return false;
        }
        return customerRepo.edit(customer);
    }
}
