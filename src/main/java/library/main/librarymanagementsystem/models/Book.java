package library.main.librarymanagementsystem.models;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String name;
    private String isbn;
    private String category;
    private List<Author> listAuthors;

    public Book(String name, String isbn ,String category,String nameAuthor) {
        this.name = name;
        this.isbn = isbn;
        this.category= category;
        listAuthors= new ArrayList<>();
        listAuthors.add(new Author(nameAuthor));
    }

    public  void addAuthor(String nameAuthor){
        listAuthors.add(new Author(nameAuthor));
    }


    @Override
    public String toString() {
        return name +
                ";" + isbn +
                ";" + category   +
                ";" + listAuthors ;
    }
}
