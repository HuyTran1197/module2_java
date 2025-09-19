package m2_demo.bank.view;

import m2_demo.bank.entity.SavingAccount;
import m2_demo.bank.util.Validate;

import java.util.List;
import java.util.Scanner;

public class SavingAccountView {
    private static Scanner scanner = new Scanner(System.in);

    public static void showListSaving(List<SavingAccount> savingAccountList){
        for (SavingAccount s : savingAccountList){
            if (s!=null){
                System.out.println(s);
            }
        }
    }

    public static SavingAccount inputToAdd(){
        try {
            System.out.print("enter new id account: ");
            int idAccountAdd = Integer.parseInt(scanner.nextLine());
            System.out.print("enter new owner: ");
            String ownerAdd = scanner.nextLine();
            String dateAdd = "";
            do {
                System.out.print("enter new date create account: ");
                dateAdd = scanner.nextLine();
            }while (!Validate.checkDate(dateAdd));
            System.out.print("enter new saving money: ");
            int savingMoneyAdd = Integer.parseInt(scanner.nextLine());
            String sendDateAdd = "";
            do {
                System.out.print("enter new send date: ");
                sendDateAdd = scanner.nextLine();
            }while (!Validate.checkDate(sendDateAdd));
            System.out.print("enter new rate: ");
            int rateAdd = Integer.parseInt(scanner.nextLine());
            System.out.print("enter new term: ");
            int termAdd = Integer.parseInt(scanner.nextLine());
            return new SavingAccount(idAccountAdd,ownerAdd,dateAdd,savingMoneyAdd,sendDateAdd,rateAdd,termAdd);
        }catch (NumberFormatException e){
            System.out.println("invalid number");
            return null;
        } catch (Exception e) {
            System.out.println("file write fail");
            return null;
        }
    }
}
