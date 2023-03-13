package it.unibo.tankBattle.view.resources.layoutControllers;

import java.net.URL;
import java.util.ResourceBundle;

import it.unibo.tankBattle.common.input.api.InputController;
import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.view.api.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import static java.awt.event.KeyEvent.*;

public class MainSceneController {//implements EventHandler<KeyEvent>{

    private InputController inputControllerPlayer1;
    private InputController inputControllerPlayer2;
    private View view;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button playButton;

    @FXML
    private Button tutorialButton;

    public MainSceneController(View view){
        this.view = view;
    }

    @FXML
    void play(ActionEvent event) {
        EventHandler<KeyEvent> keyPressListener = e -> {
            if(inputControllerPlayer1.getKeyCodes().contains(e.getCode().getCode())){
                switch(e.getCode().getCode()){
                    //notifyCommand(new Shoot);
                    //notifyCommand(new Movement);
                }
            }else if(inputControllerPlayer2.getKeyCodes().contains(e.getCode().getCode())){
                switch(e.getCode().getCode()){
                    //notifyCommand(new Shoot(Player1));
                    //notifyCommand(new Movement);
                }
            }
        };

        try{
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../layout/game.fxml"));
            Scene game = new Scene(fxmlLoader.load(), 600, 400);
            game.addEventHandler(KeyEvent.KEY_PRESSED, keyPressListener);
            stage.setScene(game); 
            stage.setFullScreen(true);
            stage.setResizable(true);
            //setInputController();
        }catch(Exception e){
            System.out.println(e.toString());
        } 
    }

    @FXML
    void tutorial(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../layout/tutorial.fxml"));
            Scene tutorial = new Scene(fxmlLoader.load(), 600, 400);
            stage.setScene(tutorial);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @FXML
    void initialize() {
        assert playButton != null : "fx:id=\"playButton\" was not injected: check your FXML file 'mainScene.fxml'.";
        assert tutorialButton != null : "fx:id=\"tutorialButton\" was not injected: check your FXML file 'mainScene.fxml'.";

    }

    private void setInputController(){
        this.inputControllerPlayer1 = view.getInputControllerPlayer1();
        this.inputControllerPlayer2 = view.getInputControllerPlayer2();
    }

/*    @Override
    public void handle(KeyEvent e) {
        System.out.println("keyPressed");

            if(e.getCode() == KeyCode.RIGHT){
                newX = newX + 10;
                circle.setTranslateX(newX);
            }
            else if(e.getCode() == KeyCode.LEFT){
                newX = newX - 10;
                circle.setTranslateX(newX);
            }
            else if(e.getCode() == KeyCode.UP){
                newY = newY - 10;
                circle.setTranslateY(newY);
            }
            else if(e.getCode() == KeyCode.DOWN){
                newY = newY + 10;
                circle.setTranslateY(newY);
            }
    }*/

}
