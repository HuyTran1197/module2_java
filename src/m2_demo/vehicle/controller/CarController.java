package m2_demo.vehicle.controller;

import m2_demo.vehicle.model.Car;
import m2_demo.vehicle.service.CarService;
import m2_demo.vehicle.service.ICarService;
import m2_demo.vehicle.view.CarView;

import java.util.List;

public class CarController {
    private static ICarService carService = new CarService();

    public static void showListCar(){
        List<Car> carList = carService.getAll();
        CarView.showList(carList);
    }

    public static void addCar(){
        Car car = CarView.inputToAddCar();
        if (car!=null){
            boolean isSuccessAdd = carService.add(car);
            if (isSuccessAdd){
                System.out.println("Add car success");
            }else {
                System.out.println("Add car fail");
            }
        }
    }
}
