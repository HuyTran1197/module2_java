package ss10_DSA_list.repository;

import ss10_DSA_list.entity.Truck;

import java.util.List;

public interface ITruckRepository {
    List<Truck> findAll();
    boolean add(Truck truck);
    boolean delete(String id);
    boolean update(Truck truck);
    boolean find(String id);
}
