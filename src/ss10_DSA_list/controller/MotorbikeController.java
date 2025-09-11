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
                    System.out.println("List");
                    List<Motorbike> motorbikeList = motorbikeService.findAll();
                    MotorbikeView.showList(motorbikeList);
                    break;
                case 2:
                    System.out.println("Add");
                    Motorbike motorbikeAdd = MotorbikeView.inputToAdd();
                    if (motorbikeAdd!=null){
                        boolean isAdded = motorbikeService.add(motorbikeAdd);
                        System.out.println(isAdded ? "added success" : "added fail");
                    }
                    break;
                case 3:
                    System.out.println("Delete");
                    String numDel = MotorbikeView.inputToDelete();
                    boolean conf = MotorbikeView.confirmDelete(numDel);
                    if (conf){
                        boolean deleted = motorbikeService.delete(numDel);
                        System.out.println(deleted ? "deleted success" : "deleted fail");
                    } else {
                        System.out.println("canceled delete");
                    }
                    break;
                case 4:
                    System.out.println("Update");
                    Motorbike motorbikeUpdate = MotorbikeView.inputToUpdate();
                    boolean isUpdateSuccess = motorbikeService.update(motorbikeUpdate);
                    if (isUpdateSuccess){
                        System.out.println("updated success");
                    } else {
                        System.out.println("updated fail");
                    }
                    break;
                case 5:
                    System.out.println("Find");
                    String numFind = MotorbikeView.inputToFind();
                    Motorbike found = motorbikeService.find(numFind);
                    if (found!=null){
                        MotorbikeView.showFind(found);
                    } else {
                        System.out.println("not found number of vehicle");
                    }
                    break;
                default:
                    System.out.println("Return main menu");
                    flag = false;
                    break;
            }
        }
    }
}
