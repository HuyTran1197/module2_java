package ss8_model_view_controller.repository;

import ss8_model_view_controller.entity.Customer;

public class CustomerRepository implements ICustomerRepository{
    private static Customer[] customers = new Customer[100];
    static {
        customers[0] = new Customer(1,"Tùng","phanttung97@gmail.com","phu loc");
        customers[1] = new Customer(2,"Hạo","minhhaotran97@gmail.com","phu loc");
    }
    @Override
    public Customer[] findAll(){
        return customers;
    }
    @Override
    public boolean add(Customer customer){
        for (int i = 0; i < customers.length; i++) {
            if (customers[i]==null){
                customers[i] = customer;
                break;
            }
        }
        return true;
    }
}
