package it.unibo.tankBattle.view.impl.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.unibo.tankBattle.controller.api.Player;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class GameController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView player1;

    @FXML
    private ImageView player2;

    @FXML
    void initialize() {
        assert player1 != null : "fx:id=\"player1\" was not injected: check your FXML file 'game.fxml'.";
        assert player2 != null : "fx:id=\"player2\" was not injected: check your FXML file 'game.fxml'.";

    }

    public void move(Player player){
        player1.setTranslateX(5);   
        player1.setTranslateY(10);   
    }

}
