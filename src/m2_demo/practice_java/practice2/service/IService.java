package m2_demo.practice_java.practice2.service;

import m2_demo.practice_java.practice2.entity.Product;

import java.util.List;

public interface IService<T>{
    List<T> getAll();
    boolean add(Product product);
    boolean delete(String id);
    List<T> findByKeyword(String keyword);
}
