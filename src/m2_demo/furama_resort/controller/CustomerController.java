package m2_demo.furama_resort.controller;

import m2_demo.furama_resort.model.Customer;
import m2_demo.furama_resort.service.CustomerService;
import m2_demo.furama_resort.service.ICustomerService;
import m2_demo.furama_resort.view.CustomerView;

import java.util.List;
import java.util.Scanner;

public class CustomerController {
    private static Scanner scanner = new Scanner(System.in);
    private static ICustomerService customerService = new CustomerService();

    static void displayMenuCustomer(){
        boolean flag = true;
        while (flag){
            try {
                System.out.println("------Customer Management------");
                System.out.println("function" +
                        "\n 1. Display list customers" +
                        "\n 2. Add new customer" +
                        "\n 3. Edit customer" +
                        "\n 4. Return main menu"
                );
                System.out.println("Choose the function");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Display list customers");
                        List<Customer> customerList = customerService.getAll();
                        CustomerView.showList(customerList);
                        break;
                    case 2:
                        System.out.println("Add new customer");
                        Customer customerAdd = CustomerView.inputToAdd();
                        boolean isSuccessAdd = customerService.add(customerAdd);
                        if (isSuccessAdd) {
                            System.out.println("Added success");
                        } else {
                            System.out.println("Added fail");
                        }
                        break;
                    case 3:
                        System.out.println("Edit customer");
                        Customer customerEdit = CustomerView.inputToUpdate();
                        boolean isSuccessUpdate = customerService.edit(customerEdit);
                        if (isSuccessUpdate) {
                            System.out.println("Edited success");
                        } else {
                            System.out.println("Edited fail");
                        }
                        break;
                    case 4:
                        System.out.println("Return main menu");
                        return;
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
