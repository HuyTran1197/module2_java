package m2_demo.furama_resort.view;

import m2_demo.furama_resort.model.Facility;
import m2_demo.furama_resort.model.House;
import m2_demo.furama_resort.model.Room;
import m2_demo.furama_resort.model.Villa;
import m2_demo.furama_resort.util.Validate;

import java.util.List;
import java.util.Scanner;

public class FacilityView {
    private static Scanner scanner = new Scanner(System.in);

    public static void showList(List<Facility> facilityList){
        for (Facility f : facilityList){
            if (f!=null){
                System.out.println(f);
            }
        }
    }

    public static Villa inputToAddVilla(){
        try {
            String idSer = "";
            do {
                System.out.print("enter id service to add (SVVL-XXXX): ");
                idSer = scanner.nextLine();
            }while (!Validate.checkIdVL(idSer));
            String name = "";
            do {
                System.out.print("enter name service to add (Villa): ");
                name = scanner.nextLine();
            }while (!Validate.checkService(name));
            String rentType = "";
            do {
                System.out.print("enter rent type to add (Days or Months or Years): ");
                rentType = scanner.nextLine();
            }while (!Validate.checkService(rentType));
            String room = "";
            do {
                System.out.print("enter room standard to add (Vip/Good/Normal): ");
                room = scanner.nextLine();
            }while (!Validate.checkService(room));
            float area;
            float areaPool;
            int rentCost, max, floor;
            do {
                System.out.println("enter area and area pool to add (area must be > 30m2):");
                area = Float.parseFloat(scanner.nextLine());
                areaPool = Float.parseFloat(scanner.nextLine());
                System.out.println("enter rent cost, max person and floor to add (must be > 0)");
                rentCost = Integer.parseInt(scanner.nextLine());
                max = Integer.parseInt(scanner.nextLine());
                floor = Integer.parseInt(scanner.nextLine());
            }while (area<30.f || areaPool<30.f || rentCost<=0 || floor<=0 || max<=0 || max>=20);
            return new Villa(idSer,name,area,rentCost,max,rentType,room,areaPool,floor);
        } catch (Exception e) {
            System.out.println("Exception is: "+e.getMessage());
            return null;
        }
    }

    public static House inputToAddHouse(){
        try {
            String idSer = "";
            do {
                System.out.print("enter id service to add (SVHO-XXXX): ");
                idSer = scanner.nextLine();
            }while (!Validate.checkIdHO(idSer));
            String name = "";
            do {
                System.out.print("enter name service to add (House): ");
                name = scanner.nextLine();
            }while (!Validate.checkService(name));
            String rentType = "";
            do {
                System.out.print("enter rent type to add (Days or Months or Years): ");
                rentType = scanner.nextLine();
            }while (!Validate.checkService(rentType));
            String room = "";
            do {
                System.out.print("enter room standard to add (Vip/Good/Normal): ");
                room = scanner.nextLine();
            }while (!Validate.checkService(room));
            float area;
            int rentCost, max, floor;
            do {
                System.out.println("enter area to add (area must be > 30m2):");
                area = Float.parseFloat(scanner.nextLine());
                System.out.println("enter rent cost, max person and floor to add (must be > 0)");
                rentCost = Integer.parseInt(scanner.nextLine());
                max = Integer.parseInt(scanner.nextLine());
                floor = Integer.parseInt(scanner.nextLine());
            }while (area<30.f || rentCost<=0 || floor<=0 || max<=0 || max>=20);
            return new House(idSer,name,area,rentCost,max,rentType,room,floor);
        } catch (Exception e) {
            System.out.println("Exception is: "+e.getMessage());
            return null;
        }
    }

    public static Room inputToAddRoom(){
        try {
            String idSer = "";
            do {
                System.out.print("enter id service to add (SVRO-XXXX): ");
                idSer = scanner.nextLine();
            }while (!Validate.checkIdRO(idSer));
            String name = "";
            do {
                System.out.print("enter name service to add (Room): ");
                name = scanner.nextLine();
            }while (!Validate.checkService(name));
            String rentType = "";
            do {
                System.out.print("enter rent type to add (Hours/Days/Weeks/Months/Years): ");
                rentType = scanner.nextLine();
            }while (!Validate.checkService(rentType));
            String freeService = "";
            do {
                System.out.print("enter free service to add (Breakfast/Lunch/Dinner/Buffet/Cleaning): ");
                freeService = scanner.nextLine();
            }while (!Validate.checkService(freeService));
            float area;
            int rentCost, max;
            do {
                System.out.println("enter area to add (area must be > 30m2):");
                area = Float.parseFloat(scanner.nextLine());
                System.out.println("enter rent cost, max person to add (must be > 0)");
                rentCost = Integer.parseInt(scanner.nextLine());
                max = Integer.parseInt(scanner.nextLine());
            }while (area<30.f || rentCost<=0 || max<=0 || max>=20);
            return new Room(idSer,name,area,rentCost,max,rentType,freeService);
        } catch (Exception e) {
            System.out.println("Exception is: "+e.getMessage());
            return null;
        }
    }
}
