package ss10_DSA_list.view;

import ss10_DSA_list.entity.Manufacturer;
import ss10_DSA_list.entity.Motorbike;

import java.util.List;
import java.util.Scanner;

public class MotorbikeView {
    private static Scanner scanner = new Scanner(System.in);

    public static void showList(List<Motorbike> motorbikeList){
        for (Motorbike m : motorbikeList){
            if (m!=null){
                System.out.println(m);
            }
        }
    }

    public static Manufacturer chooseManufacturer(List<Manufacturer> manufacturerList){
        System.out.println("choose manufacturer list");
        for (int i = 0; i < manufacturerList.size(); i++) {
            System.out.println((i+1)+"-"+manufacturerList.get(i).getName());
        }
        int choice = -1;
        while (choice<1 || choice > manufacturerList.size()){
            try {
                System.out.println("enter choice (1-"+manufacturerList.size()+"): ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("number format fail");
            }
        }
        return manufacturerList.get(choice-1);
    }

    public static Motorbike inputToAddMotor(List<Manufacturer> manufacturerList) {
        try {
            System.out.print("enter number of vehicle: ");
            String numOfVehicle = scanner.nextLine();
            System.out.print("enter manufacturer: ");
            Manufacturer manufacturer = chooseManufacturer(manufacturerList);
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

    public static Motorbike inputToUpdate(List<Manufacturer> manufacturerList) {
        try {
            System.out.print("enter number of vehicle need to update: ");
            String numUpdate = scanner.nextLine();
            System.out.print("enter new manufacturer: ");
            Manufacturer manuUpdate = chooseManufacturer(manufacturerList);
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