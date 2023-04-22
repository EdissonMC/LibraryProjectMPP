package library.main.librarymanagementsystem.application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import library.main.librarymanagementsystem.data.Data;
import library.main.librarymanagementsystem.models.Book;
import library.main.librarymanagementsystem.models.LibraryMember;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MemberController implements Initializable {
    @FXML
    private ListView<String> membersListView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadMembers();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        membersListView.setFixedCellSize(50.0);
    }

    public void loadMembers() throws IOException {

        membersListView.getItems().clear();

        for(LibraryMember book: Data.requestMembers()) {
            membersListView.getItems().add(book.toString());
        }

        membersListView.refresh();
    }
}
