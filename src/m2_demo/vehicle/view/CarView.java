package m2_demo.vehicle.view;

import m2_demo.vehicle.model.Car;
import m2_demo.vehicle.util.ValidVE;

import java.util.List;
import java.util.Scanner;

public class CarView {
    private static Scanner scanner = new Scanner(System.in);

    public static void showList(List<Car> carList){
        for (Car c : carList){
            if (c!=null){
                System.out.println(c);
            }
        }
    }

    public static Car inputToAddCar(){
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
            int year, seats;
            double price;
            do {
                System.out.println("enter year + seats + price to add:");
                year = Integer.parseInt(scanner.nextLine());
                seats = Integer.parseInt(scanner.nextLine());
                price = Double.parseDouble(scanner.nextLine());
            }while (year<1900 || seats<=0 || price<=0);
            String fuelType = "";
            do {
                System.out.print("enter fuel type to add: ");
                fuelType = scanner.nextLine();
            }while (!ValidVE.checkType(fuelType));
            return new Car(idVehicle,brand,year,price,seats,fuelType);
        }catch (NumberFormatException e){
            System.out.println("number format false");
        }
        catch (Exception e){
            System.out.println("fail valid input");
        }
        return null;
    }
}
