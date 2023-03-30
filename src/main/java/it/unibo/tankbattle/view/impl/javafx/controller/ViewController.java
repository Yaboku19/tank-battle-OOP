package it.unibo.tankbattle.view.impl.javafx.controller;

import java.util.stream.Stream;

import it.unibo.tankbattle.common.NextAndPrevious;
import it.unibo.tankbattle.common.Transform;
import it.unibo.tankbattle.common.input.api.Direction;
import it.unibo.tankbattle.common.input.impl.Movement;
import it.unibo.tankbattle.common.input.impl.Shoot;
import it.unibo.tankbattle.controller.api.GameEngine;
import it.unibo.tankbattle.controller.impl.BasicGameEngine;
import it.unibo.tankbattle.view.api.View;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import java.io.IOException;
import java.util.stream.Collectors;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Screen;

/**
 * javadock.
 */
public class ViewController implements View {

    private GameEngine controller;
    private GameController gameController;
    private SettingsController settingsController;
    private Scene mainViewScene;
    private MainViewController mainViewController;
    //private Node node;
    private Stage stage;
    private Scene gameScene;
    private String lastCommandFirstPlayer = "";
    private String lastCommandSecondPlayer = "";
    private String winner;
    private String firstPlayerName = "Player 1";
    private String secondPlayerName = "Player 2";

    @Override
    public void render(final Transform firstTank, final Transform secondTank, final Stream<Transform> wall,
            final Stream<Transform> bullet, final int lifeFirstTank, final int lifeSecondTank,
            final int firstPlayerScore, final int secondPlayerScore) {
        Platform.runLater(() -> {
            gameController.clear();
            gameController.renderBullet(bullet.collect(Collectors.toSet()));
            gameController.renderFirstTank(firstTank);
            gameController.renderSecondTank(secondTank);
            gameController.renderWall(wall.collect(Collectors.toSet()));
            gameController.updateLifeLabel(lifeFirstTank, lifeSecondTank);
            gameController.drawLabel(firstPlayerName, secondPlayerName, firstPlayerScore, secondPlayerScore);
        });
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void setController(final GameEngine controller) {
        this.controller = controller;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void viewUpdateP1(final int speed, final int damage, final int life, final String resource) {
        settingsController.updateP1(speed, damage, life, resource);
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void viewUpdateP2(final int speed, final int damage, final int life, final String resource) {
        settingsController.updateP2(speed, damage, life, resource);
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void viewUpdateMap(final String resource) {
        settingsController.updateMap(resource);
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void updateTankPlayer1(final NextAndPrevious delta) {
        controller.updateTankPlayer1(delta);
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void updateTankPlayer2(final NextAndPrevious delta) {
        controller.updateTankPlayer2(delta);
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void updateMap(final NextAndPrevious delta) {
        controller.updateMap(delta);
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void setResource(final String tank1Resource, final String tank2Resource,
            final String mapResource) {
        mainViewController.setResource("blue" + tank1Resource, "green" + tank2Resource, mapResource);
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void start(final Stage stage) {
        final Image icon = new Image(ClassLoader.getSystemResource("icon/icon.gif").toExternalForm());
        stage.getIcons().add(icon); 
        this.stage = stage;
        final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layout/main2.fxml"));
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
            stage.setMinHeight(430);
            stage.setMinWidth(600);
            //stage.setMaxHeight(Screen.getPrimary().getBounds().getWidth()*2/3);
            //stage.setMaxWidth(Screen.getPrimary().getBounds().getHeight()*3/2);
            stage.setOnCloseRequest(e -> {
                Platform.exit();
                System.exit(0);
            });
            stage.show();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void gameOver() {
        try {
            System.out.println(controller);
            final FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("layout/gameOver.fxml"));
            final Scene gameOver = new Scene(fxmlLoader.load());
            final GameOverController gameOverController = (GameOverController) fxmlLoader.getController();
            gameOverController.setMenuScene(mainViewScene);
            gameOverController.setViewController(this);
            gameOverController.setGameScene(gameScene);
            gameOverController.setWinLabel(winner);
            Platform.runLater(() -> {
                stage.setScene(gameOver);
            });
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void restart() {
        this.setDimension();
        controller.restart();
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void newStart() {
        this.setDimension();
        controller.newStart();
    }

    private void setDimension() {
        stage.setWidth(Screen.getPrimary().getBounds().getWidth() / 2);
        stage.setHeight(stage.getWidth() * 2.0 / 3.0 + 1.0);
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void setViewResources() {
        controller.setViewResources();
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void startGame() {
        setDimension();
        controller.startGame();
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void addCommand(final KeyEvent e) {
        if (e.getEventType().equals(KeyEvent.KEY_PRESSED)) {
            final String event = e.getCode().toString() + e.getEventType().toString();
            if (!lastCommandFirstPlayer.equals(event)) {
                    switch (e.getCode()) {
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
                if (!lastCommandSecondPlayer.equals(event)) {
                    switch (e.getCode()) {
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
                            controller.notifyCommand(new Movement(Direction.UP, controller.getSecondPlayer()));
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

        if (e.getEventType().equals(KeyEvent.KEY_RELEASED)) {
            final String event = e.getCode().toString() + e.getEventType().toString();
            switch (e.getCode()) {
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
    /**
    * {@inheritDoc}
    */
    @Override
    public void setGameController(final GameController gameController) {
        this.gameController = gameController;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void setGameScene(final Scene gameScene) {
        this.gameScene = gameScene;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void setSettingsController(final SettingsController settingsController) {
        this.settingsController = settingsController;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void setWinner(final String code) {
        this.winner = code;
    }

    @Override
    public void setPlayerName(final String firstPlayerName, final String secondPlayerName) {
        if (!firstPlayerName.isBlank()) {
            this.firstPlayerName = firstPlayerName;
        }
        if (!secondPlayerName.isBlank()) {
            this.secondPlayerName = secondPlayerName;
        }
    }

    @Override
    public String getFirstPlayerName() {
        return this.firstPlayerName;
    }

    @Override
    public String getSecondPlayerName() {
        return this.secondPlayerName;
    }
}
