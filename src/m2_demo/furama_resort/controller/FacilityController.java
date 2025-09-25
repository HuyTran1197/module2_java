package m2_demo.furama_resort.controller;

import m2_demo.furama_resort.model.Facility;
import m2_demo.furama_resort.model.House;
import m2_demo.furama_resort.model.Room;
import m2_demo.furama_resort.model.Villa;
import m2_demo.furama_resort.service.FacilityService;
import m2_demo.furama_resort.service.IFacilityService;
import m2_demo.furama_resort.view.FacilityView;

import java.util.List;
import java.util.Scanner;

public class FacilityController {
    private static Scanner scanner = new Scanner(System.in);
    private static IFacilityService facilityService = new FacilityService();

    static void displayMenuFacility(){
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("------Facility Management------");
                System.out.println("function" +
                        "\n 1. Display list facility" +
                        "\n 2. Add new facility" +
                        "\n 3. Display list facility maintenance" +
                        "\n 4. Return main menu"
                );
                System.out.println("Choose the function");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Display list facility");
                        List<Facility> facilityList = facilityService.getAll();
                        FacilityView.showList(facilityList);
                        break;
                    case 2:
                        System.out.println("Add new facility");
                        System.out.println("choose a number (from 1 to 3) to add:"+
                                "\n 1. Add Villa"+
                                "\n 2. Add House"+
                                "\n 3. Add Room"
                        );
                        int choose = Integer.parseInt(scanner.nextLine());
                        switch (choose){
                            case 1:
                                System.out.println("Add Villa");
                                Villa villa = FacilityView.inputToAddVilla();
                                boolean isSuccessAddVL = facilityService.add(villa);
                                if (isSuccessAddVL){
                                    System.out.println("Added Villa success");
                                }else {
                                    System.out.println("Added Villa fail");
                                }
                                break;
                            case 2:
                                System.out.println("Add House");
                                House house = FacilityView.inputToAddHouse();
                                boolean isSuccessAddHO = facilityService.add(house);
                                if (isSuccessAddHO){
                                    System.out.println("Added House success");
                                }else {
                                    System.out.println("Added House fail");
                                }
                                break;
                            case 3:
                                System.out.println("Add Room");
                                Room room = FacilityView.inputToAddRoom();
                                boolean isSuccessAddRO = facilityService.add(room);
                                if (isSuccessAddRO){
                                    System.out.println("Added Room success");
                                }else {
                                    System.out.println("Added Room fail");
                                }
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("Display list facility maintenance");
                        break;
                    case 4:
                        System.out.println("Return main menu");
                        return;
                    default:
                        System.out.println("invalid choice");
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("your choice is not true format number. Please try again");
            } catch (Exception e) {
                System.out.println("Exception is: "+e.getMessage());
            }
        }
    }
}
