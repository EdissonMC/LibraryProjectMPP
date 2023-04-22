package library.main.librarymanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import library.main.librarymanagementsystem.application.LibraryController;

import java.io.IOException;

public class App extends Application {

//    @FXML
//    private Button btnStartLibrary;

    public static void main(String[] args) {
        launch();
    }


    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("app.fxml"));

        Scene scene = new Scene(fxmlLoader.load()); // scene

        primaryStage = stage; // current stage(primaryStage) is stage
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    protected void onStartButtonClick() throws IOException {
        LibraryController.changeScene();
    }
}