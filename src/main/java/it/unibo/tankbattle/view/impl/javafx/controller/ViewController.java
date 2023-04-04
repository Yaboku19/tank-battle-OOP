package it.unibo.tankbattle.view.impl.javafx.controller;

import java.util.stream.Stream;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.tankbattle.common.NextAndPrevious;
import it.unibo.tankbattle.common.Transform;
import it.unibo.tankbattle.common.input.api.Command;
import it.unibo.tankbattle.common.input.api.InputController;
import it.unibo.tankbattle.common.input.impl.KeyboardInputController;
import it.unibo.tankbattle.controller.api.GameEngine;
import it.unibo.tankbattle.controller.impl.BasicGameEngine;
import it.unibo.tankbattle.view.api.View;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Screen;

/**
 * Represents the {@link View} controller.
 */
public class ViewController implements View {

    private GameEngine controller;
    private GameController gameController;
    private SettingsController settingsController;
    private MainViewController mainViewController;
    private Stage stage;
    private Parent root;
    private String winner;
    private String firstPlayerName = "Player 1";
    private String secondPlayerName = "Player 2";
    private ChangeListener<? super Number> widthChangeListener;
    private ChangeListener<? super Number> heightChangeListener;
    private InputController<KeyCode> firstPlayerController;
    private InputController<KeyCode> secondPlayerController;

    private static final Logger LOGGER = Logger.getLogger("ViewControllerLog");
    private static final double SETTINGS_MIN_HEIGHT = 430;
    private static final double SETTINGS_MIN_WIDTH = 600;

    /**
     * {@inheritDoc}
     */
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
    public void updatePlayer1SettingsView(final int speed, final int damage, final int life, final String resource) {
        settingsController.updatePlayer1SettingsLabel(speed, damage, life, resource);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void updatePlayer2SettingsView(final int speed, final int damage, final int life, final String resource) {
        settingsController.updatePlayer2SettingsLabel(speed, damage, life, resource);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void updateMapSettingsView(final String resource, final String mapName) {
        settingsController.updateMapSettingsLabels(resource, mapName);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void askTankPlayer1Settings(final NextAndPrevious delta) {
        controller.updateTankPlayer1(delta);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void askTankPlayer2Settings(final NextAndPrevious delta) {
        controller.updateTankPlayer2(delta);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void askMapSettings(final NextAndPrevious delta) {
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
    @SuppressFBWarnings(
        value = {"EI_EXPOSE_REP2"}, 
        justification = "I need that istance of the object not its copy"
    )
    public void start(final Stage stage) {
        final Image icon = new Image(ClassLoader.getSystemResource("icon/icon.gif").toExternalForm());
        stage.getIcons().add(icon);
        this.stage = stage;
        final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layout/main.fxml"));
        try {
            root = loader.load();
            mainViewController = loader.getController();
            controller = new BasicGameEngine(this);
            controller.setViewResources();
            mainViewController.setViewController(this);
            final Scene mainViewScene = new Scene(root);
            stage.setTitle("Tank-Battle");
            stage.setScene(mainViewScene);
            stage.setMinHeight(SETTINGS_MIN_HEIGHT);
            stage.setMinWidth(SETTINGS_MIN_WIDTH);
            stage.setOnCloseRequest(e -> {
                Platform.exit();
                exit();
            });
            stage.show();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Main scene load error during start.");
        }
    }

    private void exit() {
        System.exit(0);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void gameOver() {
        try {
            final FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("layout/gameOver.fxml"));
            final GameOverController gameOverController = new GameOverController(root, stage);
            fxmlLoader.setControllerFactory(controller -> gameOverController);
            final Scene gameOver = new Scene(fxmlLoader.load());
            gameOverController.setViewController(this);
            gameOverController.setWinLabel(winner);
            Platform.runLater(() -> {
                stage.widthProperty().removeListener(widthChangeListener);
                stage.heightProperty().removeListener(heightChangeListener);
                stage.setScene(gameOver);
                stage.sizeToScene();
            });
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "GameOver scene load error.");
        }
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void restart() {
        this.setDimension();
        this.setDiagonalResize();
        controller.restart();
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void newStart() {
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
        this.setDiagonalResize();
        setDimension();
        controller.startGame();
        inizializeInputController();
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void addCommand(final KeyEvent e) {
        if (firstPlayerController.getKeys().contains(e.getCode())) {
            notifyCommand(firstPlayerController, e);
        }
        if (secondPlayerController.getKeys().contains(e.getCode())) {
            notifyCommand(secondPlayerController, e);
        }
    }

    private void notifyCommand(final InputController<KeyCode> playerController, final KeyEvent e) {
        Optional<Command> command;
        if (e.getEventType().equals(KeyEvent.KEY_PRESSED)) {
            command = playerController.startCommand(e.getCode());
        } else {
            command = playerController.stopCommand(e.getCode());
        }
        if (command.isPresent()) {
            controller.notifyCommand(command.get());
        }
    }
    /**
    * {@inheritDoc}
    */
    @Override
    @SuppressFBWarnings(
        value = {"EI_EXPOSE_REP2"}, 
        justification = "I need that istance of the object not its copy"
    )
    public void setGameController(final GameController gameController) {
        this.gameController = gameController;
    }

    /**
    * {@inheritDoc}
    */
    @SuppressFBWarnings(
        value = {"EI_EXPOSE_REP2"}, 
        justification = "I need that istance of the object not its copy"
    )
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPlayerName(final String firstPlayerName, final String secondPlayerName) {
        if (!firstPlayerName.isBlank()) {
            this.firstPlayerName = firstPlayerName;
        }
        if (!secondPlayerName.isBlank()) {
            this.secondPlayerName = secondPlayerName;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFirstPlayerName() {
        return this.firstPlayerName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSecondPlayerName() {
        return this.secondPlayerName;
    }

    private void setDiagonalResize() {
        widthChangeListener = (observable, oldValue, newValue) -> {
            stage.setHeight(newValue.doubleValue() * 2.0 / 3.0);
        };
        heightChangeListener = (observable, oldValue, newValue) -> {
            stage.setWidth(newValue.doubleValue() * 3.0 / 2.0);
        };
        stage.widthProperty().addListener(widthChangeListener);
        stage.heightProperty().addListener(heightChangeListener);
    }

    private void inizializeInputController() {
        firstPlayerController = new KeyboardInputController<>(KeyCode.UP, KeyCode.DOWN,
                KeyCode.LEFT, KeyCode.RIGHT, KeyCode.SPACE, controller.getFirstPlayer());
        secondPlayerController = new KeyboardInputController<>(KeyCode.W, KeyCode.S,
                KeyCode.A, KeyCode.D, KeyCode.Q, controller.getSecondPlayer());
    }
}
