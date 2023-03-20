package it.unibo.tankBattle.view.impl.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GameOverController {

    private Scene prev;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button quitButton;

    @FXML
    private Button restartButton;

    @FXML
    void quit(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void restart(ActionEvent event) {
        Node node = (Node)event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(prev);
    }

    public void setPreviousScene (Scene prev){
        this.prev = prev;
    }

    @FXML
    void initialize() {
        assert quitButton != null : "fx:id=\"quitButton\" was not injected: check your FXML file 'gameOver.fxml'.";
        assert restartButton != null : "fx:id=\"restartButton\" was not injected: check your FXML file 'gameOver.fxml'.";

    }

}
