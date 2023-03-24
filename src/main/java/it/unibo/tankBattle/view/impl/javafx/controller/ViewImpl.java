package it.unibo.tankBattle.view.impl.javafx.controller;

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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ViewImpl implements View{

    private GameEngine controller;
    private GameController gameController;
    private ChooseMenu chooseMenuController;
    private GameOverController gameOverController;
    private Node node;
    private Stage stage;
    private String lastCommandFirstPlayer = "";
    private String lastCommandSecondPlayer = "";
    private String tank1Resource;
    private String tank2Resource;

    private EventHandler<KeyEvent> keyPressListener = e -> {
        
        String event = e.getCode() + e.getEventType().toString();
        System.out.println(!lastCommandFirstPlayer.equals(event));
        if(!lastCommandFirstPlayer.equals(event)){
            switch(e.getCode()){
                case RIGHT:
                    System.out.println("comando " + e.getCode());
                    controller.notifyCommand(new Movement(Direction.RIGHT, controller.getFirstPlayer()));
                    lastCommandFirstPlayer = event;
                    break;
                case LEFT:
                    System.out.println("comando " + e.getCode());
                    controller.notifyCommand(new Movement(Direction.LEFT, controller.getFirstPlayer()));
                    lastCommandFirstPlayer = event;
                    break;
                case UP:
                    System.out.println("comando " + e.getCode());
                    controller.notifyCommand(new Movement(Direction.UP, controller.getFirstPlayer()));
                    lastCommandFirstPlayer = event;
                    break;
                case DOWN:
                    System.out.println("comando " + e.getCode());
                    controller.notifyCommand(new Movement(Direction.DOWN, controller.getFirstPlayer()));
                    lastCommandFirstPlayer = event;
                    break;
                case SPACE:
                    System.out.println("comando " + e.getCode());
                    controller.notifyCommand(new Shoot(controller.getFirstPlayer()));
                    break;
                default:
            }
        }
        System.out.println(!lastCommandSecondPlayer.equals(event));
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
                    //lastCommandSecondPlayer += "." ;
                    break;
                default:
            }
            /*System.out.println("DOPO lastCommandSecondPlayer " + lastCommandSecondPlayer);
            System.out.println("DOPO event " + event);*/
        }

        /*if(lastCommandFirstPlayer == null){
            lastCommandFirstPlayer = e;
            lastCommandSecondPlayer = e;
        }*/
    };

    private EventHandler<KeyEvent> keyReleasedListener = e -> {
        //System.out.println(controller);
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
    };



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button playButton;

    @FXML
    private Button settingButton;

    @FXML
    private Button tutorialButton;

    @FXML
    void play(ActionEvent event) {
        node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("layout/game.fxml"));
            gameController = new GameController(tank1Resource, tank2Resource);
            fxmlLoader.setControllerFactory(controller -> gameController);
            Scene game = new Scene(fxmlLoader.load());//, 600, 400);
            game.addEventHandler(KeyEvent.KEY_PRESSED, keyPressListener);
            game.addEventHandler(KeyEvent.KEY_RELEASED, keyReleasedListener);
            stage.setScene(game);
            gameOverController.setGameScene(game);
            //stage.setMaximized(true);
            //gameController = fxmlLoader.getController();
            stage.setResizable(false);
            controller.startGame();
            //controller.run();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @FXML
    void settings(ActionEvent event) {
        try {
            System.out.println(controller);
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("layout/chooseMenu.fxml"));
            Scene chooseMenu = new Scene(fxmlLoader.load());
            //controller = fxmlLoader.getController();
            chooseMenuController = (ChooseMenu)fxmlLoader.getController();
            chooseMenuController.setViewController(this);
            chooseMenuController.setPreviousScene(stage.getScene());
            updateTankPlayer1(NextAndPrevious.NONE);
            updateTankPlayer2(NextAndPrevious.NONE);
            updateMap(NextAndPrevious.NONE);
            stage.setScene(chooseMenu);
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
    public void gameOver() {
        try {
            System.out.println(controller);
            FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("layout/gameOver.fxml"));
            Scene gameOver = new Scene(fxmlLoader.load());
            gameOverController = (GameOverController)fxmlLoader.getController();
            gameOverController.setMenuScene(stage.getScene());
            gameOverController.setViewController(this);
            stage.setScene(gameOver);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @Override
    public void viewUpdateP1(int speed, int damage, int life, String resource){
        chooseMenuController.updateP1(speed, damage, life, resource);
    }

    @Override
    public void viewUpdateP2(int speed, int damage, int life, String resource){
        chooseMenuController.updateP2(speed, damage, life, resource);
    }

    @Override
    public void viewUpdateMap(String resource){
        chooseMenuController.updateMap(resource);
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
        this.tank1Resource = tank1Resource;
        this.tank2Resource = tank2Resource;
    }

    @Override
    public void restart() {
        // TODO Auto-generated method stub
    }

    @Override
    public void newStart() {
        // TODO Auto-generated method stub
    }
}
