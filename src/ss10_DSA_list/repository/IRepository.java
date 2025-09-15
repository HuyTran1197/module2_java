package ss10_DSA_list.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();
    boolean add(T t);
    boolean delete(String numberOfVehicle);
    boolean update(T t);
    T find(String numberOfVehicle);
}
