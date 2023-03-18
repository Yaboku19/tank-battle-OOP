package it.unibo.tankBattle.view.impl.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.common.input.api.Directions;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ViewImpl implements View{

    private GameEngine controller;
    private GameController gameController;
    private Node node;
    private Stage stage;
    private KeyEvent lastCommandFirstPlayer;
    private KeyEvent lastCommandSecondPlayer;

    private EventHandler<KeyEvent> keyPressListener = e -> {
        System.out.println("prima " + lastCommandFirstPlayer);
        System.out.println("e " + e);
        if(lastCommandFirstPlayer != e){
            switch(e.getCode()){
                case RIGHT:
                    System.out.println("comando " + e.getCode());
                    controller.notifyCommand(new Movement(Directions.RIGHT, controller.getFirstPlayer()));
                    break;
                case LEFT:
                    //System.out.println("comando " + e.getCode());
                    controller.notifyCommand(new Movement(Directions.LEFT, controller.getFirstPlayer()));
                    break;
                case UP:
                    //System.out.println("comando " + e.getCode());
                    controller.notifyCommand(new Movement(Directions.UP, controller.getFirstPlayer()));
                    break;
                case DOWN:
                    //System.out.println("comando " + e.getCode());
                    controller.notifyCommand(new Movement(Directions.DOWN, controller.getFirstPlayer()));
                    break;
                case SPACE:
                    //System.out.println("comando " + e.getCode());
                    controller.notifyCommand(new Shoot(controller.getFirstPlayer()));
                    break;
                default:
            }
            lastCommandFirstPlayer = e;
            //System.out.println("dopo " + lastCommandFirstPlayer);
        }

        if(lastCommandSecondPlayer != e){
            switch(e.getCode()){
                case D:
                    System.out.println(e.getCode());
                    controller.notifyCommand(new Movement(Directions.RIGHT, controller.getSecondPlayer()));
                    break;
                case A:
                    System.out.println(e.getCode());
                    controller.notifyCommand(new Movement(Directions.LEFT, controller.getSecondPlayer()));
                    break;
                case W:
                    System.out.println(e.getCode());
                    controller.notifyCommand(new Movement(Directions.UP,controller.getSecondPlayer()));
                    break;
                case S:
                    System.out.println(e.getCode());
                    controller.notifyCommand(new Movement(Directions.DOWN, controller.getSecondPlayer()));
                    break;
                case CONTROL:
                    System.out.println(e.getCode());
                    controller.notifyCommand(new Shoot(controller.getSecondPlayer()));
                    break;
                default:
            }
            lastCommandSecondPlayer = e;
        }

        /*if(lastCommandFirstPlayer == null){
            lastCommandFirstPlayer = e;
            lastCommandSecondPlayer = e;
        }*/
    };

    private EventHandler<KeyEvent> keyReleasedListener = e -> {
        //System.out.println(controller);
        switch(e.getCode()){
            case RIGHT, LEFT, UP, DOWN:
                System.out.println(e.getCode());
                controller.notifyCommand(new Movement(Directions.NONE, controller.getFirstPlayer()));
                break;
            case D, A, W, S:
                System.out.println(e.getCode());
                controller.notifyCommand(new Movement(Directions.NONE, controller.getSecondPlayer()));
                break;
            default:
        }
    };



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
        node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();

    
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("layout/game.fxml"));
            Scene game = new Scene(fxmlLoader.load());//, 600, 400);
            game.addEventHandler(KeyEvent.KEY_PRESSED, keyPressListener);
            game.addEventHandler(KeyEvent.KEY_RELEASED, keyReleasedListener);
            stage.setScene(game);
            //stage.setMaximized(true);
            gameController = fxmlLoader.getController();
            stage.setResizable(false);
            controller.startGame();
            //controller.run();
        }catch(Exception e){
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
            TutorialController tutorialController = (TutorialController)fxmlLoader.getController();
            tutorialController.setPreviousScene(stage.getScene());
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
    public void render(Transform firstTank, Transform secondTank, Stream<Transform> wall, Stream<Transform> bullet){
        Platform.runLater(() -> {
            drawFirstTank(firstTank);
            drawSecondTank(secondTank);
            drawBullet(bullet.collect(Collectors.toSet()));
            drawWall(wall.collect(Collectors.toSet()));
        });
    }
    /*ESEMPIO********
    Thread thread = new Thread(new Runnable() {

        @Override
        public void run() {
            Runnable updater = new Runnable() {

                @Override
                public void run() {
                    render();
                }
            };

            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }

                // UI update is run on the Application thread
                Platform.runLater(updater);
            }
        }

    });*/

    
    private void drawFirstTank(Transform tank){//Transform transform) {
        gameController.renderFirstTank(tank);
    }

    private void drawSecondTank(Transform tank){//Transform transform) {
        gameController.renderSecondTank(tank);
    }

    private void drawBullet(Set<Transform> bullet){//Transform transform) {
        gameController.renderBullet(bullet);
    }

    @Override
    public void drawWall(Set<Transform> wall) {
        gameController.renderWall(wall);
    }

    @Override
    public void setController(GameEngine controller) {
        this.controller = controller;
    }

    @Override
    public void gameOver() {
        try {
            System.out.println(controller);
            /*Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();*/
            FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("layout/gameOver.fxml"));
            Scene gameOver = new Scene(fxmlLoader.load());
            //controller = fxmlLoader.getController();
            GameOverController gameOverController = (GameOverController)fxmlLoader.getController();
            gameOverController.setPreviousScene(stage.getScene());
            stage.setScene(gameOver);
        }catch(Exception e){
            System.out.println(e.toString());
        }

    }

}
