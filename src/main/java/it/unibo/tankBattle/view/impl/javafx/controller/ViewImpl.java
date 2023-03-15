package it.unibo.tankBattle.view.impl.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.common.input.api.InputController;
import it.unibo.tankBattle.common.input.impl.Movement;
import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.view.api.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ViewImpl implements View{

    private GameEngine controller;

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
            System.out.println(controller);
            if(e.getCode() == KeyCode.RIGHT){
                System.out.println("right");
                controller.notifyCommand(controller.getFirstPlayer(), new Movement(Directions.RIGHT));
            }
            else if(e.getCode() == KeyCode.LEFT){
                System.out.println("left");
                controller.notifyCommand(controller.getFirstPlayer(), new Movement(Directions.RIGHT));
            }
            else if(e.getCode() == KeyCode.UP){
                System.out.println("up");
                controller.notifyCommand(controller.getFirstPlayer(), new Movement(Directions.RIGHT));
            }
            else if(e.getCode() == KeyCode.DOWN){
                System.out.println("down");
                controller.notifyCommand(controller.getFirstPlayer(), new Movement(Directions.RIGHT));
            }
        };

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("layout/game.fxml"));
            Scene game = new Scene(fxmlLoader.load());//, 600, 400);
            game.addEventHandler(KeyEvent.KEY_PRESSED, keyPressListener);
            stage.setScene(game);
            //stage.setMaximized(true);
            stage.setResizable(false);
        }catch(Exception e){
            System.out.println("aaa");
            System.out.println(e.toString());
        }
    }

    @FXML
    void tutorial(ActionEvent event) {
        try {
            System.out.println(controller);
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("layout/tutorial.fxml"));
            Scene tutorial = new Scene(fxmlLoader.load());
            //controller = fxmlLoader.getController();
            TutorialController t = (TutorialController)fxmlLoader.getController();
            t.setPreviousScene(stage.getScene());
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

    @Override
    public void drawTank(P2d position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawTank'");
    }

    @Override
    public void drawBullet(P2d position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawBullet'");
    }

    @Override
    public void drawMap() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawMap'");
    }

    @Override
    public void setController(GameEngine controller) {
        this.controller = controller;
    }

}
