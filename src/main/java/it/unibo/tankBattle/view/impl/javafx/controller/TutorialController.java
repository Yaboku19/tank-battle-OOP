package it.unibo.tankBattle.view.impl.javafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TutorialController {

    private Scene prev;

    @FXML
    private Button backButton;

    @FXML
    private void back(ActionEvent event) {
        /*try {*/
            /*
            FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("layout/mainScene.fxml"));
            Scene tutorial = new Scene(fxmlLoader.load());//, 600, 400);*/
            Node node = (Node)event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(prev);
        /* } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public void setPreviousScene (Scene prev){
        this.prev = prev;
    }

}
