package library.main.librarymanagementsystem.application;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import library.main.librarymanagementsystem.App;
import library.main.librarymanagementsystem.data.Data;
import library.main.librarymanagementsystem.models.Book;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class LibraryController implements Initializable {

    @FXML
    private ListView<String> booksList;

    @FXML
    private TextField author;

    @FXML
    private TextField book;

    @FXML
    private TextField isbn;

    @FXML
    private TextField category;

    @FXML
    private TextField search;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadBooks();
        } catch (IOException e) {
            e.printStackTrace();
        }

        booksList.setFixedCellSize(50.0);
    }

    @FXML
    protected void searchBook() throws IOException {

        String search_text = search.getText().strip().toLowerCase();
        loadBooks();
        if (search_text.length() >= 3) {
            ArrayList<String> results = new ArrayList<>();

            for(String book: booksList.getItems()) {
                if (book.toLowerCase().contains(search_text)) results.add(book);
            }

            booksList.getItems().clear();
            if (results.size() > 0) {
                for(String found_book: results) booksList.getItems().add(found_book);
                booksList.refresh();
            }
        }
    }

    @FXML
    protected void editBook() throws IOException {

        // Recovering the item selected
        ObservableList<Integer> selectedIndices = booksList.getSelectionModel().getSelectedIndices();

        // Veryfing if one item was seleted
        if (selectedIndices.size() == 1) {

            String bookToEdit = booksList.getItems().get(selectedIndices.get(0));
            String[] oldData = bookToEdit.split(";");

            System.out.println("oldData Array "+ oldData);
//            String oldIsbn = bookToEdit.split(";")[2];


            EditBookWindow dialogEditBook = new EditBookWindow(oldData[0],oldData[1],oldData[2], oldData[3] );

            String str = dialogEditBook.getResult();

            Book bookEdited = dialogEditBook.getResultBookEdited();
            System.out.printf("Data bookEdited in controller, %s %s %s %s  \n",bookEdited.getTitle() ,bookEdited.getIsbn(),bookEdited.getCategory(), bookEdited.getListAuthors() );

            if (str != null) {

                Data.updateBook(bookEdited);

                loadBooks();
                search.setText("");

            }
        }
    }

    @FXML
    protected void deleteBook() throws IOException {

        // Recovering Item Seleted
        ObservableList<Integer> selectedIndices = booksList.getSelectionModel().getSelectedIndices();

        if (selectedIndices.size() == 1) {
            String bookToEdit = booksList.getItems().get(selectedIndices.get(0));

            String oldIsbn = bookToEdit.split(";")[1];

            Data.removeBook(oldIsbn);


            loadBooks();
            search.setText("");
        }
    }

    @FXML
    protected void addItem() throws IOException {

        String book_name_text = book.getText();
        String isbn_text = isbn.getText();
        String category_text = category.getText();
        String author_text = author.getText();

        Data.createBook(book_name_text,
                        isbn_text,
                        category_text,
                        author_text);



        // reset fields
        author.setText("");
        book.setText("");
        isbn.setText("");
        category.setText("");
        // reaload the books list
        this.loadBooks();
    }

    public static ArrayList<String> listFilesForFolder(final File folder) throws IOException {
        ArrayList<String> al = new ArrayList<>();
        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            String read = Files.readAllLines(Paths.get(fileEntry.getPath())).get(0);
            al.add(read.strip());
        }
        return al;
    }



    public void loadBooks() throws IOException {
       /* Path p = Paths.get("src/main/data");
        final File folder = new File(String.valueOf(p));

        ArrayList<String> al = listFilesForFolder(folder);*/

        booksList.getItems().clear();

        // FIRST IMPLEMENTATION
//        for(String book: al) {
//            booksList.getItems().add(book);
//        }
        // SECOND IMPLEMENTATION
        for(Book book: Data.requestBooks()) {
            booksList.getItems().add(book.toString());
        }

        booksList.refresh();
    }


    public static void changeScene() throws IOException {

//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("library.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("manage-books.fxml"));
        Scene scene = new Scene(fxmlLoader.load()); // scene

        Stage stage = App.getPrimaryStage();
        stage.hide();
        stage.setTitle("Library Management System");
        stage.setScene(scene);
        stage.show();
    }

}
