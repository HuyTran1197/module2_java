package ss10_DSA_list.controller;

import java.util.Scanner;

public class MainController {
    public void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("-------Vehicle Manager Program-------");
            System.out.println("Function "+
                    "\n 1. Add"+
                    "\n 2. Show list"+
                    "\n 3. Delete"+
                    "\n 4. Find"+
                    "\n 5. Finished"
            );
            System.out.println("Choose the function");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Add");
                    break;
                case 2:
                    System.out.println("Show list");
                    break;
                case 3:
                    System.out.println("Delete");
                    break;
                case 4:
                    System.out.println("Find");
                    break;
                default:
                    System.out.println("Program finished");
                    flag = false;
                    break;
            }
        }
    }
}
