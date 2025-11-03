package m2_demo.practice_java.practice4.StudentsManagement_2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private static Scanner scanner = new Scanner(System.in);
    private static final String PRODUCT_FILE = "src/m2_demo/practice_java/practice4/StudentsManagement_2/products.txt";
    private static List<Product> productList = new ArrayList<>();

    public static void displayMenu(){
        boolean flag = true;
        while (flag){
            try {
                System.out.println("------Vehicle Management------");
                System.out.println("Function " +
                        "\n 1. Add" +
                        "\n 2. Read file" +
                        "\n 3. Write file" +
                        "\n 4. Show products" +
                        "\n 5. Exit"
                );
                System.out.println("Choose the function");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        System.out.println("Add");
                        try {
                            String addId = "";
                            String addName = "";
                            double price;
                            do {
                                System.out.print("enter id to add: ");
                                addId = scanner.nextLine();
                            }while (!Valid.checkId(addId));
                            do {
                                System.out.print("enter name to add: ");
                                addName = scanner.nextLine();
                            }while (!Valid.checkBrand(addName));
                            do {
                                System.out.print("enter price to add: ");
                                price = Double.parseDouble(scanner.nextLine());
                            }while (price<=0);
                            for (Product p : productList){
                                if (p.getId().equals(addId)){
                                    System.out.println("id is already exists");
                                    return;
                                }
                            }
                            Product product = new Product(addId,addName,price);
                            productList.add(product);
                            System.out.println("Added success");
                        }catch (NumberFormatException e){
                            System.out.println("number format false");
                        }
                        catch (Exception e){
                            System.out.println("fail valid input");
                        }
                        break;
                    case 2:
                        System.out.println("Read file");
                        try {
                            List<String> stringList = ReadAndWriteFile.readFileCSV(PRODUCT_FILE);
                            String[] arr;
                            for (String line: stringList){
                                arr=line.split(",");
                                Product products = new Product(arr[0],arr[1],Double.parseDouble(arr[2]));
                                productList.add(products);
                            }
                        } catch (IOException e) {
                            System.out.println("File read fail");
                            return;
                        }
                        break;
                    case 3:
                        System.out.println("Write file");
                        List<String> list = new ArrayList<>();
                        for (Product p : productList){
                            list.add(p.getToTXT());
                        }
                        try {
                            ReadAndWriteFile.writeListStringToCSV(PRODUCT_FILE,list,true);
                        } catch (IOException e) {
                            System.out.println("File write fail");
                            return;
                        }
                        break;
                    case 4:
                        System.out.println("Show products");
                        for (Product p : productList){
                            System.out.println(p);
                        }
                        break;
                    case 5:
                        System.out.println("Exit");
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid choose function");
                        break;
                }
            } catch (NumberFormatException e){
                System.out.println("Your choice invalid, please try again");
            } catch (Exception e) {
                System.out.println("Exception is: "+e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        displayMenu();
    }
}
