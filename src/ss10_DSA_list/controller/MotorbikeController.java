package ss10_DSA_list.controller;

import ss10_DSA_list.entity.Manufacturer;
import ss10_DSA_list.entity.Motorbike;
import ss10_DSA_list.service.IMotorbikeService;
import ss10_DSA_list.service.MotorbikeService;
import ss10_DSA_list.view.MotorbikeView;

import java.util.List;

public class MotorbikeController {
    private static IMotorbikeService motorbikeService = new MotorbikeService();

    static void showListMotor(){
        List<Motorbike> motorbikeList = motorbikeService.findAll();
        MotorbikeView.showList(motorbikeList);
    }

    static void addMotor(){
        List<Manufacturer> manufacturerList = MotorbikeService.manuList;
        Motorbike motorbikeAdd = MotorbikeView.inputToAddMotor(manufacturerList);
        if (motorbikeAdd!=null){
            boolean isSuccessAdd = motorbikeService.add(motorbikeAdd);
            if (isSuccessAdd){
                System.out.println("added success");
            } else {
                System.out.println("added fail");
            }
        }
    }

    static void updateMotor(){
        List<Manufacturer> manuListUpdate = MotorbikeService.manuList;
        Motorbike motorbikeUpdate = MotorbikeView.inputToUpdate(manuListUpdate);
        boolean isSuccessUpdate = motorbikeService.update(motorbikeUpdate);
        if (isSuccessUpdate){
            System.out.println("updated success");
        } else {
            System.out.println("updated fail");
        }
    }

    static void findMotor(){
        System.out.println("Find");
        String numFind = MotorbikeView.inputToFind();
        Motorbike found = motorbikeService.find(numFind);
        if (found!=null){
            MotorbikeView.showFind(found);
        } else {
            System.out.println("not found number of vehicle to find");
        }
    }
}
