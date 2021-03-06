package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/MainWindow.fxml"));
        primaryStage.setTitle("Black Jack");
        Scene main = new Scene(root, 640, 480);
        primaryStage.setScene(main);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
