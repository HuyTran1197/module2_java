package m2_demo.vehicle.controller;

import m2_demo.vehicle.model.Car;
import m2_demo.vehicle.model.Motorbike;
import m2_demo.vehicle.model.Truck;
import m2_demo.vehicle.service.CarService;
import m2_demo.vehicle.service.MotorService;
import m2_demo.vehicle.service.TruckService;

import java.util.List;
import java.util.Scanner;

public class MainController {
    private static Scanner sc = new Scanner(System.in);
    private static CarService carService = new CarService();
    private static MotorService motorService = new MotorService();
    private static TruckService truckService = new TruckService();

    private static void confirmDelete(String id, int number) {
        System.out.println("enter Yes to delete/No to cancel:");
        String conf = sc.nextLine();
        if (conf.equalsIgnoreCase("Yes")) {
            boolean isDeleted = false;
            switch (number) {
                case 1:
                    isDeleted = carService.delete(id);
                    System.out.println("Deleted car");
                    break;
                case 2:
                    isDeleted = motorService.delete(id);
                    System.out.println("Deleted motorbike");
                    break;
                case 3:
                    isDeleted = truckService.delete(id);
                    System.out.println("Deleted truck");
                    break;
            }
            if (!isDeleted) {
                System.out.println("Delete fail");
            }
        } else {
            System.out.println("Cancel delete, return main menu");
        }
    }

    public static void displayMenu() {
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("------Vehicle Management------");
                System.out.println("Function " +
                        "\n 1. Add" +
                        "\n 2. Show list" +
                        "\n 3. Delete" +
                        "\n 4. Find" +
                        "\n 5. Exit"
                );
                System.out.println("Choose the function");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Add");
                        System.out.println("Select a number (from 1 to 3) you want to add:" +
                                "\n 1. Car" +
                                "\n 2. Motorbike" +
                                "\n 3. Truck"
                        );
                        int chooseAdd = Integer.parseInt(sc.nextLine());
                        switch (chooseAdd) {
                            case 1:
                                System.out.println("Add Car");
                                CarController.addCar();
                                break;
                            case 2:
                                System.out.println("Add Motorbike");
                                MotorController.addMotor();
                                break;
                            case 3:
                                System.out.println("Add Truck");
                                TruckController.addTruck();
                                break;
                            default:
                                System.out.println("Invalid choose");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("Show list");
                        System.out.println("Select a number (from 1 to 3) you want to show list:" +
                                "\n 1. Car" +
                                "\n 2. Motorbike" +
                                "\n 3. Truck"
                        );
                        int chooseShow = Integer.parseInt(sc.nextLine());
                        switch (chooseShow) {
                            case 1:
                                System.out.println("Show Car");
                                CarController.showListCar();
                                break;
                            case 2:
                                System.out.println("Show Motorbike");
                                MotorController.showListMotor();
                                break;
                            case 3:
                                System.out.println("Show Truck");
                                TruckController.showListTruck();
                                break;
                            default:
                                System.out.println("Invalid choose");
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("Delete");
                        System.out.print("enter id need to delete");
                        String id = sc.nextLine();
                        if (carService.findByKeyword(id) != null) {
                            confirmDelete(id, 1);
                        } else if (motorService.findByKeyword(id) != null) {
                            confirmDelete(id, 2);
                        } else if (truckService.findByKeyword(id) != null) {
                            confirmDelete(id, 3);
                        } else {
                            System.out.println("Not found id to delete");
                        }
                        break;
                    case 4:
                        System.out.println("Find");
                        System.out.print("enter keyword to find");
                        String keyword = sc.nextLine();
                        List<Car> carList = carService.findByKeyword(keyword);
                        List<Motorbike> motorbikeList = motorService.findByKeyword(keyword);
                        List<Truck> truckList = truckService.findByKeyword(keyword);
                        boolean isFound = false;
                        if (!carList.isEmpty()) {
                            CarController.showListCar();
                            isFound = true;
                        }
                        if (!motorbikeList.isEmpty()) {
                            MotorController.showListMotor();
                            isFound = true;
                        }
                        if (!truckList.isEmpty()){
                            TruckController.showListTruck();
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
                System.out.println("Your choice invalid, please try again");
            } catch (Exception e) {
                System.out.println("Exception is: " + e.getMessage());
            }
        }
    }
}
