package it.unibo.tankBattle.view.resources.layoutControllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;

public class GameController implements EventHandler<KeyEvent>{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void initialize() {

    }

    @Override
    public void handle(KeyEvent event) {        
        System.out.println("keypressed");
    }

}
