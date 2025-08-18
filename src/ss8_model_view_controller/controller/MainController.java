package ss8_model_view_controller.controller;
import java.util.Scanner;

public class MainController {
    public static void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("---Choose management function");
            System.out.println("Function "+
                    "\n 1. Person manager"+
                    "\n 2. Customer manager"+
                    "\n 3. Finished "
            );
            System.out.println("Choose the function");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Person manager");
                    break;
                case 2:
                    System.out.println("Customer manager");
                    CustomerController.displayMenu();
                    break;
                default:
                    System.out.println("Program finished");
                    flag = false;
                    break;
            }
        }
    }
}
