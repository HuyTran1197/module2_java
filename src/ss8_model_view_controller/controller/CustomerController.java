package ss8_model_view_controller.controller;
import java.util.List;
import java.util.Scanner;

import ss8_model_view_controller.entity.Customer;
import ss8_model_view_controller.servicce.CustomerService;
import ss8_model_view_controller.servicce.ICustomerService;
import ss8_model_view_controller.view.CustomerView;

public class CustomerController {
    public static void displayMenu(){
        ICustomerService customerService = new CustomerService();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("---Customer manager---");
            System.out.println("function: "+
                    "\n 1. List"+
                    "\n 2. Add"+
                    "\n 3. Delete"+
                    "\n 5. Return main menu"
            );
            System.out.println("choose function");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("List");
                    List<Customer> customerList = customerService.findAll();
                    CustomerView.displayList(customerList);
                    break;
                case 2:
                    System.out.println("Add");
                    Customer customerAdd = CustomerView.inputDataToAddNew();
                    boolean isSuccessAdd = customerService.add(customerAdd);
                    if (isSuccessAdd){
                        System.out.println("added success");
                    } else {
                        System.out.println("added fail");
                    }
                    break;
                case 3:
                    System.out.println("Delete");
                    CustomerView.inputDataToDelete(customerService);
                    break;
                default:
                    System.out.println("Returned main menu");
                    flag = false;
                    break;
            }
        }
    }
}
