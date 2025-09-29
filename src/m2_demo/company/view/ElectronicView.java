package m2_demo.company.view;

import m2_demo.company.model.ElectronicProduct;
import m2_demo.company.util.Valid;

import java.util.List;
import java.util.Scanner;

public class ElectronicView {
    private static Scanner scanner = new Scanner(System.in);

    public static void showList(List<ElectronicProduct> electronicProductList){
        for (ElectronicProduct e : electronicProductList){
            if (e!=null){
                System.out.println(e);
            }
        }
    }

    public static ElectronicProduct inputToAddElectronic(){
        try {
            String name = "";
            do {
                System.out.print("enter name to add: ");
                name = scanner.nextLine();
            }while (!Valid.checkString(name));
            double price;
            int warrantyMonths;
            do {
                System.out.println("enter price and warranty month to add");
                price = Double.parseDouble(scanner.nextLine());
                warrantyMonths = Integer.parseInt(scanner.nextLine());
            }while (price<=0 || warrantyMonths<=0);
            String brand = "";
            do {
                System.out.print("enter brand to add: ");
                brand = scanner.nextLine();
            }while (!Valid.checkBrand(brand));
            return new ElectronicProduct(name,price,warrantyMonths,brand);
        } catch (Exception e) {
            System.out.println("Exception is: "+e.getMessage());
        }
        return null;
    }
}
