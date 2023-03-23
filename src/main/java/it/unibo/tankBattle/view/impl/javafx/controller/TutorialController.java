package it.unibo.tankBattle.view.impl.javafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TutorialController {

    private Scene prevScene;

    @FXML
    private Button backButton;

    @FXML
    private void back(ActionEvent event) {
            Node node = (Node)event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(prevScene);
    }

    public void setPreviousScene (Scene prevScene){
        this.prevScene = prevScene;
    }

}
