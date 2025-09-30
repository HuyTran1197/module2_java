package m2_demo.vehicle.view;

import m2_demo.vehicle.model.Truck;
import m2_demo.vehicle.util.ValidVE;

import java.util.List;
import java.util.Scanner;

public class TruckView {
    private static Scanner scanner = new Scanner(System.in);

    public static void showList(List<Truck> truckList){
        for (Truck t  : truckList){
            if (t!=null){
                System.out.println(t);
            }
        }
    }

    public static Truck inputToAddTruck(){
        try {
            String idVehicle = "";
            do {
                System.out.print("enter id vehicle to add (V-XXXX): ");
                idVehicle = scanner.nextLine();
            }while (!ValidVE.checkId(idVehicle));
            String brand = "";
            do {
                System.out.print("enter brand to add (Yamaha/Mercedes): ");
                brand = scanner.nextLine();
            }while (!ValidVE.checkBrand(brand));
            int year;
            double price, loadCapacity;
            do {
                System.out.println("enter year + price + load capcity to add:");
                year = Integer.parseInt(scanner.nextLine());
                price = Double.parseDouble(scanner.nextLine());
                loadCapacity = Double.parseDouble(scanner.nextLine());
            }while (year<1900 || loadCapacity<=0 || price<=0);
            return new Truck(idVehicle,brand,year,price,loadCapacity);
        }catch (NumberFormatException e){
            System.out.println("number format false");
        }
        catch (Exception e){
            System.out.println("fail valid input");
        }
        return null;
    }
}
