package ss8_model_view_controller.servicce;

import ss8_model_view_controller.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    boolean add(Customer customer);
    boolean delete(int id);
}
