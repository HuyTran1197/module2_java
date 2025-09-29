package m2_demo.company.repo;

import java.util.List;

public interface IRepositoryCOM<T>{
    List<T> getAll();
    boolean add(T t);
    boolean delete(int id);
    List<T> findByKeyword(String keyword);
}
