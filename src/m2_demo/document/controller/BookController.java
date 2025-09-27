package m2_demo.document.controller;

import m2_demo.document.model.Book;
import m2_demo.document.service.BookService;
import m2_demo.document.service.IBookService;
import m2_demo.document.view.BookView;

import java.util.List;

public class BookController {
    private static IBookService bookService = new BookService();

    static void showListBook(){
        List<Book> bookList = bookService.getAll();
        BookView.showList(bookList);
    }

    static void showListBook(List<Book> bookList){
        BookView.showList(bookList);
    }

    static void addBook(){
        Book book = BookView.inputToAddBook();
        if (book!=null){
            boolean isSuccessAdd = bookService.add(book);
            if (isSuccessAdd){
                System.out.println("Added book success");
            } else {
                System.out.println("Added book fail");
            }
        }
    }
}
