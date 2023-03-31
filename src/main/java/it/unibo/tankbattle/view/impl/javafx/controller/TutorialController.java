package it.unibo.tankbattle.view.impl.javafx.controller;

import it.unibo.tankbattle.view.api.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
    private void back(final ActionEvent event) {
            final Node node = (Node) event.getSource();
            final Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(prevScene);
            //stage.setHeight(stage.getHeight()-0.01);
            //stage.setWidth(stage.getWidth()-0.01);
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
     * @param prevScene param
     */
    public void setNameLabel() {
        firstPlayer.setText(viewController.getFirstPlayerName());
        secondPlayer.setText(viewController.getSecondPlayerName()); 
    }
    /**
     * javadock.
     * @param viewController param
     */
    public void setViewController(final View viewController) {
        this.viewController = viewController;
    }
}
