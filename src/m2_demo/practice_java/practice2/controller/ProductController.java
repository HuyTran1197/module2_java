package m2_demo.practice_java.practice2.controller;

import m2_demo.practice_java.practice2.entity.Product;
import m2_demo.practice_java.practice2.service.ProductService;
import m2_demo.practice_java.practice2.util.Valid;
import m2_demo.practice_java.practice2.view.ProductView;

import java.util.List;
import java.util.Scanner;

public class ProductController {
    private static Scanner scanner = new Scanner(System.in);
    private static ProductService productService = new ProductService();

    private static void confirmDel(String phone) {
        System.out.print("enter yes to delete/ no to cancel: ");
        String conf = scanner.nextLine();
        if (conf.equalsIgnoreCase("Yes")) {
            boolean isDeleted = productService.delete(phone);
            if (isDeleted) {
                System.out.println("Deleted success");
            } else {
                System.out.println("Deleted fail");
            }
        } else {
            System.out.println("Canceled delete, return main menu");
        }
    }

    public static void displayMenu() {
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("-----List Phone Management-----");
                System.out.println("Function:" +
                        "\n 1. Add" +
                        "\n 2. Show list" +
                        "\n 3. Delete" +
                        "\n 4. Find" +
                        "\n 5. Exit"
                );
                System.out.println("choose the function");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("List phone");
                        productService.getList();
                        System.out.println("---Add---");
                        Product product = ProductView.inputToAdd();
                        if (product != null) {
                            boolean isAdd = productService.add(product);
                            if (isAdd) {
                                System.out.println("Added success");
                            } else {
                                System.out.println("Added fail");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Show list");
                        List<Product> phoneListList = productService.getAll();
                        ProductView.showList(phoneListList);
                        break;
                    case 3:
                        System.out.println("Delete");
                        String id = "";
                        do {
                            System.out.print("enter id to delete: ");
                            id = scanner.nextLine();
                        } while (!Valid.checkId(id));
                        if (productService.findToShow(id) != null) {
                            confirmDel(id);
                        } else {
                            System.out.println("Not found phone to delete");
                        }
                        break;
                    case 4:
                        System.out.println("Find");
                        System.out.print("enter keyword to find: ");
                        String keyword = scanner.nextLine();
                        List<Product> phoneListFind = productService.findByKeyword(keyword);
                        boolean isFound = false;
                        if (!phoneListFind.isEmpty()) {
                            ProductView.showList(phoneListFind);
                            isFound = true;
                        }
                        if (!isFound) {
                            System.out.println("Not found keyword to find");
                        }
                        break;
                    case 5:
                        System.out.println("Exit");
                        flag = false;
                        break;
                    default:
                        System.out.println("invalid choose function");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("invalid choice function");
            } catch (Exception e) {
                System.out.println("Exception is: " + e.getMessage());
            }
        }
    }
}
