package m2_demo.bank.service;

import m2_demo.bank.entity.PayAccount;

import java.util.List;

public interface IPayAccountService {
    List<PayAccount> getAll();
    boolean add(PayAccount payAccount);
    boolean delete(int idAccount);
    PayAccount find(int idAccount);
}
