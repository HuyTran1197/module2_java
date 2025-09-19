package m2_demo.bank.controller;

import m2_demo.bank.entity.SavingAccount;
import m2_demo.bank.service.ISavingAccountService;
import m2_demo.bank.service.SavingAccountService;
import m2_demo.bank.view.SavingAccountView;

import java.util.List;

public class SavingAccountController {
    private static ISavingAccountService savingAccountService = new SavingAccountService();

    static void showList(){
        List<SavingAccount> savingAccountList = savingAccountService.getAll();
        SavingAccountView.showListSaving(savingAccountList);
    }

    static void addSavingAccount(){
        SavingAccount savingAccount = SavingAccountView.inputToAdd();
        if (savingAccount!=null){
            boolean isSuccessAdd = savingAccountService.add(savingAccount);
            if (isSuccessAdd){
                System.out.println("added success");
            } else {
                System.out.println("added fail");
            }
        }
    }
}
