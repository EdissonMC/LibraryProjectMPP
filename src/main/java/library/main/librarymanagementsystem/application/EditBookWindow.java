package library.main.librarymanagementsystem.application;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import library.main.librarymanagementsystem.models.Book;

import java.util.Optional;

public class EditBookWindow {

    private String result;
    private Book bookEdited;
    public String getResult() {
        return this.result;
    }

    public Book getResultBookEdited() {
        return this.bookEdited;
    }

    public EditBookWindow(String nameBookData, String isbnData, String categoryData, String autorData) {

        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Edit Book");
        dialog.setHeaderText("Edit book");

        ButtonType confirm = new ButtonType("Edit");
        dialog.getDialogPane().getButtonTypes().add(confirm);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20,150,10,10));

//        TextField author = new TextField();
//        author.setPromptText("Author");

        TextField title = new TextField();
//        title.setPromptText(nameBookData);
        title.setText(nameBookData);
//        title.setPromptText("Title");

        TextField isbn = new TextField();
//        isbn.setPromptText(isbnData);
        isbn.setText(isbnData);
//        isbn.setPromptText("ISBN");

        TextField category = new TextField();
//        category.setPromptText(categoryData);
        category.setText(categoryData);
//        category.setPromptText("Category");

//        grid.add(new Label("Author:"), 0, 0);
//        grid.add(author, 1, 0);

        grid.add(new Label("Title:"), 0, 1);
        grid.add(title, 1, 1);
//
//        grid.add(new Label("ISBN:"), 0, 2);
//        grid.add(isbn, 1, 2);

        grid.add(new Label("Category:"), 0, 3);
        grid.add(category, 1, 3);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == confirm) {
//                return author.getText() + ";" + title.getText() + ";" + isbn.getText() + ";" + category.getText();
//                return autorData + ";" + title.getText() + ";" + isbn.getText() + ";" + category.getText();
                return autorData + ";" + title.getText() + ";" + isbnData + ";" + category.getText();
            }
            return null;
        });

        Optional<String> rslt = dialog.showAndWait();

        if (rslt.isPresent() ) {
            System.out.printf("Data book updated, %s %s %s %s  \n",title.getText(),isbn.getText(),category.getText(),autorData);
            this.bookEdited = new Book(title.getText(),isbn.getText(),category.getText(),autorData);
            this.result = rslt.get();
        }
        else this.result = null;

//        if (rslt.isPresent() ) {
//            this.result = rslt.get();
//        }
//        else this.result = null;
    }
}
