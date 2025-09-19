package m2_demo.furama_resort.service;

import java.util.List;

public interface IService<T> {
    List<T> getAll();
    boolean add(T t);
    boolean edit(T t);
}
