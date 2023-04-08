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
 * Represents the Controller of the tutorial {@link Scene}.
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
     * Sets actual {@link Scene}.
     * @param event event.
     */
    public void setPreviousScene(final ActionEvent event) {
        this.prevScene = MainViewController.converterFromEvent(event).getScene();
    }

    /**
     * Sets the players label name to the actual name.
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
}
