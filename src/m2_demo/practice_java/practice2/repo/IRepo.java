package m2_demo.practice_java.practice2.repo;

import java.util.List;

public interface IRepo<T>{
    List<T> getAll();
    boolean add(T t);
    boolean delete(String id);
    List<T> findByKeyword(String keyword);
}
