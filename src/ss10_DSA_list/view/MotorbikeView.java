package ss10_DSA_list.view;

import ss10_DSA_list.entity.Motorbike;
import ss10_DSA_list.service.IMotorbikeService;

import java.util.List;
import java.util.Scanner;

public class MotorbikeView {
    private static Scanner scanner = new Scanner(System.in);
    public static void showList(List<Motorbike> motorbikeList){
        for (int i = 0; i < motorbikeList.size(); i++) {
            if (motorbikeList.get(i)!=null){
                System.out.println(motorbikeList.get(i));
            }
        }
    }
    public static Motorbike inputToAdd(){
        System.out.print("enter number of vehicle: ");
        String numOfVehicle = scanner.nextLine();
        System.out.print("enter manufacturer: ");
        String manufacturer = scanner.nextLine();
        System.out.print("enter year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("enter owner of car: ");
        String owner = scanner.nextLine();
        System.out.print("enter capacity: ");
        String capacity = scanner.nextLine();
        return new Motorbike(numOfVehicle,manufacturer,year,owner,capacity);
    }
    public static void inputToDelete(IMotorbikeService motorbikeService){
        System.out.print("enter number of vehicle need to delete: ");
        String numDel = scanner.nextLine();
        System.out.println("do you wanna delete product has number of motorbike is: "+numDel+" ?");
        String conf = scanner.nextLine();
        if (conf.equals("yes")){
            boolean accept = motorbikeService.delete(numDel);
            if (accept){
                System.out.println("deleted success");
            }else {
                System.out.println("not found number of motorbike");
            }
        } else {
            System.out.println("canceled delete");
        }
    }
    public static Motorbike inputToUpdate(){
        System.out.print("enter number of vehicle need to update: ");
        String numUpdate = scanner.nextLine();
        System.out.print("enter new manufacturer: ");
        String manuUpdate = scanner.nextLine();
        System.out.print("enter new year: ");
        int yearUpdate = Integer.parseInt(scanner.nextLine());
        System.out.print("enter new owner: ");
        String ownerUpdate = scanner.nextLine();
        System.out.print("enter new capacity: ");
        String capacityUpdate = scanner.nextLine();
        return new Motorbike(numUpdate,manuUpdate,yearUpdate,ownerUpdate,capacityUpdate);
    }
}
