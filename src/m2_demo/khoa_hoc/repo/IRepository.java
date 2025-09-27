package m2_demo.khoa_hoc.repo;

import java.util.List;

public interface IRepository<T>{
    List<T> getAll();
    boolean add(T t);
    boolean delete(String id);
    List<T> find(String name);
}
