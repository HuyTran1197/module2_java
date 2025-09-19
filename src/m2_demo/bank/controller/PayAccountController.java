package m2_demo.bank.controller;

import m2_demo.bank.entity.PayAccount;
import m2_demo.bank.service.IPayAccountService;
import m2_demo.bank.service.PayAccountService;
import m2_demo.bank.view.PayAccountView;

import java.util.List;

public class PayAccountController {
    private static IPayAccountService payAccountService = new PayAccountService();

    static void showList(){
        List<PayAccount> payAccountList = payAccountService.getAll();
        PayAccountView.showListPay(payAccountList);
    }
    static void addPay(){
        PayAccount payAccount = PayAccountView.inputToAdd();
        if (payAccount!=null){
            boolean isSuccessAdd = payAccountService.add(payAccount);
            if (isSuccessAdd){
                System.out.println("Added success");
            }else {
                System.out.println("Added fail");
            }
        }
    }
}
