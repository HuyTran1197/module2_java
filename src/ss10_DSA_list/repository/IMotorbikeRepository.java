package ss10_DSA_list.repository;

import ss10_DSA_list.entity.Motorbike;

import java.util.List;

public interface IMotorbikeRepository {
    List<Motorbike> findAll();
    boolean add(Motorbike motorbike);
    boolean delete(String id);
    boolean update(Motorbike motorbike);
    Motorbike find(String id);
}
