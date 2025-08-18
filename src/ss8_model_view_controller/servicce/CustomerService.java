package ss8_model_view_controller.servicce;

import ss8_model_view_controller.entity.Customer;
import ss8_model_view_controller.repository.CustomerRepository;
import ss8_model_view_controller.repository.ICustomerRepository;

public class CustomerService implements ICustomerService{
    private ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public Customer[] findAll(){
        return customerRepository.findAll();
    }
    @Override
    public boolean add(Customer customer){
        Customer[] customers = customerRepository.findAll();
        for (int i = 0; i < customers.length; i++) {
            if (customers[i]!=null){
                if (customers[i].getId() == customer.getId()){
                    System.out.println("id already exists");
                    return false;
                }
            } else break;
        }
        return customerRepository.add(customer);
    }
}
