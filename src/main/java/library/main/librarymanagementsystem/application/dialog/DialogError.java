package library.main.librarymanagementsystem.application.dialog;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class DialogError {
    public DialogError(String title, String subTitle){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(subTitle);

        ButtonType closeButton = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(closeButton);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == closeButton) {
           alert.close();
        }
    }
}
