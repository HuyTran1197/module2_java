package m2_demo.document.service;

import java.util.List;

public interface IService<T> {
    List<T> getAll();
    boolean add(T t);
    boolean delete(String id);
    List<T> find(String name);
}
