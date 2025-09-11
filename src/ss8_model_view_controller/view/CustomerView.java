package ss8_model_view_controller.view;
import ss8_model_view_controller.entity.Customer;
import ss8_model_view_controller.servicce.ICustomerService;

import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private static Scanner scanner = new Scanner(System.in);
    public static void displayList(List<Customer> customerList){
        for (Customer customer : customerList){
            if (customer!=null){
                System.out.println(customer);
            } else {
                break;
            }
        }
    }
    public static Customer inputDataToAddNew(){
        System.out.println("enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("enter name: ");
        String name = scanner.nextLine();
        System.out.println("enter email: ");
        String email = scanner.nextLine();
        System.out.println("enter address: ");
        String address = scanner.nextLine();
        return new Customer(id,name,email,address);
    }
    public static void inputDataToDelete(ICustomerService customerService){
        System.out.println("enter the id need to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("do you wanna delete the customer has the id = "+id);
        String confirm = scanner.nextLine();
        if (confirm.equals("yes")){
            boolean check = customerService.delete(id);
            if (check){
                System.out.println("delete success");
            } else{
                System.out.println("cannot found id");
            }
        } else{
            System.out.println("canceled delete");
        }
    }
}
