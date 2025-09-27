package m2_demo.document.service;

import m2_demo.document.model.Book;
import m2_demo.document.repository.BookRepo;
import m2_demo.document.repository.IBookRepo;

import java.util.List;

public class BookService implements IBookService{
    private static IBookRepo bookRepo = new BookRepo();
    @Override
    public List<Book> getAll(){
        return bookRepo.getAll();
    }

    @Override
    public boolean add(Book book){
        if (book==null){
            return false;
        }
        for (Book b : bookRepo.getAll()){
            if (b.getIdDocument().equals(book.getIdDocument())){
                System.out.println("id is already exists");
                return false;
            }
        }
        List<Book> list = getAll();
        int id = 1;
        if (!list.isEmpty()){
            id = list.get(list.size()-1).getId()+1;
        }
        book.setId(id);
        return bookRepo.add(book);
    }

    @Override
    public boolean delete(String id){
        return bookRepo.delete(id);
    }

    @Override
    public List<Book> find(String name){
        return bookRepo.find(name);
    }

    public Book findByID(String id){
        List<Book> bookList = getAll();
        for (Book b : bookList){
            if (b.getIdDocument().equals(id)){
                return b;
            }
        }
        return null;
    }
}
