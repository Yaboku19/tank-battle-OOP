package it.unibo.tankbattle.view.impl.javafx.controller;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.tankbattle.view.api.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * javadock.
 */
public class TutorialController {

    private Scene prevScene;
    private View viewController;

    @FXML
    private Label firstPlayer;

    @FXML
    private Label secondPlayer;

    @FXML
    private Button backButton;

    @FXML
    private void back(final ActionEvent event) {    // NOPMD it is used by Javafx
        final Stage stage = MainViewController.converterFromEvent(event);
            stage.setScene(prevScene);
            stage.sizeToScene();
    }
    /**
     * javadock.
     * @param prevScene param
     */
    public void setPreviousScene(final Scene prevScene) {
        this.prevScene = prevScene;
    }
    /**
     * javadock.
     */
    public void setNameLabel() {
        if (viewController == null) {
            throw new IllegalStateException();
        } else {
            firstPlayer.setText(viewController.getFirstPlayerName());
            secondPlayer.setText(viewController.getSecondPlayerName());
        } 
    }
    /**
     * javadock.
     * @param viewController param
     */
    @SuppressFBWarnings(
        value = {"EI_EXPOSE_REP2"}, 
        justification = "It is needed the object not its copy"
    )
    public void setViewController(final View viewController) {
        this.viewController = viewController;
    }
}
