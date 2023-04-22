package library.main.librarymanagementsystem;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import library.main.librarymanagementsystem.application.LibraryController;

import java.io.IOException;

public class HelloApplication extends Application {

//    @FXML
//    private Button btnStartLibrary;

    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load()); // scene

//      btnStartLibrary.setOnAction(new EventHandler<ActionEvent>() {
//          @Override
//          public void handle(ActionEvent actionEvent) {
//              try {
//                  LibraryController.changeScene();
//              } catch (IOException e) {
//                  throw new RuntimeException(e);
//              }
//          }
//      });

//        btnStartLibrary.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//               System.out.println("click");
//            }
//        });

        primaryStage = stage; // current stage(primaryStage) is stage
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}