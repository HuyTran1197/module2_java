package ss8_model_view_controller.repository;

import ss8_model_view_controller.entity.Customer;

import java.util.LinkedList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository{
    private static List<Customer> customers = new LinkedList<>();
    static {
        customers.add(new Customer(1,"Tùng","phanttung97@gmail.com","phu loc"));
        customers.add(new Customer(2,"Hạo","minhhaotran97@gmail.com","phu loc"));
    }
    @Override
    public List<Customer> findAll(){
        return customers;
    }
    @Override
    public boolean add(Customer customer){
        return customers.add(customer);
    }
    @Override
    public boolean delete(int id){
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i)!=null){
                if (customers.get(i).getId() == id){
                    customers.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public boolean update(Customer customer){
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i)!=null){
                if (customers.get(i).getId() == customer.getId()){
                    customers.set(i,customer);
                    return true;
                }
            }
        }
        return false;
    }
}
