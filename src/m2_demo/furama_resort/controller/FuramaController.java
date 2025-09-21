package m2_demo.furama_resort.controller;

import java.util.Scanner;

public class FuramaController {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu(){
        boolean flag = true;
        while (flag){
            try {
                System.out.println("-------Furama Resort Manager----");
                System.out.println("Function:"+
                        "\n 1. Employee Management"+
                        "\n 2. Customer Management"+
                        "\n 3. Facility Management"+
                        "\n 4. Booking Management"+
                        "\n 5. Promotion Management"+
                        "\n 6. Exit"
                );
                System.out.println("Choose the function");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose){
                    case 1:
                        System.out.println("Employee Management");
                        EmployeeController.displayMenuEmployee();
                        break;
                    case 2:
                        System.out.println("Customer Management");
                        CustomerController.displayMenuCustomer();
                        break;
                    case 3:
                        System.out.println("Facility Management");
                        break;
                    case 4:
                        System.out.println("Booking Management");
                        break;
                    case 5:
                        System.out.println("Promotion Management");
                        break;
                    case 6:
                        System.out.println("Exit. Finished program");
                        flag = false;
                        break;
                    default:
                        System.out.println("invalid choice");
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("your choice is not true format number. Please try again");
            } catch (Exception e) {
                System.out.println("Exception is: "+e.getMessage());
            }
        }
    }
}
