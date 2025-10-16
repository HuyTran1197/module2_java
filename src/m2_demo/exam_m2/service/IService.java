package m2_demo.exam_m2.service;

import java.util.List;

public interface IService<T>{
    List<T> getAll();
    boolean add(T t);
    boolean delete(String id);
    boolean edit(T t);
    List<T> findByKeyword(String keyword);
}
