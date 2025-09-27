package m2_demo.khoa_hoc.service;

import java.util.List;

public interface IService<T> {
    List<T> getAll();
    boolean add(T t);
    boolean delete(String id);
    List<T> find(String name);
}
