package m2_demo.company.service;

import java.util.List;

public interface IServiceCOM<T>{
    List<T> getAll();
    boolean add(T t);
    boolean delete(int id);
    List<T> findByKeyword(String keyword);
}
