package it.unibo.tankbattle.view.impl.javafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/**
 * javadock.
 */
public class TutorialController {

    private Scene prevScene;

    @FXML
    private Button backButton;

    @FXML
    private void back(final ActionEvent event) {
            if (!(event.getSource() instanceof Node)) {
                throw new AssertionError("Unexpected type: " + event.getSource());
            }
            final Node node = (Node) event.getSource();
            if (!(node.getScene().getWindow() instanceof Stage)) {
                throw new AssertionError("Unexpected type: " + node.getScene().getWindow());
            }
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

}
