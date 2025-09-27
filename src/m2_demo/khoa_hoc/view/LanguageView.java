package m2_demo.khoa_hoc.view;

import m2_demo.khoa_hoc.model.Language;
import m2_demo.khoa_hoc.util.Validate;

import java.util.List;
import java.util.Scanner;

public class LanguageView {
    private static Scanner scanner = new Scanner(System.in);

    public static void showList(List<Language> list){
        for (Language l : list){
            if (l!=null){
                System.out.println(l);
            }
        }
    }

    public static Language inputToAddLanguage(){
        try {
            String idStudy = "";
            do {
                System.out.print("enter id study to add (LA-XXXX): ");
                idStudy = scanner.nextLine();
            }while (!Validate.checkIdLanguage(idStudy));
            String nameStudy = "";
            do {
                System.out.print("enter name study to add (Full stacks/Back end/Front end): ");
                nameStudy = scanner.nextLine();
            }while (!Validate.checkNameStudy(nameStudy));
            String teacher = "";
            do {
                System.out.print("enter teacher name to add (Nguyen Van A): ");
                teacher = scanner.nextLine();
            }while (!Validate.checkNameTeacher(teacher));
            String language = "";
            do {
                System.out.print("enter language teach to add (English/Viet/Spain,...): ");
                language = scanner.nextLine();
            }while (!Validate.checkLanguageCode(language));
            String level = "";
            do {
                System.out.print("enter level to add (A1/A2,...): ");
                level = scanner.nextLine();
            }while (!Validate.checkLevel(level));
            long cost;
            do {
                System.out.print("enter cost to add (must be bigger than 0): ");
                cost = Long.parseLong(scanner.nextLine());
            }while (cost<=0);
            return new Language(idStudy,nameStudy,teacher,cost,language,level);
        } catch (Exception e) {
            System.out.println("Exception is: "+e.getMessage());
        }
        return null;
    }
}
