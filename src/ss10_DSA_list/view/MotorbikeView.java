package ss10_DSA_list.view;

import ss10_DSA_list.entity.Motorbike;
import ss10_DSA_list.service.MotorbikeService;

import java.util.List;
import java.util.Scanner;

public class MotorbikeView {
    private static Scanner scanner = new Scanner(System.in);

    public static void showList(List<Motorbike> motorbikeList) {
        for (int i = 0; i < motorbikeList.size(); i++) {
            System.out.println(motorbikeList.get(i));
        }
    }

    public static Motorbike inputToAdd() {
        try {
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
        }catch (NumberFormatException e){
            System.out.println("invalid year");
            return null;
        }catch (Exception e) {
            System.out.println("Exception is: "+e.getMessage());
            return null;
        }
    }

    public static String inputToDelete(){
        System.out.print("enter number of vehicle: ");
        return scanner.nextLine();
    }

    public static boolean confirmDelete(String numDel){
        System.out.println("do you wanna delete motorbike with number : "+numDel+" ?");
        String conf = scanner.nextLine();
        return conf.equalsIgnoreCase("yes");
    }

    public static Motorbike inputToUpdate() {
        try {
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
            return new Motorbike(numUpdate, manuUpdate, yearUpdate, ownerUpdate, capacityUpdate);
        }catch (NumberFormatException e){
            System.out.println("invalid year");
            return null;
        }catch (Exception e) {
            System.out.println("Exception is: "+e.getMessage());
            return null;
        }
    }

    public static String inputToFind() {
        System.out.print("enter number of motorbike need to find: ");
        return scanner.nextLine();
    }

    public static void showFind(Motorbike motorbike){
        System.out.println(motorbike);
    }
}