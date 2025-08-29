package ss10_DSA_list.controller;

import ss10_DSA_list.entity.Car;
import ss10_DSA_list.service.CarService;
import ss10_DSA_list.service.ICarService;
import ss10_DSA_list.view.CarView;

import java.util.List;
import java.util.Scanner;

public class CarController {
    static void showList() {
        ICarService carService = new CarService();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("---Car manager---");
            System.out.println("function: " +
                    "\n 1. List" +
                    "\n 2. Add" +
                    "\n 3. Delete" +
                    "\n 4. Update" +
                    "\n 5. Return main menu"
            );
            System.out.println("choose function");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("List");
                    List<Car> carList = carService.findAll();
                    CarView.showList(carList);
                    break;
                case 2:
                    System.out.println("Add");
                    Car carAdd = CarView.inputToAdd();
                    carService.add(carAdd);
                    break;
                case 3:
                    System.out.println("Delete");
                    CarView.inputToDelete(carService);
                    break;
                case 4:
                    System.out.println("Update");
                    Car carUpdate = CarView.inputToUpdate();
                    boolean isCheckUpdate = carService.update(carUpdate);
                    if (!isCheckUpdate) {
                        System.out.println("failed update");
                    } else {
                        System.out.println("success updated");
                    }
                    break;
                default:
                    System.out.println("Returned main menu");
                    flag = false;
                    break;
            }
        }
    }
}
