package it.unibo.tankBattle.view.resources.layoutControllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TutorialController {

    @FXML
    private Button backButton;

    @FXML
    private void back(ActionEvent event) {
        try {
            Node node = (Node)event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../layout/mainScene.fxml"));
            Scene tutorial = new Scene(fxmlLoader.load(), 600, 400);
            stage.setScene(tutorial);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
