package it.unibo.tankBattle.view.impl.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.unibo.tankBattle.view.api.View;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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

    @FXML
    void initialize() {
        assert quitButton != null : "fx:id=\"quitButton\" was not injected: check your FXML file 'gameOver.fxml'.";
        assert restartButton != null : "fx:id=\"restartButton\" was not injected: check your FXML file 'gameOver.fxml'.";
    }

    @FXML
    void mainMenu(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        viewController.newStart();
        stage.setScene(mainManuScene);
    }

    @FXML
    void quit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void restart(ActionEvent event) {
        Node node = (Node)event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        viewController.restart();
        stage.setScene(gameScene);
    }

    public void setViewController(View viewController) {
        this.viewController = viewController;
    }

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public void setMenuScene(final Scene mainManuScene) {
        this.mainManuScene = mainManuScene;
    }

    public void setWinLabel(final String playerCode) {
        winLabel.setText("Player " + playerCode + " wins");
    }
}
