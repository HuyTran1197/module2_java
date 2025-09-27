package m2_demo.khoa_hoc.controller;

import m2_demo.khoa_hoc.model.Language;
import m2_demo.khoa_hoc.model.StudyCode;
import m2_demo.khoa_hoc.service.LanguageService;
import m2_demo.khoa_hoc.service.StudyCodeService;

import java.util.List;
import java.util.Scanner;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);
    private static StudyCodeService studyCodeService = new StudyCodeService();
    private static LanguageService languageService = new LanguageService();

    static void confirmDelete(String id, int number) {
        System.out.print("enter Yes to delete/No to cancel");
        String conf = scanner.nextLine();
        if (conf.equalsIgnoreCase("Yes")) {
            boolean isDeleted = false;
            switch (number) {
                case 1:
                    isDeleted = studyCodeService.delete(id);
                    System.out.println("deleted study code");
                    break;
                case 2:
                    isDeleted = languageService.delete(id);
                    System.out.println("deleted language");
                    break;
            }
            if (!isDeleted) {
                System.out.println("deleted fail");
            }
        } else {
            System.out.println("Cancel delete. Return menu !");
        }
    }

    public static void displayMenu() {
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("-------Study Management-------");
                System.out.println("Function " +
                        "\n 1. Add" +
                        "\n 2. Show list" +
                        "\n 3. Delete" +
                        "\n 4. Find" +
                        "\n 5. Exit"
                );
                System.out.println("Choose the function");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Add");
                        System.out.println("Select 1 or 2 to Add function:" +
                                "\n 1. Study Code" +
                                "\n 2. Language"
                        );
                        int chooseAdd = Integer.parseInt(scanner.nextLine());
                        switch (chooseAdd) {
                            case 1:
                                System.out.println("Study Code Add");
                                StudyCodeController.addCode();
                                break;
                            case 2:
                                System.out.println("Language Add");
                                LanguageController.addLanguage();
                                break;
                            default:
                                System.out.println("your choose is invalid");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("Show list");
                        System.out.println("Select a number (from 1 to 2) you want to show list:" +
                                "\n 1. Study code" +
                                "\n 2. Language"
                        );
                        int chooseShow = Integer.parseInt(scanner.nextLine());
                        switch (chooseShow) {
                            case 1:
                                System.out.println("Code show list function");
                                StudyCodeController.showListCode();
                                break;
                            case 2:
                                System.out.println("Language show list function");
                                LanguageController.showListLanguage();
                                break;
                            default:
                                System.out.println("invalid your choice, try again");
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("Delete");
                        System.out.print("enter id document to delete: ");
                        String idDel = scanner.nextLine();
                        if (studyCodeService.findToDelete(idDel) != null) {
                            confirmDelete(idDel, 1);
                        } else if (languageService.findToDelete(idDel) != null) {
                            confirmDelete(idDel,2);
                        } else {
                            System.out.println("Not found id to deleted");
                        }
                        break;
                    case 4:
                        System.out.println("Find");
                        System.out.print("enter key word to find: ");
                        String nameFind = scanner.nextLine();
                        List<StudyCode> studyCodeList = studyCodeService.find(nameFind);
                        List<Language> languageList = languageService.find(nameFind);
                        boolean isFind = false;
                        if (!studyCodeList.isEmpty()) {
                            StudyCodeController.showListCode(studyCodeList);
                            isFind = true;
                        }if (!languageList.isEmpty()){
                            LanguageController.showListLanguage(languageList);
                            isFind=true;
                    }
                        if (!isFind) {
                            System.out.println("Not found key word to find");
                        }
                        break;
                    case 5:
                        System.out.println("Exit");
                        flag = false;
                        break;
                    default:
                        System.out.println("Your choice invalid");
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("your choice is not true format number. Please try again");
            }
            catch (Exception e) {
                System.out.println("Exception is: " + e.getMessage());
            }
        }
    }
}
