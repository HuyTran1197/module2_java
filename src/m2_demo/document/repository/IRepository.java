package m2_demo.document.repository;

import java.util.List;

public interface IRepository<T>{
    List<T> getAll();
    boolean add(T t);
    boolean delete(String id);
    List<T> find(String name);
}
