package m2_demo.document.repository;

import m2_demo.document.model.Book;
import m2_demo.document.util.ReadAndWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookRepo implements IBookRepo{
    private final String BOOK_FILE = "src/m2_demo/document/data/book.csv";

    @Override
    public List<Book> getAll(){
        List<Book> bookList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFile.readFileCSV(BOOK_FILE);
            String[] arr;
            for (String line : stringList){
                arr=line.split(",");
                Book book = new Book(Integer.parseInt(arr[0]),
                        arr[1],
                        arr[2],
                        arr[3],
                        arr[4],
                        Integer.parseInt(arr[5]),
                        arr[6]
                        );
                bookList.add(book);
            }
        } catch (IOException e) {
            System.out.println("file read fail");
        }
        return bookList;
    }

    @Override
    public boolean add(Book book){
        List<String> list = new ArrayList<>();
        list.add(book.getInfoCSV());
        try {
            ReadAndWriteFile.writeListStringToCSV(BOOK_FILE,list,true);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String id){
        boolean isSuccessDelete = false;
        List<Book> bookList = getAll();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getIdDocument().equals(id)){
                bookList.remove(i);
                isSuccessDelete = true;
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (Book b : bookList){
            stringList.add(b.getInfoCSV());
        }
        try {
            ReadAndWriteFile.writeListStringToCSV(BOOK_FILE,stringList,false);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return isSuccessDelete;
    }

    @Override
    public List<Book> find(String name){
        List<Book> bookList = getAll();
        List<Book> newList = new ArrayList<>();
        for (Book b : bookList){
            if (b.getIdDocument().equalsIgnoreCase(name)){
                newList.add(b);
                return newList;
            }
        }
        for (Book b : bookList){
            if (b.getNameDocument().toLowerCase().contains(name.toLowerCase())){
                newList.add(b);
            }
        }
        return newList;
    }
}
