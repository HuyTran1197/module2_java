package m2_demo.bank.repo;

import java.util.List;

public interface IRepo<T> {
    List<T> getAll();
    boolean add(T t);
    boolean delete(int idAccount);
    T find(int idAccount);
}
