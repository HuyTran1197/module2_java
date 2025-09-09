package ss10_DSA_list.view;

import ss10_DSA_list.entity.Car;
import ss10_DSA_list.entity.Truck;
import ss10_DSA_list.service.ITruckService;

import java.util.List;
import java.util.Scanner;

public class TruckView {
    private static Scanner scanner = new Scanner(System.in);
    public static void showList(List<Truck> truckList){
        for (int i = 0; i < truckList.size(); i++) {
            if (truckList.get(i)!=null){
                System.out.println(truckList.get(i));
            }
        }
    }
    public static Truck inputToAdd(){
        System.out.print("enter number of vehicle: ");
        String numOfVehicle = scanner.nextLine();
        System.out.print("enter manufacturer: ");
        String manufacturer = scanner.nextLine();
        System.out.print("enter year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("enter owner of car: ");
        String owner = scanner.nextLine();
        System.out.print("enter load: ");
        double load = Double.parseDouble(scanner.nextLine());
        return new Truck(numOfVehicle,manufacturer,year,owner,load);
    }
    public static void inputToDelete(ITruckService truckService){
        System.out.print("enter number of vehicle: ");
        String numDel = scanner.nextLine();
        System.out.println("do you wanna delete product has number of car is: "+numDel+" ?");
        String conf = scanner.nextLine();
        if (conf.equals("yes")){
            boolean accept = truckService.delete(numDel);
            if (accept){
                System.out.println("deleted success");
            } else{
                System.out.println("not found number of vehicle");
            }
        } else{
            System.out.println("canceled delete");
        }
    }
    public static Truck inputToUpdate(){
        System.out.print("enter number of vehicle need to update: ");
        String numUpdate = scanner.nextLine();
        System.out.print("enter new manufacturer: ");
        String manuUpdate = scanner.nextLine();
        System.out.print("enter new year: ");
        int yearUpdate = Integer.parseInt(scanner.nextLine());
        System.out.print("enter new owner: ");
        String ownerUpdate = scanner.nextLine();
        System.out.print("enter new load: ");
        double loadUpdate = Double.parseDouble(scanner.nextLine());
        return new Truck(numUpdate,manuUpdate,yearUpdate,ownerUpdate, loadUpdate);
    }
}
