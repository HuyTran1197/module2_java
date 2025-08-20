package ss8_model_view_controller.repository;

import ss8_model_view_controller.entity.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    boolean add(Customer customer);
    boolean delete(int id);
    boolean update(Customer customer);
}
