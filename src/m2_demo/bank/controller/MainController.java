package m2_demo.bank.controller;

import m2_demo.bank.service.PayAccountService;
import m2_demo.bank.service.SavingAccountService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);
    private static SavingAccountService savingAccountService = new SavingAccountService();
    private static PayAccountService payAccountService = new PayAccountService();

    static void confirmDelete(int idAccount, int number){
        System.out.print("Please enter Yes to delete or No to cancel: ");
        String conf = scanner.nextLine();
        if (conf.equalsIgnoreCase("Yes")){
            boolean isDeleted = false;
            switch (number){
                case 1:
                    isDeleted = savingAccountService.delete(idAccount);
                    System.out.println("Deleted saving account");
                    break;
                case 2:
                    isDeleted = payAccountService.delete(idAccount);
                    System.out.println("Deleted pay account");
                    break;
            } if (!isDeleted){
                System.out.println("Deleted fail");
            }
        } else {
            System.out.println("Canceled delete ! Return main menu");
        }
    }

    public static void showListMain(){
        boolean flag = true;
        while (flag) {
            System.out.println("-----Bank Account Manager-----");
            System.out.println("function"+
                    "\n 1. Add"+
                    "\n 2. Delete"+
                    "\n 3. Show list bank account"+
                    "\n 4. Find"+
                    "\n 5. Finish Program"
            );
            System.out.println("Choose the function");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Add");
                    System.out.println("Select 1 or 2 to add:"+
                            "\n 1. Saving Account"+
                            "\n 2. Pay Account");
                    int chooseAdd = Integer.parseInt(scanner.nextLine());
                    switch (chooseAdd){
                        case 1:
                            System.out.println("----Add Saving Account----");
                            SavingAccountController.addSavingAccount();
                            break;
                        case 2:
                            System.out.println("------Add Pay Account-------");
                            PayAccountController.addPay();
                            break;
                        default:
                            System.out.println("your select is invalid");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Delete");
                    System.out.print("enter id account need to delete: ");
                    int idDel = Integer.parseInt(scanner.nextLine());
                    if (savingAccountService.find(idDel)!=null){
                        confirmDelete(idDel,1);
                    } else if (payAccountService.find(idDel)!=null){
                        confirmDelete(idDel,2);
                    } else {
                        System.out.println("Not found id account to delete");
                    }
                    break;
                case 3:
                    System.out.println("Show list");
                    System.out.println("Select number 1 or 2 to show list bank account:"+
                            "\n 1. Saving Account"+
                            "\n 2. Pay Account");
                    int chooseShow = Integer.parseInt(scanner.nextLine());
                    switch (chooseShow){
                        case 1:
                            System.out.println("-----Show list saving account-----");
                            SavingAccountController.showList();
                            break;
                        case 2:
                            System.out.println("------Show list pay account-------");
                            PayAccountController.showList();
                            break;
                        default:
                            System.out.println("your choose is false, please choose again");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Find");
                    System.out.print("enter id account need to find list");
                    int idFind = Integer.parseInt(scanner.nextLine());
                    if (savingAccountService.find(idFind)!=null){
                        System.out.println("------Found by Saving account");
                        SavingAccountController.showList();
                    } else if (payAccountService.find(idFind) != null) {
                        System.out.println("------Found by Pay account");
                        PayAccountController.showList();
                    } else {
                        System.out.println("Not found id to find");
                    }
                    break;
                default:
                    System.out.println("Finished Program");
                    flag = false;
                    break;
            }
        }
    }
}
