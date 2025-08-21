package ss10_DSA_list.repository;

import ss10_DSA_list.entity.Car;

import java.util.List;

public interface ICarRepository {
    List<Car> findAll();
    boolean add(Car car);
    boolean delete(String id);
    boolean find(String id);
}
