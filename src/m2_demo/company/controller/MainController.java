package m2_demo.company.controller;

import m2_demo.company.model.ElectronicProduct;
import m2_demo.company.model.FoodProduct;
import m2_demo.company.service.ElectronicService;
import m2_demo.company.service.FoodService;

import java.util.List;
import java.util.Scanner;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);
    private static ElectronicService electronicService = new ElectronicService();
    private static FoodService foodService = new FoodService();

    private static void confirmDelete(int id, int number) {
        System.out.print("enter Yes to delete/ No to cancel: ");
        String conf = scanner.nextLine();
        if (conf.equalsIgnoreCase("Yes")) {
            boolean isDeleted = false;
            switch (number) {
                case 1:
                    isDeleted = electronicService.delete(id);
                    System.out.println("deleted electronic");
                    break;
                case 2:
                    isDeleted = foodService.delete(id);
                    System.out.println("deleted food");
                    break;
            }
            if (!isDeleted) {
                System.out.println("deleted fail");
            }
        } else {
            System.out.println("Canceled delete, return main menu!");
        }
    }

    public static void displayMenu() {
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("--------Product Company Management------");
                System.out.println("Function " +
                        "\n 1. Add" +
                        "\n 2. Show list" +
                        "\n 3. Delete" +
                        "\n 4. Find" +
                        "\n 5. Exit"
                );
                System.out.println("Choose the function");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Add");
                        System.out.println("Select a number (from 1 to 2) you want to add:" +
                                "\n 1. Electronic" +
                                "\n 2. Food"
                        );
                        int chooseAdd = Integer.parseInt(scanner.nextLine());
                        switch (chooseAdd) {
                            case 1:
                                System.out.println("Add Electronic");
                                ElectronicController.addElectronic();
                                break;
                            case 2:
                                System.out.println("Add Food");
                                FoodController.addFood();
                                break;
                            default:
                                System.out.println("Invalid choose");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("Show list");
                        System.out.println("Select a number (from 1 to 2) you want to show list:" +
                                "\n 1. Electronic" +
                                "\n 2. Food"
                        );
                        int chooseShow = Integer.parseInt(scanner.nextLine());
                        switch (chooseShow) {
                            case 1:
                                System.out.println("Show Electronic");
                                ElectronicController.showList();
                                break;
                            case 2:
                                System.out.println("Show Food");
                                FoodController.showList();
                                break;
                            default:
                                System.out.println("Invalid choose");
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("Delete");
                        System.out.print("enter id need to delete");
                        int id = Integer.parseInt(scanner.nextLine());
                        if (electronicService.findToShow(id) != null) {
                            confirmDelete(id, 1);
                        } else if (foodService.findToShow(id) != null) {
                            confirmDelete(id, 2);
                        } else {
                            System.out.println("Not found id to delete");
                        }
                        break;
                    case 4:
                        System.out.println("Find");
                        System.out.print("enter keyword to find");
                        String keyword = scanner.nextLine();
                        List<ElectronicProduct> electronicProductList = electronicService.findByKeyword(keyword);
                        List<FoodProduct> foodProductList = foodService.findByKeyword(keyword);
                        boolean isFound = false;
                        if (!electronicProductList.isEmpty()) {
                            ElectronicController.showListElectronic(electronicProductList);
                            isFound = true;
                        }
                        if (!foodProductList.isEmpty()) {
                            FoodController.showListFood(foodProductList);
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
                        System.out.println("Invalid choose function");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("your choice is not true format number, please try again");
            } catch (Exception e) {
                System.out.println("Exception is: " + e.getMessage());
            }
        }
    }
}
