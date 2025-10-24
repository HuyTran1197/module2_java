package m2_demo.practice_java.practice2.view;

import m2_demo.practice_java.practice2.entity.Product;
import m2_demo.practice_java.practice2.util.Valid;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    private static Scanner scanner = new Scanner(System.in);

    public static void showList(List<Product> productList){
        for (Product p : productList){
            if (p!=null){
                System.out.println(p);
            }
        }
    }

    public static Product inputToAdd(){
        try {
            String id = "";
            String name = "";
            int price;
            do {
                System.out.print("enter name to add: ");
                name = scanner.nextLine();
            }while (!Valid.checkName(name));
            do {
                System.out.print("enter id to add: ");
                id = scanner.nextLine();
            }while (!Valid.checkId(id));
            do {
                System.out.print("enter price to add: ");
                price = Integer.parseInt(scanner.nextLine());
            }while (price<=0);
            return new Product(id,name,price);
        } catch (Exception e) {
            System.out.println("Exception is: "+e.getMessage());
        }
        return null;
    }

}
