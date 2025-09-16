package m2_demo.bank.view;

import m2_demo.bank.entity.SavingAccount;

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
//    public static SavingAccount inputToAdd(){
//        try {
//            System.out.print("enter new id account: ");
//            int idAccountNew = Integer.parseInt(scanner.nextLine());
//            System.out.print("enter new owner: ");
//            String ownerNew = scanner.nextLine();
//            System.out.print("enter new date create account: ");
//            String dateNew = scanner.nextLine();
//            System.out.println();
//        }
//    }
}
