package m2_demo.khoa_hoc.view;

import m2_demo.khoa_hoc.model.StudyCode;
import m2_demo.khoa_hoc.util.Validate;

import java.util.List;
import java.util.Scanner;

public class StudyCodeView {
    private static Scanner scanner = new Scanner(System.in);

    public static void showList(List<StudyCode> studyCodeList){
        for (StudyCode s : studyCodeList){
            if (s!=null){
                System.out.println(s);
            }
        }
    }

    public static StudyCode inputToAdd(){
        try {
            String idStudy = "";
            do {
                System.out.print("enter id study to add (CO-XXXX): ");
                idStudy = scanner.nextLine();
            }while (!Validate.checkIdCode(idStudy));
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
            String languageCode = "";
            do {
                System.out.print("enter language code to add (Java/Python/Ruby): ");
                languageCode = scanner.nextLine();
            }while (!Validate.checkLanguageCode(languageCode));
            long cost;
            do {
                System.out.print("enter cost study to add (must be bigger than 0): ");
                cost = Long.parseLong(scanner.nextLine());
            }while (cost<=0);
            return new StudyCode(idStudy,nameStudy,teacher,cost,languageCode);
        } catch (Exception e) {
            System.out.println("Exception is: " + e.getMessage());
        }
        return null;
    }
}
