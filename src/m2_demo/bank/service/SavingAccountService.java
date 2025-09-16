package m2_demo.bank.service;

import m2_demo.bank.entity.SavingAccount;
import m2_demo.bank.repo.ISavingAccountRepo;
import m2_demo.bank.repo.SavingAccountRepo;

import java.util.List;

public class SavingAccountService implements ISavingAccountService{
    private ISavingAccountRepo savingAccountRepo = new SavingAccountRepo();

    public List<SavingAccount> getAll(){
        return savingAccountRepo.getAll();
    }

    public boolean add(SavingAccount savingAccount){
        List<SavingAccount> savingAccountList = savingAccountRepo.getAll();
        if (savingAccount == null){
            System.out.println("null valid saving account");
            return false;
        }
        if (savingAccount.getIdAccount()<0
                || savingAccount.getSavingMoney()<0
                || savingAccount.getSentDate()==null
                || savingAccount.getOwner()==null){
            System.out.println("invalid Saving Account date");
            return false;
        }
        List<SavingAccount> list = getAll();
        int id = 1;
        if (!list.isEmpty()){
            id = list.get(list.size()-1).getId()+1;
        }
        savingAccount.setId(id);
        return savingAccountRepo.add(savingAccount);
    }
}
