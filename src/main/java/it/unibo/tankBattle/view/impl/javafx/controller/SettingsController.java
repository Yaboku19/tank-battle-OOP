package it.unibo.tankBattle.view.impl.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.unibo.tankBattle.common.NextAndPrevious;
import it.unibo.tankBattle.view.api.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * javadock.
 */
public class SettingsController implements Initializable {

    private Scene prevScene;
    private View viewController;
    private final String PATH = "images/";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label damageP1;

    @FXML
    private Label damageP2;

    @FXML
    private Label lifeP1;

    @FXML
    private Label lifeP2;

    @FXML
    private Label speedP1;

    @FXML
    private Label speedP2;

    @FXML
    private ImageView mapImage;

    @FXML
    private Button nextMap;

    @FXML
    private Button nextTankPlayer1;

    @FXML
    private Button nextTankPlayer2;

    @FXML
    private ImageView player1Image;

    @FXML
    private ImageView player2Image;

    @FXML
    private Button prevMap;

    @FXML
    private Button prevTankPlayer1;

    @FXML
    private Button prevTankPlayer2;
    /**
     * javadoc.
     * @param event param
     */
    @FXML
    void nextTankPlayer1(final ActionEvent event) {
        viewController.updateTankPlayer1(NextAndPrevious.NEXT);
    }
    /**
     * javadoc.
     * @param event param
     */
    @FXML
    void prevTankPlayer1(final ActionEvent event) {
        viewController.updateTankPlayer1(NextAndPrevious.PREVIOUS);
    }
    /**
     * javadoc.
     * @param event param
     */
    @FXML
    void nextTankPlayer2(final ActionEvent event) {
        viewController.updateTankPlayer2(NextAndPrevious.NEXT);
    }
    /**
     * javadoc.
     * @param event param
     */
    @FXML
    void prevTankPlayer2(final ActionEvent event) {
        viewController.updateTankPlayer2(NextAndPrevious.PREVIOUS);
    }
    /**
     * javadoc.
     * @param event param
     */
    @FXML
    void nextMap(final ActionEvent event) {
        viewController.updateMap(NextAndPrevious.NEXT);
    }
    /**
     * javadoc.
     * @param event param
     */
    @FXML
    void prevMap(final ActionEvent event) {
        viewController.updateMap(NextAndPrevious.PREVIOUS);
    }
    /**
     * javadoc.
     * @param event param
     */
    @FXML
    void back(final ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setResizable(true);
        stage.setScene(prevScene);
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

    }
    /**
     * javadock.
     * @param viewController param
     */
    public void setViewController(final View viewController) {
        this.viewController = viewController;
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
     * @param speed param
     * @param damage param
     * @param life param
     * @param resource param
     */
    public void updateP1(final int speed, final int damage, final int life, final String resource) {
        speedP1.setText(Integer.toString(speed));
        damageP1.setText(Integer.toString(damage));
        lifeP1.setText(Integer.toString(life));
        player1Image.setImage(new Image(ClassLoader.getSystemResource(PATH + "tank/blue" + resource).toExternalForm()));
    }
    /**
     * javadock.
     * @param speed param
     * @param damage param
     * @param life param
     * @param resource param
     */
    public void updateP2(final int speed, final int damage, final int life, final String resource) {
        speedP2.setText(Integer.toString(speed));
        damageP2.setText(Integer.toString(damage));
        lifeP2.setText(Integer.toString(life));
        player2Image.setImage(new Image(ClassLoader.getSystemResource(PATH + "tank/green" + resource).toExternalForm()));
    }
    /**
     * javadock.
     * @param resource param
     */
    public void updateMap(final String resource) {
        mapImage.setImage(new Image(ClassLoader.getSystemResource(PATH + "map/" + resource).toExternalForm()));
    }

}
