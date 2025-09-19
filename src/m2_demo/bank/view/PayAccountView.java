package m2_demo.bank.view;

import m2_demo.bank.entity.PayAccount;
import m2_demo.bank.util.Validate;

import java.util.List;
import java.util.Scanner;

public class PayAccountView {
    private static Scanner scanner = new Scanner(System.in);

    public static void showListPay(List<PayAccount> payAccountList){
        for (PayAccount p : payAccountList){
            if (p!=null){
                System.out.println(p);
            }
        }
    }

    public static PayAccount inputToAdd(){
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
            System.out.print("enter new id number: ");
            int idNumberAdd = Integer.parseInt(scanner.nextLine());
            System.out.print("enter new money account: ");
            int moneyAccountAdd = Integer.parseInt(scanner.nextLine());
            return new PayAccount(idAccountAdd,ownerAdd,dateAdd,idNumberAdd,moneyAccountAdd);
        }catch (NumberFormatException e ){
            System.out.println("invalid format number");
            return null;
        } catch (Exception e) {
            System.out.println("Exception is: "+e.getMessage());
            return null;
        }
    }
}
