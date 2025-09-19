package m2_demo.bank.service;

import m2_demo.bank.entity.SavingAccount;
import m2_demo.bank.repo.ISavingAccountRepo;
import m2_demo.bank.repo.SavingAccountRepo;

import java.util.List;

public class SavingAccountService implements ISavingAccountService{
    private ISavingAccountRepo savingAccountRepo = new SavingAccountRepo();

    @Override
    public List<SavingAccount> getAll(){
        return savingAccountRepo.getAll();
    }

    @Override
    public boolean add(SavingAccount savingAccount){
        if (savingAccount == null){
            return false;
        }
        if (savingAccount.getIdAccount()<0
                || savingAccount.getSavingMoney()<0
                || savingAccount.getDate() == null
                || savingAccount.getSentDate()==null
                || savingAccount.getOwner()==null){
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

    @Override
    public boolean delete(int idAccount){
        return savingAccountRepo.delete(idAccount);
    }

    @Override
    public SavingAccount find(int idAccount){
        return savingAccountRepo.find(idAccount);
    }
}
