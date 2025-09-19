package m2_demo.furama_resort.controller;

import m2_demo.furama_resort.model.Employee;
import m2_demo.furama_resort.service.EmployeeService;
import m2_demo.furama_resort.service.IEmployeeService;
import m2_demo.furama_resort.view.EmployeeView;

import java.util.List;
import java.util.Scanner;

public class EmployeeController {
    private static Scanner sc = new Scanner(System.in);
    private static IEmployeeService employeeService = new EmployeeService();

    static void displayMenuEmployee() {
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("------Employee Management------");
                System.out.println("function" +
                        "\n 1. Display list employees" +
                        "\n 2. Add new employee" +
                        "\n 3. Edit employee" +
                        "\n 4. Return main menu"
                );
                System.out.println("Choose the function");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Display list employees");
                        List<Employee> employeeList = employeeService.getAll();
                        EmployeeView.showList(employeeList);
                        break;
                    case 2:
                        System.out.println("Add new employee");
                        Employee employeeAdd = EmployeeView.inputToAdd();
                        boolean isSuccessAdd = employeeService.add(employeeAdd);
                        if (isSuccessAdd) {
                            System.out.println("Added success");
                        } else {
                            System.out.println("Added fail");
                        }
                        break;
                    case 3:
                        System.out.println("Edit employee");
                        Employee employeeUpdate = EmployeeView.inputToUpdate();
                        boolean isSuccessUpdate = employeeService.edit(employeeUpdate);
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
