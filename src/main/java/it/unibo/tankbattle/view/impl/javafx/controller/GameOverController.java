package it.unibo.tankbattle.view.impl.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.tankbattle.view.api.View;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Represents the Controller of the game over {@link Scene}.
 */
public class GameOverController {

    private View viewController;
    private final Scene mainManuScene;
    private Scene gameScene;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button mainMenuButton;

    @FXML
    private Button quitButton;

    @FXML
    private Button restartButton;

    @FXML
    private Label winLabel;

    /**
     * Initialize buttons.
     */
    @FXML
    void initialize() {
        restartButton.setFocusTraversable(false); 
        quitButton.setFocusTraversable(false);
        mainMenuButton.setFocusTraversable(false);
    }

    /**
     * Create new GameOverController object.
     * @param parent main menu parent
     * @param stage game stage
     */
    public GameOverController(final Parent parent, final Stage stage) {
        this.mainManuScene = parent.getScene();
        this.gameScene = stage.getScene();
    }

    /**
     * Sets the scene to main menu.
     * @param event the button click
     */
    @FXML
    void mainMenu(final ActionEvent event) {
        final Stage stage = MainViewController.converterFromEvent(event);
        viewController.backToMenu();
        stage.setScene(mainManuScene);
        stage.sizeToScene();
    }

    /**
     * Close the applications.
     * @param event the button click
     */
    @FXML
    void quit(final ActionEvent event) {
        Platform.exit();
    }

    /**
     * Starts a new game with the same tanks and map chosen.
     * @param event the button click
     */
    @FXML
    void restart(final ActionEvent event) {
        final Stage stage = MainViewController.converterFromEvent(event);
        viewController.restartGame();
        stage.setScene(gameScene);
    }

    /**
     * Sets the {@link View} controller.
     * @param viewController the {@link View} controller
     */
    @SuppressFBWarnings(
        value = {"EI_EXPOSE_REP2"}, 
        justification = "It is needed the object not its copy"
    )
    public void setViewController(final View viewController) {
        this.viewController = viewController;
    }

    /**
     * Sets gameScene {@link Scene}.
     * @param stage main stage
     */
    public void setGameScene(final Stage stage) {
        this.gameScene = stage.getScene();
    }

    /**
     * Sets the winner {@link Label}.
     * @param playerName the winner player's name
     */
    public void setWinLabel(final String playerName) {
        winLabel.setText(playerName + " wins");
    }
}
