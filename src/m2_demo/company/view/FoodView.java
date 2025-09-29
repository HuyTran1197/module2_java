package m2_demo.company.view;

import m2_demo.company.model.FoodProduct;
import m2_demo.company.util.Valid;

import java.util.List;
import java.util.Scanner;

public class FoodView {
    private static Scanner scanner = new Scanner(System.in);

    public static void showList(List<FoodProduct> foodProductList){
        for (FoodProduct f : foodProductList){
            if (f!=null){
                System.out.println(f);
            }
        }
    }

    public static FoodProduct inputToAddFood(){
        try {
            String name = "";
            do {
                System.out.print("enter name to add: ");
                name = scanner.nextLine();
            }while (!Valid.checkString(name));
            double price;
            do {
                System.out.println("enter price to add");
                price = Double.parseDouble(scanner.nextLine());
            }while (price<=0);
            String date = "";
            do {
                System.out.print("enter expire date to add (dd/mm/yy): ");
                date = scanner.nextLine();
            }while (!Valid.checkDate(date));
            String origin = "";
            do {
                System.out.print("enter origin to add: ");
                origin = scanner.nextLine();
            }while (!Valid.checkBrand(origin));
            return new FoodProduct(name,price,date,origin);
        } catch (Exception e) {
            System.out.println("Exception is: "+e.getMessage());
        }
        return null;
    }
}
