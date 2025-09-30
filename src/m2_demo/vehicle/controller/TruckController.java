package m2_demo.vehicle.controller;


import m2_demo.vehicle.model.Truck;
import m2_demo.vehicle.service.ITruckService;
import m2_demo.vehicle.service.TruckService;
import m2_demo.vehicle.view.TruckView;

import java.util.List;

public class TruckController {
    private static ITruckService truckService = new TruckService();

    public static void showListTruck(){
        List<Truck> truckList = truckService.getAll();
        TruckView.showList(truckList);
    }

    public static void addTruck(){
        Truck truck = TruckView.inputToAddTruck();
        if (truck!=null){
            boolean isSuccessAdd = truckService.add(truck);
            if (isSuccessAdd){
                System.out.println("Add truck success");
            }else {
                System.out.println("Add truck fail");
            }
        }
    }
}
