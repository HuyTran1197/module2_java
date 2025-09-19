package m2_demo.bank.service;

import m2_demo.bank.entity.PayAccount;
import m2_demo.bank.repo.IPayAccountRepo;
import m2_demo.bank.repo.PayAccountRepo;

import java.util.List;

public class PayAccountService implements IPayAccountService{
    private IPayAccountRepo payAccountRepo = new PayAccountRepo();

    @Override
    public List<PayAccount> getAll(){
        return payAccountRepo.getAll();
    }

    @Override
    public boolean add(PayAccount payAccount){
        if (payAccount==null){
            return false;
        }
        if (payAccount.getIdAccount()<0
                ||payAccount.getOwner()==null
                ||payAccount.getDate()==null
                ||payAccount.getIdNumber()<0
                ||payAccount.getMoneyAccount()<0){
            return false;
        }
        return payAccountRepo.add(payAccount);
    }

    @Override
    public boolean delete(int idAccount){
        return payAccountRepo.delete(idAccount);
    }

    @Override
    public PayAccount find(int idAccount){
        return payAccountRepo.find(idAccount);
    }
}
