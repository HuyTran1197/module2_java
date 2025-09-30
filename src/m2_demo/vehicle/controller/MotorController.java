package m2_demo.vehicle.controller;

import m2_demo.vehicle.model.Motorbike;
import m2_demo.vehicle.service.IMotorService;
import m2_demo.vehicle.service.MotorService;
import m2_demo.vehicle.view.MotorView;

import java.util.List;

public class MotorController {
    private static IMotorService motorService = new MotorService();

    public static void showListMotor(){
        List<Motorbike> motorbikeList = motorService.getAll();
        MotorView.showList(motorbikeList);
    }

    public static void addMotor(){
        Motorbike motorbike = MotorView.inputToAddMotor();
        if (motorbike!=null){
            boolean isSuccessAdd = motorService.add(motorbike);
            if (isSuccessAdd){
                System.out.println("Add motor success");
            }else {
                System.out.println("Add motor fail");
            }
        }
    }
}
