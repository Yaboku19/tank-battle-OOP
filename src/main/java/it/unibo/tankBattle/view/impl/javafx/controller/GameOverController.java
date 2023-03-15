package it.unibo.tankBattle.view.impl.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GameOverController {

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

    }

    @FXML
    void initialize() {
        assert quitButton != null : "fx:id=\"quitButton\" was not injected: check your FXML file 'gameOver.fxml'.";
        assert restartButton != null : "fx:id=\"restartButton\" was not injected: check your FXML file 'gameOver.fxml'.";

    }

}
