package m2_demo.exam_m2.repo;

import java.util.List;

public interface IRepo<T>{
    List<T> getAll();
    boolean add(T t);
    boolean delete(String id);
    boolean edit(T t);
    List<T> findByKeyword(String keyword);
}
