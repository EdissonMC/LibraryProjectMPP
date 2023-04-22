package library.main.librarymanagementsystem.models;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String isbn;
    private String category;
    private List<Author> listAuthors;

    public Book(String title, String isbn ,String category,String nameAuthor) {
        this.title = title;
        this.isbn = isbn;
        this.category= category;
        listAuthors= new ArrayList<>();
        listAuthors.add(new Author(nameAuthor));
    }

    public  void addAuthor(String nameAuthor){
        listAuthors.add(new Author(nameAuthor));
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Author> getListAuthors() {
        return listAuthors;
    }

    public void setListAuthors(List<Author> listAuthors) {
        this.listAuthors = listAuthors;
    }

    @Override
    public String toString() {
        return title +
                ";" + isbn +
                ";" + category   +
                ";" + listAuthors ;
    }
}
