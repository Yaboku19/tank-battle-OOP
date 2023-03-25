package it.unibo.tankBattle.view.impl.javafx.controller;

import java.util.stream.Stream;

import it.unibo.tankBattle.common.NextAndPrevious;
import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.controller.impl.BasicGameEngine;
import it.unibo.tankBattle.view.api.View;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import it.unibo.tankBattle.common.NextAndPrevious;
import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.common.input.api.Direction;
import it.unibo.tankBattle.common.input.impl.Movement;
import it.unibo.tankBattle.common.input.impl.Shoot;
import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.view.api.View;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ViewController implements View {

    private GameEngine controller;
    private GameController gameController;
    private SettingsController settingsController;
    private GameOverController gameOverController;
    private Scene mainViewScene;
    private MainViewController mainViewController;
    //private Node node;
    private Stage stage;
    private Scene gameScene;
    private String lastCommandFirstPlayer = "";
    private String lastCommandSecondPlayer = "";
    /*private String tank1Resource;
    private String tank2Resource;*/

    @Override
    public void render(Transform firstTank, Transform secondTank, Stream<Transform> wall, Stream<Transform> bullet){
        Platform.runLater(() -> {
            gameController.clear();
            gameController.renderFirstTank(firstTank);
            gameController.renderSecondTank(secondTank);
            gameController.renderBullet(bullet.collect(Collectors.toSet()));
            gameController.renderWall(wall.collect(Collectors.toSet()));
        });
    }

    @Override
    public void setController(GameEngine controller) {
        this.controller = controller;
    }

    
    @Override
    public void viewUpdateP1(int speed, int damage, int life, String resource){
        settingsController.updateP1(speed, damage, life, resource);
    }

    @Override
    public void viewUpdateP2(int speed, int damage, int life, String resource){
        settingsController.updateP2(speed, damage, life, resource);
    }

    @Override
    public void viewUpdateMap(String resource){
        settingsController.updateMap(resource);
    }

    @Override
    public void updateTankPlayer1(NextAndPrevious delta){
        controller.updateTankPlayer1(delta);
    }

    @Override
    public void updateTankPlayer2(NextAndPrevious delta){
        controller.updateTankPlayer2(delta);
    }

    @Override
    public void updateMap(NextAndPrevious delta){
        controller.updateMap(delta);
    }

    @Override
    public void setTanksResource(String tank1Resource, String tank2Resource) {
        mainViewController.setTanksResource("blue" + tank1Resource,"green" + tank2Resource);

    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layout/main.fxml"));
        Parent root;
        try {
            root = loader.load();
            mainViewController = loader.getController();
            controller = new BasicGameEngine(this);
            controller.setViewResources();
            mainViewController.setViewController(this);
            mainViewScene = new Scene(root);
            //mainViewController.setMainMenuScene(scene);
            stage.setTitle("Tank-Battle");
            stage.setScene(mainViewScene);
            stage.setOnCloseRequest(e -> {
                Platform.exit();
                System.exit(0);
            });
            stage.show();            
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void gameOver() {
        try {
            System.out.println(controller);
            FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("layout/gameOver.fxml"));
            Scene gameOver = new Scene(fxmlLoader.load());
            gameOverController = (GameOverController)fxmlLoader.getController();
            gameOverController.setMenuScene(mainViewScene);
            gameOverController.setViewController(this);
            gameOverController.setGameScene(gameScene);
            
            Platform.runLater(()->{
                stage.setScene(gameOver);
            });
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @Override
    public void restart() {
        // TODO Auto-generated method stub
    }

    @Override
    public void newStart() {
        // TODO Auto-generated method stub
    }

    @Override
    public void setViewResources() {
        controller.setViewResources();
    }

    @Override
    public void startGame() {
        controller.startGame();
    }

    @Override
    public void addCommand(KeyEvent e) {
        if(e.getEventType() == KeyEvent.KEY_PRESSED){
            String event = e.getCode().toString() + e.getEventType().toString();
            if(!lastCommandFirstPlayer.equals(event)){
                    switch(e.getCode()){
                        case RIGHT:
                            controller.notifyCommand(new Movement(Direction.RIGHT, controller.getFirstPlayer()));
                            lastCommandFirstPlayer = event;
                            break;
                        case LEFT:
                            controller.notifyCommand(new Movement(Direction.LEFT, controller.getFirstPlayer()));
                            lastCommandFirstPlayer = event;
                            break;
                        case UP:
                            controller.notifyCommand(new Movement(Direction.UP, controller.getFirstPlayer()));
                            lastCommandFirstPlayer = event;
                            break;
                        case DOWN:
                            controller.notifyCommand(new Movement(Direction.DOWN, controller.getFirstPlayer()));
                            lastCommandFirstPlayer = event;
                            break;
                        case SPACE:
                            controller.notifyCommand(new Shoot(controller.getFirstPlayer()));
                            break;
                        default:
                    }
                }
    
                if(!lastCommandSecondPlayer.equals(event)){
                    switch(e.getCode()){
                        case D:
                            System.out.println(e.getCode());
                            controller.notifyCommand(new Movement(Direction.RIGHT, controller.getSecondPlayer()));
                            lastCommandSecondPlayer = event;
                            break;
                        case A:
                            System.out.println(e.getCode());
                            controller.notifyCommand(new Movement(Direction.LEFT, controller.getSecondPlayer()));
                            lastCommandSecondPlayer = event;
                            break;
                        case W:
                            System.out.println(e.getCode());
                            controller.notifyCommand(new Movement(Direction.UP,controller.getSecondPlayer()));
                            lastCommandSecondPlayer = event;
                            break;
                        case S:
                            System.out.println(e.getCode());
                            controller.notifyCommand(new Movement(Direction.DOWN, controller.getSecondPlayer()));
                            lastCommandSecondPlayer = event;
                            break;
                        case Z:
                            System.out.println(e.getCode());
                            controller.notifyCommand(new Shoot(controller.getSecondPlayer()));
                            break;
                        default:
                    }
                }
        }
        
        if(e.getEventType() == KeyEvent.KEY_RELEASED){
            String event = e.getCode().toString() + e.getEventType().toString();
            switch(e.getCode()){
                case RIGHT, LEFT, UP, DOWN:
                    System.out.println(e.getCode());
                    controller.notifyCommand(new Movement(Direction.NONE, controller.getFirstPlayer()));
                    lastCommandFirstPlayer = event;
                break;
                case D, A, W, S:
                    System.out.println(e.getCode());
                    controller.notifyCommand(new Movement(Direction.NONE, controller.getSecondPlayer()));
                    lastCommandSecondPlayer = event;
                break;
                default:
            }
        }
    }

    @Override
    public void setGameController(GameController gameController){
        this.gameController = gameController;
    }

    @Override
    public void setSettingsController(SettingsController settingsController){
        this.settingsController = settingsController;
    }
}