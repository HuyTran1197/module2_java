package ss10_DSA_list.view;
import ss10_DSA_list.entity.Car;
import ss10_DSA_list.entity.Manufacturer;

import java.util.List;
import java.util.Scanner;

public class CarView {
    private static Scanner scanner = new Scanner(System.in);
    public static void showList(List<Car> carList){
        for (Car c : carList){
            if (c != null){
                System.out.println(c);
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

    public static Car inputToAdd(List<Manufacturer> manufacturerList){
        try {
            System.out.print("enter number of vehicle: ");
            String numOfVehicle = scanner.nextLine();
            System.out.print("enter manufacturer: ");
            Manufacturer manufacturer = chooseManufacturer(manufacturerList);
            System.out.print("enter year: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("enter owner of car");
            String owner = scanner.nextLine();
            System.out.print("enter seats");
            int seats = Integer.parseInt(scanner.nextLine());
            System.out.print("enter kind of car");
            String type = scanner.nextLine();
            return new Car(numOfVehicle,manufacturer,year,owner,seats,type);
        }catch (NumberFormatException e){
            System.out.println("number format fail");
            return null;
        } catch (Exception e) {
            System.out.println("exception is: "+e.getMessage());
            return null;
        }
    }

    public static Car inputToUpdate(List<Manufacturer> manufacturerList){
        try {
            System.out.print("enter number of vehicle: ");
            String numOfVehicle = scanner.nextLine();
            System.out.print("enter manufacturer: ");
            Manufacturer manufacturer = chooseManufacturer(manufacturerList);
            System.out.print("enter year: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("enter owner of car");
            String owner = scanner.nextLine();
            System.out.print("enter seats");
            int seats = Integer.parseInt(scanner.nextLine());
            System.out.print("enter kind of car");
            String type = scanner.nextLine();
            return new Car(numOfVehicle,manufacturer,year,owner,seats,type);
        }catch (NumberFormatException e){
            System.out.println("number format fail");
            return null;
        } catch (Exception e) {
            System.out.println("exception is: "+e.getMessage());
            return null;
        }
    }

}
