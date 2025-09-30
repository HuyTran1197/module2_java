package m2_demo.vehicle.view;

import m2_demo.vehicle.model.Motorbike;
import m2_demo.vehicle.util.ValidVE;

import java.util.List;
import java.util.Scanner;

public class MotorView {
    private static Scanner scanner = new Scanner(System.in);

    public static void showList(List<Motorbike> motorbikeList){
        for (Motorbike m  : motorbikeList){
            if (m!=null){
                System.out.println(m);
            }
        }
    }

    public static Motorbike inputToAddMotor(){
        try {
            String idVehicle = "";
            do {
                System.out.print("enter id vehicle to add (V-XXXX): ");
                idVehicle = scanner.nextLine();
            }while (!ValidVE.checkId(idVehicle));
            String brand = "";
            do {
                System.out.print("enter brand to add (Yamaha/Honda): ");
                brand = scanner.nextLine();
            }while (!ValidVE.checkBrand(brand));
            int year, engineCapacity;
            double price;
            do {
                System.out.println("enter year + engine + price to add:");
                year = Integer.parseInt(scanner.nextLine());
                engineCapacity = Integer.parseInt(scanner.nextLine());
                price = Double.parseDouble(scanner.nextLine());
            }while (year<1900 || engineCapacity<=0 || price<=0);
            return new Motorbike(idVehicle,brand,year,price,engineCapacity);
        }catch (NumberFormatException e){
            System.out.println("number format false");
        }
        catch (Exception e){
            System.out.println("fail valid input");
        }
        return null;
    }
}
