package ss10_DSA_list.view;
import ss10_DSA_list.entity.Car;
import ss10_DSA_list.service.ICarService;

import java.util.List;
import java.util.Scanner;

public class CarView {
    private static Scanner scanner = new Scanner(System.in);
    public static void showList(List<Car> carList){
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i)!=null){
            System.out.println(carList.get(i));
            }
        }
    }
    public static Car inputToAdd(){
        System.out.print("enter number of vehicle: ");
        String numOfVehicle = scanner.nextLine();
        System.out.print("enter manufacturer: ");
        String manufacturer = scanner.nextLine();
        System.out.print("enter year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("enter owner of car");
        String owner = scanner.nextLine();
        System.out.print("enter seats");
        int seats = Integer.parseInt(scanner.nextLine());
        System.out.print("enter kind of car");
        String type = scanner.nextLine();
        return new Car(numOfVehicle,manufacturer,year,owner,seats,type);
    }
    public static void inputToDelete(ICarService carService){
        System.out.print("enter number of vehicle: ");
        String numDel = scanner.nextLine();
        System.out.println("do you wanna delete product has number of car is: "+numDel+" ?");
        String conf = scanner.nextLine();
        if (conf.equals("yes")){
            boolean accept = carService.delete(numDel);
            if (accept){
                System.out.println("deleted success");
            } else{
                System.out.println("not found number of vehicle");
            }
        } else{
            System.out.println("canceled delete");
        }
    }
    public static Car inputToUpdate(){
        System.out.print("enter number of vehicle need to update: ");
        String numUpdate = scanner.nextLine();
        System.out.print("enter new manufacturer: ");
        String manuUpdate = scanner.nextLine();
        System.out.print("enter new year: ");
        int yearUpdate = Integer.parseInt(scanner.nextLine());
        System.out.print("enter new owner: ");
        String ownerUpdate = scanner.nextLine();
        return new Car(numUpdate,manuUpdate,yearUpdate,ownerUpdate, CarView.inputToUpdate().getSeats(), CarView.inputToUpdate().getType());
    }
}
