package m2_demo.document.controller;

import m2_demo.document.model.Book;
import m2_demo.document.model.News;
import m2_demo.document.service.BookService;
import m2_demo.document.service.NewsService;

import java.util.List;
import java.util.Scanner;

public class DocumentController {
    private static Scanner scanner = new Scanner(System.in);
    private static BookService bookService = new BookService();
    private static NewsService newsService = new NewsService();

    static void confirmDelete(String id, int number){
        System.out.print("please enter Yes to delete / No to cancel: ");
        String conf = scanner.nextLine();
        if (conf.equalsIgnoreCase("Yes")){
            boolean isDeleted = false;
            switch (number){
                case 1:
                    isDeleted = bookService.delete(id);
                    System.out.println("deleted book");
                    break;
                case 2:
                    isDeleted = newsService.delete(id);
                    System.out.println("deleted news");
                    break;
            } if (!isDeleted){
                System.out.println("deleted fail");
            }
        } else {
            System.out.println("canceled delete, return main menu !");
        }
    }

    public static void displayMenu(){
        boolean flag = true;
        while (flag){
            try {
                System.out.println("------Document Management------");
                System.out.println("Function "+
                        "\n 1. Add"+
                        "\n 2. Show list"+
                        "\n 3. Delete"+
                        "\n 4. Find"+
                        "\n 5. Exit"
                );
                System.out.println("Choose the function");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Add");
                        System.out.println("Select a number (from 1 to 2) you want to add:" +
                                "\n 1. Book" +
                                "\n 2. News"
                        );
                        int chooseAdd = Integer.parseInt(scanner.nextLine());
                        switch (chooseAdd) {
                            case 1:
                                System.out.println("Book add function");
                                BookController.addBook();
                                break;
                            case 2:
                                System.out.println("News add function");
                                NewsController.addNews();
                                break;
                            default:
                                System.out.println("the number is not already exists");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("Show list");
                        System.out.println("Select a number (from 1 to 2) you want to show list:" +
                                "\n 1. Book" +
                                "\n 2. News"
                        );
                        int chooseShow = Integer.parseInt(scanner.nextLine());
                        switch (chooseShow) {
                            case 1:
                                System.out.println("Book show list function");
                                BookController.showListBook();
                                break;
                            case 2:
                                System.out.println("News show list function");
                                NewsController.showListNews();
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
                        if (bookService.findByID(idDel)!=null){
                            confirmDelete(idDel,1);
                        } else if (newsService.findByID(idDel) != null) {
                            confirmDelete(idDel,2);
                        } else {
                            System.out.println("Not found id to deleted");
                        }
                        break;
                    case 4:
                        System.out.println("Find");
                        System.out.print("enter key word to find: ");
                        String nameFind = scanner.nextLine();
                        List<Book> bookList = bookService.find(nameFind);
                        List<News> newsList = newsService.find(nameFind);
                        boolean isFind = false;
                        if (!bookList.isEmpty()){
                            BookController.showListBook(bookList);
                            isFind = true;
                        }if (!newsList.isEmpty()) {
                            NewsController.showListNews(newsList);
                            isFind = true;
                        } if (!isFind){
                        System.out.println("Not found key word to find");
                    }
                        break;
                    case 5:
                        System.out.println("Exit");
                        flag = false;
                        break;
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
