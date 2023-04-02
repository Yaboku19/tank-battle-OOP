package it.unibo.tankbattle.view.impl.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.tankbattle.view.api.View;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
/**
 * Represents the Controller of the game over {@link Scene}.
 */
public class GameOverController {

    private View viewController;
    private Scene mainManuScene;
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
        assert quitButton != null : "fx:id=\"quitButton\" was not injected: check your FXML file 'gameOver.fxml'.";
        assert restartButton != null : "fx:id=\"restartButton\" was not injected: check your FXML file 'gameOver.fxml'.";
    }
    /**
     * Sets the scene to main menu.
     * @param event the button click
     */
    @FXML
    void mainMenu(final ActionEvent event) {
        final Stage stage = MainViewController.converterFromEvent(event);
        viewController.newStart();
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
        viewController.restart();
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
     * Sets the game {@link Scene}.
     * @param gameScene the game {@link Scene}
     */
    public void setGameScene(final Scene gameScene) {
        this.gameScene = gameScene;
    }
    /**
     * Sets the menu {@link Scene}.
     * @param mainManuScene the menu {@link Scene}
     */
    public void setMenuScene(final Scene mainManuScene) {
        this.mainManuScene = mainManuScene;
    }

    /**
     * Sets the menu {@link Label}.
     * @param playerName the winner player's name
     */
    public void setWinLabel(final String playerName) {
        winLabel.setText(playerName + " wins");
    }
}
