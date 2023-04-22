package library.main.librarymanagementsystem.data;

import library.main.librarymanagementsystem.models.Book;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Book> listBooks = new ArrayList<>();

    static{
        Book book1= new Book("Book1","123", "categoryX","autorBook1");
        Book book2= new Book("Book2","124", "categoryX","autorBook2");
        Book book3= new Book("Book3","125", "categoryX","autorBook3");

        listBooks.add(book1);
        listBooks.add(book2);
        listBooks.add(book3);
    }
    public Data() {

    }

    public static void main(String[] args) {

    }

    public static   List<Book> requestBooks(){
        return listBooks;
    }

    public static boolean createBook(String nameBook, String isbn ,String category,String nameAuthor){
        Book book= new Book(nameBook,isbn, category,nameAuthor);
        listBooks.add(book);
        return true;
    };
}
