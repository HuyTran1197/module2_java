package ss10_DSA_list.controller;

import ss10_DSA_list.entity.Motorbike;
import ss10_DSA_list.service.IMotorbikeService;
import ss10_DSA_list.service.MotorbikeService;
import ss10_DSA_list.view.MotorbikeView;

import java.util.List;
import java.util.Scanner;

public class MotorbikeController {
    static void showList(){
        IMotorbikeService motorbikeService = new MotorbikeService();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("-----Motorbike Manager-----");
            System.out.println("Function: "+
                    "\n 1. List"+
                    "\n 2. Add"+
                    "\n 3. Delete"+
                    "\n 4. Update"+
                    "\n 5. Find"+
                    "\n 6. Return main menu"
            );
            System.out.println("Choose function");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("list");
//                    List<Motorbike> motorbikeList = motorbikeService.findAll();
//                    MotorbikeView.showList(motorbikeList);
                    break;
            }
        }
    }
}
