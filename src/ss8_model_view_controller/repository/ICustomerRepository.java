package ss8_model_view_controller.repository;

import ss8_model_view_controller.entity.Customer;

public interface ICustomerRepository {
    Customer[] findAll();
    boolean add(Customer customer);
    boolean delete(int id);
}
