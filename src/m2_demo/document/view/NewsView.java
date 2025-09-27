package m2_demo.document.view;

import m2_demo.document.model.News;
import m2_demo.document.util.Validate;

import java.util.List;
import java.util.Scanner;

public class NewsView {
    private static Scanner scanner = new Scanner(System.in);

    public static void showList(List<News> news){
        for (News n : news){
            if (n!=null){
                System.out.println(n);
            }
        }
    }

    public static News inputToAddNews(){
        try {
            String idDocument = "";
            do {
                System.out.print("enter id document to add (NE-XXXX): ");
                idDocument = scanner.nextLine();
            }while (!Validate.checkIdNEW(idDocument));
            String nameDocument = "";
            do {
                System.out.print("enter name document to add (Aaa aaa): ");
                nameDocument = scanner.nextLine();
            }while (!Validate.checkNameDO(nameDocument));
            String year = "";
            do {
                System.out.print("enter year produce to add (1YYY) : ");
                year = scanner.nextLine();
            }while (!Validate.checkYear(year));
            String compose = "";
            do {
                System.out.print("enter compose to add: ");
                compose = scanner.nextLine();
            }while (!Validate.checkName(compose));
            int numberProduce, monthProduce;
            do {
                System.out.print("enter number produce to add (number > 0): ");
                numberProduce = Integer.parseInt(scanner.nextLine());
                System.out.print("enter month produce to add: ");
                monthProduce = Integer.parseInt(scanner.nextLine());
            }while (numberProduce<=0 || monthProduce<=0);
            return new News(idDocument,nameDocument,year,compose,numberProduce,monthProduce);
        } catch (Exception e) {
            System.out.println("Exception is: "+e.getMessage());
        }
        return null;
    }
}
