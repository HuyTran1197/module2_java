package ss10_DSA_list.controller;

import ss10_DSA_list.entity.Manufacturer;
import ss10_DSA_list.entity.Truck;
import ss10_DSA_list.service.ITruckService;
import ss10_DSA_list.service.TruckService;
import ss10_DSA_list.view.TruckView;

import java.util.List;

public class TruckController {
    private static ITruckService truckService = new TruckService();

    static void showListTruck(){
        List<Truck> truckList = truckService.findAll();
        TruckView.showList(truckList);
    }

    static void addTruck(){
        List<Manufacturer> manufacturerList = TruckService.manuList;
        Truck truckAdd = TruckView.inputToAddTruck(manufacturerList);
        if (truckAdd!=null){
            boolean isSuccessAdd = truckService.add(truckAdd);
            if (isSuccessAdd){
                System.out.println("added success");
            } else {
                System.out.println("added fail");
            }
        }
    }

    static void updateTruck(){
        List<Manufacturer> manuListUpdate = TruckService.manuList;
        Truck truckUpdate = TruckView.inputToUpdate(manuListUpdate);
        boolean isSuccessUpdate = truckService.update(truckUpdate);
        if (isSuccessUpdate){
            System.out.println("updated success");
        } else {
            System.out.println("updated fail");
        }
    }

    static void findTruck(){
        System.out.println("Find:");
        String numFind = TruckView.inputToFind();
        Truck found = truckService.find(numFind);
        if (found!=null){
            TruckView.showFind(found);
        } else {
            System.out.println("not found number of vehicle to find");
        }
    }
}
