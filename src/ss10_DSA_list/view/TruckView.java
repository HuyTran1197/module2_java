package ss10_DSA_list.view;

import ss10_DSA_list.entity.Manufacturer;
import ss10_DSA_list.entity.Truck;

import java.util.List;
import java.util.Scanner;

public class TruckView {
    private static Scanner scanner = new Scanner(System.in);
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

    public static void showList(List<Truck> truckList){
        for (Truck t : truckList){
            if (t!=null){
                System.out.println(t);
            }
        }
    }

    public static Truck inputToAddTruck(List<Manufacturer> manufacturerList) {
        try {
            System.out.print("enter number of vehicle: ");
            String numOfVehicle = scanner.nextLine();
            System.out.print("enter manufacturer: ");
            Manufacturer manufacturer = chooseManufacturer(manufacturerList);
            System.out.print("enter year: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("enter owner of truck: ");
            String owner = scanner.nextLine();
            System.out.print("enter load: ");
            double load = Double.parseDouble(scanner.nextLine());
            return new Truck(numOfVehicle,manufacturer,year,owner,load);
        }catch (NumberFormatException e){
            System.out.println("invalid number");
            return null;
        }catch (Exception e) {
            System.out.println("Exception is: "+e.getMessage());
            return null;
        }
    }

    public static Truck inputToUpdate(List<Manufacturer> manufacturerList) {
        try {
            System.out.print("enter number of vehicle need to update: ");
            String numUpdate = scanner.nextLine();
            System.out.print("enter new manufacturer: ");
            Manufacturer manuUpdate = chooseManufacturer(manufacturerList);
            System.out.print("enter new year: ");
            int yearUpdate = Integer.parseInt(scanner.nextLine());
            System.out.print("enter new owner: ");
            String ownerUpdate = scanner.nextLine();
            System.out.print("enter new load: ");
            double loadUpdate = Double.parseDouble(scanner.nextLine());
            return new Truck(numUpdate, manuUpdate, yearUpdate, ownerUpdate, loadUpdate);
        }catch (NumberFormatException e){
            System.out.println("invalid number");
            return null;
        }catch (Exception e) {
            System.out.println("Exception is: "+e.getMessage());
            return null;
        }
    }

    public static String inputToFind() {
        System.out.print("enter number of truck need to find: ");
        return scanner.nextLine();
    }

    public static void showFind(Truck truck){
        System.out.println(truck);
    }
}
