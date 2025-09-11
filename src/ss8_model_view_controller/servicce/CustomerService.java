package ss8_model_view_controller.servicce;

import ss8_model_view_controller.entity.Customer;
import ss8_model_view_controller.repository.CustomerRepository;
import ss8_model_view_controller.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public boolean add(Customer customer) {
        List<Customer> customers = customerRepository.findAll();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i) != null) {
                if (customers.get(i).getId() == customer.getId()) {
                    System.out.println("id already exists");
                    return false;
                }
            } else break;
        }
        if (customer == null) {
            System.out.println("null list");
            return false;
        }
        if (customer.getName() == null || customer.getEmail() == null || customer.getAddress() == null) {
            return false;
        }
        return customerRepository.add(customer);
    }

    @Override
    public boolean delete(int id) {
        return customerRepository.delete(id);
    }
}
