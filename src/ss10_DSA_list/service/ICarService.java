package ss10_DSA_list.service;

import ss10_DSA_list.entity.Car;

import java.util.List;

public interface ICarService {
    List<Car> findAll();
    boolean add(Car car);
    boolean delete(String id);
    boolean find(String id);
}
