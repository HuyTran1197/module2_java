package ss10_DSA_list.service;

import ss10_DSA_list.entity.Truck;

import java.util.List;

public interface ITruckService {
    List<Truck> findAll();
    boolean add(Truck truck);
    boolean delete(String id);
    boolean update(Truck truck);
    Truck find(String id);
}
