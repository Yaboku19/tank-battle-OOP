package it.unibo.tankBattle.view.impl;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.InputController;
import it.unibo.tankBattle.common.input.impl.KeyboardInputController;
import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.controller.impl.BasicGameEngine;
import it.unibo.tankBattle.view.api.View;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static java.awt.event.KeyEvent.*;

public class ViewImpl extends Application implements View{

    private InputController playerController1;
    private InputController playerController2;
    private static Scene scene;
    private GameEngine controller;

    public ViewImpl(){
        this.controller = new BasicGameEngine(this);
        this.playerController1 = new KeyboardInputController(VK_UP,VK_DOWN,VK_LEFT,VK_RIGHT, VK_SPACE);
        this.playerController2 = new KeyboardInputController(VK_W,VK_S,VK_A,VK_D, VK_CONTROL); 
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

    /*@Override
    public void startGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'startGame'");
    }

    */
    public InputController getInputControllerPlayer1() {
        return this.playerController1;
    }

    
    public InputController getInputControllerPlayer2() {
        return this.playerController2;
    }

    @Override
    public void start(Stage stage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../resources/layout/mainScene.fxml"));
            scene = new Scene(root);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        //scene.setOnKeyPressed(this);
        stage.setScene(scene);
        stage.show();
    }

    /*public GameEngine getController(){
        return this.controller;
    }*/
/*
    @Override
    public void handle(KeyEvent event) {
        System.out.println("keypressed");
    }
*/
    /*@Override
    public Dimension getSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSize'");
    }*/
    
}
