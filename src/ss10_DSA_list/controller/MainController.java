package ss10_DSA_list.controller;


import ss10_DSA_list.service.CarService;
import ss10_DSA_list.service.MotorbikeService;
import ss10_DSA_list.service.TruckService;

import java.util.Scanner;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);

    private static CarService carService = new CarService();
    private static MotorbikeService motorbikeService = new MotorbikeService();
    private static TruckService truckService = new TruckService();
    // nhap id => neu trung thi hoi?
    // yes thi xoa luon
    static void confirmDelete(String id, int number){
        System.out.print("please enter Yes to delete and No to cancel: ");
        String conf = scanner.nextLine();
        if (conf.equalsIgnoreCase("Yes")){
            boolean isDeleted = false;
            switch (number){
                case 1:
                    isDeleted = carService.delete(id);
                    System.out.println("deleted car");
                    break;
                case 2:
                    isDeleted = motorbikeService.delete(id);
                    System.out.println("deleted motor");
                    break;
                case 3:
                    isDeleted = truckService.delete(id);
                    System.out.println("deleted truck");
                    break;
            } if (!isDeleted){
                System.out.println("deleted fail");
            }
        } else {
            System.out.println("canceled delete, return main menu !");
        }
    }

    public static void showListMain(){
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("-------Vehicle Manager Program-------");
            System.out.println("Function "+
                    "\n 1. Add"+
                    "\n 2. Show list"+
                    "\n 3. Delete"+
                    "\n 4. Update"+
                    "\n 5. Find"+
                    "\n 6. Finished"
            );
            System.out.println("Choose the function");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Add");
                    System.out.println("Select a number (from 1 to 3) you want to add:"+
                            "\n 1. Car"+
                            "\n 2. Motorbike"+
                            "\n 3. Truck");
                    int chooseAdd = Integer.parseInt(scanner.nextLine());
                    switch (chooseAdd){
                        case 1:
                            System.out.println("Car add function");
                            CarController.addCar();
                            break;
                        case 2:
                            System.out.println("Motorbike add function");
                            MotorbikeController.addMotor();
                            break;
                        case 3:
                            System.out.println("Truck add function");
                            TruckController.addTruck();
                            break;
                        default:
                            System.out.println("the number is not already exists");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Show list");
                    System.out.println("Select a number (from 1 to 3) you want to show list:"+
                            "\n 1. Car"+
                            "\n 2. Motorbike"+
                            "\n 3. Truck");
                    int chooseShow = Integer.parseInt(scanner.nextLine());
                    switch (chooseShow){
                        case 1:
                            System.out.println("Car show function");
                            CarController.showListCar();
                            break;
                        case 2:
                            System.out.println("Motorbike show function");
                            MotorbikeController.showListMotor();
                            break;
                        case 3:
                            System.out.println("Truck show function");
                            TruckController.showListTruck();
                            break;
                        default:
                            System.out.println("the number is not already exists");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Delete");
                    System.out.print("enter the number of vehicle: ");
                    String numDel = scanner.nextLine();
                    if (carService.find(numDel)!=null){
                        confirmDelete(numDel,1);
                    } else if (motorbikeService.find(numDel)!=null){
                        confirmDelete(numDel,2);
                    } else if (truckService.find(numDel)!=null) {
                        confirmDelete(numDel,3);
                    } else {
                        System.out.println("not found number of vehicle to delete");
                    }
                    break;
                case 4:
                    System.out.println("Update");
                    System.out.println("Select a number (from 1 to 3) you want to update:"+
                            "\n 1. Car"+
                            "\n 2. Motorbike"+
                            "\n 3. Truck");
                    int chooseUpdate = Integer.parseInt(scanner.nextLine());
                    switch (chooseUpdate){
                        case 1:
                            System.out.println("Car update function");
                            CarController.updateCar();
                            break;
                        case 2:
                            System.out.println("Motorbike update function");
                            MotorbikeController.updateMotor();
                            break;
                        case 3:
                            System.out.println("Truck update function");
                            TruckController.updateTruck();
                            break;
                        default:
                            System.out.println("the number is not already exists");
                            break;
                    }
                    break;
                case 5:
                    // nhap id => trung hien thi - ko thi thoi
                    System.out.println("Find");
                    System.out.print("enter number of vehicle need to find: ");
                    String numFind = scanner.nextLine();
                    if (carService.find(numFind)!=null){
                        System.out.println("-------found car id------");
                        CarController.showListCar();
                    } else if (motorbikeService.find(numFind)!=null){
                        System.out.println("-------found motor id-------");
                        MotorbikeController.showListMotor();
                    } else if (truckService.find(numFind) != null) {
                        System.out.println("------found truck id--------");
                        TruckController.showListTruck();
                    } else {
                        System.out.println("not found id to show list Vehicle");
                    }
                    break;
                default:
                    System.out.println("Program finished");
                    flag = false;
                    break;
            }
        }
    }
}
