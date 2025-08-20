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
                    "\n 4. Update"+
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
                    customerService.add(customerAdd);
                    break;
                case 3:
                    System.out.println("Delete");
                    CustomerView.inputDataToDelete(customerService);
                    break;
                case 4:
                    System.out.println("Update");
                    Customer customerUpdate = CustomerView.inputDataToUpdate();
                    boolean isCheckAdd = customerService.update(customerUpdate);
                    if (!isCheckAdd){
                        System.out.println("failed update");
                    } else{
                        System.out.println("success updated");
                    }
                    break;
                default:
                    System.out.println("Returned main menu");
                    flag = false;
                    break;
            }
        }
    }
}
