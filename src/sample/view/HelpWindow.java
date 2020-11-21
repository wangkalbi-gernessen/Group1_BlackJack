package sample.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

public class HelpWindow {
    @FXML
    public Button btnReturn;

    /**
     * Display a window of help.
     *
     * @param actionEvent
     * @param classObj
     */
    public static void displayHelp(ActionEvent actionEvent, Class classObj) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(classObj.getResource("/sample/view/HelpWindow.fxml"));
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            // css is not working currently due to the intelliJ license
//            scene.getStylesheets().add("sample/view/css/styles.css");
            Stage stage = new Stage();
            stage.setTitle("Help");
            stage.setScene(scene);
            stage.show();
            // Hide this current window (if this is what you want)
//            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * Close Help window and return to the main window.
     *
     * @param actionEvent
     */
    public void btnClickReturn(ActionEvent actionEvent) {
        Window w = btnReturn.getScene().getWindow();
        if (w instanceof Stage)
            ((Stage) w).close();
    }
}
