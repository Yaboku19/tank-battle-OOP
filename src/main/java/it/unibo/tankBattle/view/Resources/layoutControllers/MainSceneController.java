package it.unibo.tankBattle.view.resources.layoutControllers;

import java.net.URL;
import java.util.ResourceBundle;

import it.unibo.tankBattle.common.input.api.InputController;
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

import java.io.IOException;

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

    @FXML
    void play(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        EventHandler<KeyEvent> keyPressListener = e -> {
            System.out.println("keyPressed");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../layout/gameOver.fxml"));
            try {
                Scene game = new Scene(fxmlLoader.load());
                //game.setRoot(fxmlLoader.load());
                //stage = (Stage) node.getScene().getWindow();
                stage.setScene(game);
            stage.setMaximized(false);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            /*FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../layout/game.fxml"));
            Scene game = new Scene(fxmlLoader.load());//, 600, 400);
            game.addEventHandler(KeyEvent.KEY_PRESSED, keyPressListener);
            stage.setScene(game); 
            stage.setMaximized(true);
            stage.setResizable(true);*/
            /*if(inputControllerPlayer1.getKeyCodes().contains(e.getCode().getCode())){
                switch(e.getCode().getCode()){
                    //notifyCommand(new Shoot);
                    //notifyCommand(new Movement);
                }
            }else if(inputControllerPlayer2.getKeyCodes().contains(e.getCode().getCode())){
                switch(e.getCode().getCode()){
                    //notifyCommand(new Shoot(Player1));
                    //notifyCommand(new Movement);
                }
            }*/
        };

        try{
            /*node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();*/
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../layout/game.fxml"));
            Scene game = new Scene(fxmlLoader.load());//, 600, 400);
            game.addEventHandler(KeyEvent.KEY_PRESSED, keyPressListener);
            stage.setScene(game);
            stage.setMaximized(true);
            stage.setResizable(false);
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

    /*public MainSceneController(){
        System.out.println("aaa");
    }*/

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
