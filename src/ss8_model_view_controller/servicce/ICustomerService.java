package ss8_model_view_controller.servicce;

import ss8_model_view_controller.entity.Customer;

public interface ICustomerService {
    Customer[] findAll();
    boolean add(Customer customer);
    boolean delete(int id);
    boolean update(Customer customer);
}
