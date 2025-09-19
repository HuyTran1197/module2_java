package m2_demo.furama_resort.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> getAll();
    boolean add(T t);
    boolean edit(T t);
}
