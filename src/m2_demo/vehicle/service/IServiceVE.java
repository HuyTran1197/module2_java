package m2_demo.vehicle.service;

import java.util.List;

public interface IServiceVE<T>{
    List<T> getAll();
    boolean add(T t);
    boolean delete(String id);
    List<T> findByKeyword(String keyword);
}
