package ss8_model_view_controller.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();
    boolean add(T t);
    boolean delete(int id);
}
