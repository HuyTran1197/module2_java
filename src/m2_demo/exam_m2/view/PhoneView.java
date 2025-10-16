package m2_demo.exam_m2.view;

import m2_demo.exam_m2.model.PhoneList;
import m2_demo.exam_m2.util.Valid;

import java.util.List;
import java.util.Scanner;

public class PhoneView {
    private static Scanner scanner = new Scanner(System.in);

    public static void showList(List<PhoneList> phoneLists){
        for (PhoneList p : phoneLists){
            if (p!=null){
                System.out.println(p);
            }
        }
    }

    public static PhoneList inputToAdd(){
        try {
            String phone = "";
            String group = "";
            String name = "";
            String sexual = "";
            String birthday = "";
            String email = "";
            String address = "";
            do {
                System.out.print("enter phone to add: ");
                phone = scanner.nextLine();
            }while (!Valid.checkPhone(phone));
            do {
                System.out.print("enter group to add: ");
                group = scanner.nextLine();
            }while (!Valid.checkString(group));
            do {
                System.out.print("enter name to add: ");
                name = scanner.nextLine();
            }while (!Valid.checkBrand(name));
            do {
                System.out.print("enter sexual to add: ");
                sexual = scanner.nextLine();
            }while (!Valid.checkString(sexual));
            do {
                System.out.print("enter birthday to add: ");
                birthday = scanner.nextLine();
            }while (!Valid.checkDate(birthday));
            do {
                System.out.print("enter email to add: ");
                email = scanner.nextLine();
            }while (!Valid.checkEmail(email));
            do {
                System.out.print("enter address to add: ");
                address = scanner.nextLine();
            }while (!Valid.checkBrand(address));
            return new PhoneList(phone,group,name,sexual,birthday,email,address);
        } catch (Exception e) {
            System.out.println("Exception is: "+e.getMessage());
        }
        return null;
    }

    public static PhoneList inputToEdit(){
        try {
            String phone = "";
            String group = "";
            String name = "";
            String sexual = "";
            String birthday = "";
            String email = "";
            String address = "";
            do {
                System.out.print("enter phone to edit: ");
                phone = scanner.nextLine();
            }while (!Valid.checkPhone(phone));
            do {
                System.out.print("enter group to edit: ");
                group = scanner.nextLine();
            }while (!Valid.checkString(group));
            do {
                System.out.print("enter name to edit: ");
                name = scanner.nextLine();
            }while (!Valid.checkBrand(name));
            do {
                System.out.print("enter sexual to edit: ");
                sexual = scanner.nextLine();
            }while (!Valid.checkString(sexual));
            do {
                System.out.print("enter birthday to edit: ");
                birthday = scanner.nextLine();
            }while (!Valid.checkDate(birthday));
            do {
                System.out.print("enter email to edit: ");
                email = scanner.nextLine();
            }while (!Valid.checkEmail(email));
            do {
                System.out.print("enter address to edit: ");
                address = scanner.nextLine();
            }while (!Valid.checkBrand(address));
            return new PhoneList(phone,group,name,sexual,birthday,email,address);
        } catch (Exception e) {
            System.out.println("Exception is: "+e.getMessage());
        }
        return null;
    }
}
