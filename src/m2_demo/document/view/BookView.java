package m2_demo.document.view;

import m2_demo.document.model.Book;
import m2_demo.document.util.Validate;

import java.util.List;
import java.util.Scanner;

public class BookView {
    private static Scanner scanner = new Scanner(System.in);

    public static void showList(List<Book> bookList){
        for (Book b : bookList){
            if (b!=null){
                System.out.println(b);
            }
        }
    }

    public static Book inputToAddBook(){
        try {
            String idDocument = "";
            do {
                System.out.print("enter id document to add (BO-XXXX): ");
                idDocument = scanner.nextLine();
            }while (!Validate.checkIdBO(idDocument));
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
            int page;
            do {
                System.out.print("enter number of page to add: ");
                page = Integer.parseInt(scanner.nextLine());
            }while (page<=0);
            String type = "";
            do {
                System.out.print("enter book type to add (Love book) :");
                type = scanner.nextLine();
            }while (!Validate.checkNameDO(type));
            return new Book(idDocument,nameDocument,year,compose,page,type);
        } catch (Exception e) {
            System.out.println("Exception is: "+e.getMessage());
        }
        return null;
    }

}
