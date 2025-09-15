package ss10_DSA_list.controller;

import ss10_DSA_list.entity.Car;
import ss10_DSA_list.entity.Manufacturer;
import ss10_DSA_list.service.CarService;
import ss10_DSA_list.service.ICarService;
import ss10_DSA_list.view.CarView;

import java.util.List;

public class CarController {
    private static ICarService carService = new CarService();
    static void showListCar(){
        List<Car> carList = carService.findAll();
        CarView.showList(carList);
    }

    static void addCar(){
        List<Manufacturer> manufacturerList = CarService.manuList;
        Car carAdd = CarView.inputToAdd(manufacturerList);
        if (carAdd!=null){
            boolean isSuccessAdd = carService.add(carAdd);
            if (isSuccessAdd){
                System.out.println("added success");
            } else {
                System.out.println("added fail");
            }
        }
    }

    static void updateCar(){
        List<Manufacturer> manuListUpdate = CarService.manuList;
        Car carUpdate = CarView.inputToUpdate(manuListUpdate);
        boolean isSuccessUpdate = carService.update(carUpdate);
        if (isSuccessUpdate){
            System.out.println("updated success");
        } else {
            System.out.println("updated fail");
        }
    }

}
