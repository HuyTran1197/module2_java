package m2_demo.exam_m2.controller;

import m2_demo.exam_m2.model.PhoneList;
import m2_demo.exam_m2.service.PhoneListService;
import m2_demo.exam_m2.util.Valid;
import m2_demo.exam_m2.view.PhoneView;

import java.util.List;
import java.util.Scanner;

public class PhoneListController {
    private static Scanner scanner = new Scanner(System.in);
    private static PhoneListService phoneListService = new PhoneListService();

    private static void confirmDel(String phone) {
        System.out.print("enter yes to delete/ no to cancel: ");
        String conf = scanner.nextLine();
        if (conf.equalsIgnoreCase("Yes")) {
            boolean isDeleted = phoneListService.delete(phone);
            if (isDeleted) {
                System.out.println("Deleted success");
            } else {
                System.out.println("Deleted fail");
            }
        } else {
            System.out.println("Canceled delete, return main menu");
        }
    }

    public static void displayMenu() {
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("-----List Phone Management-----");
                System.out.println("Function:" +
                        "\n 1. Add" +
                        "\n 2. Show list" +
                        "\n 3. Delete" +
                        "\n 4. Edit" +
                        "\n 5. Find" +
                        "\n 6. Read" +
                        "\n 7. Write" +
                        "\n 8. Exit"
                );
                System.out.println("choose the function");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("List phone");
                        phoneListService.getList();
                        System.out.println("---Add---");
                        PhoneList phoneList = PhoneView.inputToAdd();
                        if (phoneList != null) {
                            boolean isAdd = phoneListService.add(phoneList);
                            if (isAdd) {
                                System.out.println("Added success");
                            } else {
                                System.out.println("Added fail");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Show list");
                        List<PhoneList> phoneListList = phoneListService.getAll();
                        PhoneView.showList(phoneListList);
                        break;
                    case 3:
                        System.out.println("Delete");
                        String phone = "";
                        do {
                            System.out.print("enter phone to delete: ");
                            phone = scanner.nextLine();
                        } while (!Valid.checkPhone(phone));
                        if (phoneListService.findToShow(phone) != null) {
                            confirmDel(phone);
                        } else {
                            System.out.println("Not found phone to delete");
                        }
                        break;
                    case 4:
                        System.out.println("Edit");
                        PhoneList phoneListEdit = PhoneView.inputToEdit();
                        boolean isSuccessEdit = phoneListService.edit(phoneListEdit);
                        if (isSuccessEdit) {
                            System.out.println("Edited success");
                        } else {
                            System.out.println("Edited fail");
                        }
                        break;
                    case 5:
                        System.out.println("Find");
                        System.out.print("enter keyword to find: ");
                        String keyword = scanner.nextLine();
                        List<PhoneList> phoneListFind = phoneListService.findByKeyword(keyword);
                        boolean isFound = false;
                        if (!phoneListFind.isEmpty()) {
                            PhoneView.showList(phoneListFind);
                            isFound = true;
                        }
                        if (!isFound) {
                            System.out.println("Not found keyword to find");
                        }
                        break;
                    case 6:
                        System.out.println("Read");

                        break;
                    case 7:
                        System.out.println("Write");
                        break;
                    case 8:
                        System.out.println("Exit");
                        flag = false;
                        break;
                    default:
                        System.out.println("invalid choose function");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("invalid choice function");
            } catch (Exception e) {
                System.out.println("Exception is: " + e.getMessage());
            }
        }
    }
}
