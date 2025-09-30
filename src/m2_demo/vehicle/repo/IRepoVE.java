package m2_demo.vehicle.repo;

import java.util.List;

public interface IRepoVE<T>{
    List<T> getAll();
    boolean add(T t);
    boolean delete(String id);
    List<T> findByKeyword(String keyword);
}
