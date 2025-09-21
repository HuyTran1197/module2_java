package m2_demo.furama_resort.view;

import m2_demo.furama_resort.model.Customer;
import m2_demo.furama_resort.util.Validate;

import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private static Scanner scanner = new Scanner(System.in);

    public static void showList(List<Customer> customerList){
        for (Customer c : customerList){
            if (c!=null){
                System.out.println(c);
            }
        }
    }

    public static Customer inputToAdd(){
        try {
            String idAdd = "";
            do {
                System.out.print("enter true format id customer to add (NV-XXXX): ");
                idAdd = scanner.nextLine();
            }while (!Validate.checkId(idAdd));
            String nameAdd = "";
            do {
                System.out.print("enter true format of name to add (Nguyen Van A): ");
                nameAdd = scanner.nextLine();
            }while (!Validate.checkName(nameAdd));
            String birthdayAdd = "";
            do {
                System.out.print("enter true format birthday to add (dd/mm/yy): ");
                birthdayAdd = scanner.nextLine();
            }while (!Validate.checkBirthday(birthdayAdd));
            String idPersonAdd = "";
            do {
                System.out.print("enter true format id person to add (length form 9 to 12 number): ");
                idPersonAdd = scanner.nextLine();
            }while (!Validate.checkIdPerson(idPersonAdd));
            String phoneAdd = "";
            do {
                System.out.print("enter true format phone number to add (start by 0 and length equals 10 number) : ");
                phoneAdd = scanner.nextLine();
            }while (!Validate.checkPhone(phoneAdd));
            String emailAdd = "";
            do {
                System.out.print("enter true format email to add  (abc@abc.com) : ");
                emailAdd = scanner.nextLine();
            }while (!Validate.checkEmail(emailAdd));
            System.out.print("enter sexual to add: ");
            String sexualAdd = scanner.nextLine();
            System.out.print("enter type customer to add: ");
            String type = scanner.nextLine();
            System.out.print("enter address customer to add: ");
            String address = scanner.nextLine();
            return new Customer(idAdd,nameAdd,birthdayAdd,sexualAdd,idPersonAdd,phoneAdd,emailAdd,type,address);
        }catch (Exception e) {
            System.out.println("Exception is: "+e.getMessage());
            return null;
        }
    }

    public static Customer inputToUpdate(){
        try {
            String idUpdate = "";
            do {
                System.out.print("enter true format id customer to update (NV-XXXX): ");
                idUpdate = scanner.nextLine();
            }while (!Validate.checkId(idUpdate));
            String nameUpdate = "";
            do {
                System.out.print("enter true format of name to update (Nguyen Van A): ");
                nameUpdate = scanner.nextLine();
            }while (!Validate.checkName(nameUpdate));
            String birthdayUpdate = "";
            do {
                System.out.print("enter true format birthday to update (dd/mm/yy): ");
                birthdayUpdate = scanner.nextLine();
            }while (!Validate.checkBirthday(birthdayUpdate));
            String idPersonUpdate = "";
            do {
                System.out.print("enter true format id person to update (length form 9 to 12 number): ");
                idPersonUpdate = scanner.nextLine();
            }while (!Validate.checkIdPerson(idPersonUpdate));
            String phoneUpdate = "";
            do {
                System.out.print("enter true format phone number to update (start by 0 and length equals 10 number) : ");
                phoneUpdate = scanner.nextLine();
            }while (!Validate.checkPhone(phoneUpdate));
            String emailUpdate = "";
            do {
                System.out.print("enter true format email to update  (abc@abc.com) : ");
                emailUpdate = scanner.nextLine();
            }while (!Validate.checkEmail(emailUpdate));
            System.out.print("enter sexual to update: ");
            String sexualUpdate = scanner.nextLine();
            System.out.print("enter type of customer to update: ");
            String typeUpdate = scanner.nextLine();
            System.out.print("enter address of customer to update: ");
            String addressUpdate = scanner.nextLine();
            return new Customer(idUpdate,nameUpdate,birthdayUpdate,sexualUpdate,idPersonUpdate,phoneUpdate,emailUpdate,typeUpdate,addressUpdate);
        }catch (Exception e) {
            System.out.println("Exception is: "+e.getMessage());
            return null;
        }
    }
}
