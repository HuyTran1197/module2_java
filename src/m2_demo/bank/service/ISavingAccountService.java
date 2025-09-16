package m2_demo.bank.service;

import m2_demo.bank.entity.SavingAccount;

import java.util.List;

public interface ISavingAccountService {
    List<SavingAccount> getAll();
    boolean add(SavingAccount savingAccount);
}
