package m2_demo.furama_resort.view;

import m2_demo.furama_resort.model.Employee;
import m2_demo.furama_resort.util.Validate;

import java.util.List;
import java.util.Scanner;

public class EmployeeView {
    private static Scanner scanner = new Scanner(System.in);

    public static void showList(List<Employee> employeeList){
        for (Employee e : employeeList){
            if (e!=null){
                System.out.println(e);
            }
        }
    }

    public static Employee inputToAdd(){
        try {
            String idAdd = "";
            do {
                System.out.print("enter true format id employee to add (NV-XXXX): ");
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
            int salaryAdd;
            do {
                System.out.print("enter true format salary to add (salary must be bigger 0) : ");
                salaryAdd = Integer.parseInt(scanner.nextLine());
            }while (salaryAdd<=0);
            String emailAdd = "";
            do {
                System.out.print("enter true format email to add  (abc@abc.com) : ");
                emailAdd = scanner.nextLine();
            }while (!Validate.checkEmail(emailAdd));
            System.out.print("enter sexual to add: ");
            String sexualAdd = scanner.nextLine();
            System.out.print("enter level of employee to add: ");
            String levelAdd = scanner.nextLine();
            System.out.print("enter position of employee to add: ");
            String positionAdd = scanner.nextLine();
            return new Employee(idAdd,nameAdd,birthdayAdd,sexualAdd,idPersonAdd,phoneAdd,emailAdd,levelAdd,positionAdd,salaryAdd);
        }catch (NumberFormatException e){
            System.out.println("fail format number");
            return null;
        } catch (Exception e) {
            System.out.println("Exception is: "+e.getMessage());
            return null;
        }
    }

    public static Employee inputToUpdate(){
        try {
            String idUpdate = "";
            do {
                System.out.print("enter true format id employee to update (NV-XXXX): ");
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
            int salaryUpdate;
            do {
                System.out.print("enter true format salary to update (salary must be bigger 0) : ");
                salaryUpdate = Integer.parseInt(scanner.nextLine());
            }while (salaryUpdate<=0);
            String emailUpdate = "";
            do {
                System.out.print("enter true format email to update  (abc@abc.com) : ");
                emailUpdate = scanner.nextLine();
            }while (!Validate.checkEmail(emailUpdate));
            System.out.print("enter sexual to update: ");
            String sexualUpdate = scanner.nextLine();
            System.out.print("enter level of employee to update: ");
            String levelUpdate = scanner.nextLine();
            System.out.print("enter position of employee to update: ");
            String positionUpdate = scanner.nextLine();
            return new Employee(idUpdate,nameUpdate,birthdayUpdate,sexualUpdate,idPersonUpdate,phoneUpdate,emailUpdate,levelUpdate,positionUpdate,salaryUpdate);
        }catch (NumberFormatException e){
            System.out.println("fail format number");
            return null;
        } catch (Exception e) {
            System.out.println("Exception is: "+e.getMessage());
            return null;
        }
    }
}
