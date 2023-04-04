package it.unibo.tankbattle.view.impl.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.tankbattle.common.NextAndPrevious;
import it.unibo.tankbattle.view.api.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Represent the Controller of the Settings {@link Scene}.
 */
public class SettingsController implements Initializable {

    private Scene prevScene;
    private View viewController;
    private static final String PATH = "images/";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField firstPlayerName;

    @FXML
    private TextField secondPlayerName;

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
    private Label mapLabel;

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
     * Sets the first player Tank to the next.
     * @param event button click
     */
    @FXML
    void nextTankPlayer1(final ActionEvent event) {
        viewController.askTankFirstPlayerSettings(NextAndPrevious.NEXT);
    }

    /**
     * Sets the first player Tank to the previous.
     * @param event button click.
     */
    @FXML
    void prevTankPlayer1(final ActionEvent event) {
        viewController.askTankFirstPlayerSettings(NextAndPrevious.PREVIOUS);
    }

    /**
     * Sets the second player Tank to the next.
     * @param event button click.
     */
    @FXML
    void nextTankPlayer2(final ActionEvent event) {
        viewController.askTankSecondPlayerSettings(NextAndPrevious.NEXT);
    }

    /**
     * Sets the second player Tank to the next.
     * @param event button click.
     */
    @FXML
    void prevTankPlayer2(final ActionEvent event) {
        viewController.askTankSecondPlayerSettings(NextAndPrevious.PREVIOUS);
    }

    /**
     * Sets the map to the next.
     * @param event button click.
     */
    @FXML
    void nextMap(final ActionEvent event) {
        viewController.askMapSettings(NextAndPrevious.NEXT);
    }

    /**
     * Sets the map to the previous.
     * @param event button click.
     */
    @FXML
    void prevMap(final ActionEvent event) {
        viewController.askMapSettings(NextAndPrevious.PREVIOUS);
    }

    /**
     * Set previous {@link Scene} to {@link Stage}. 
     * @param event button click.
     */
    @FXML
    void back(final ActionEvent event) {
        final Stage stage = MainViewController.converterFromEvent(event);
        stage.setResizable(true);
        stage.setScene(prevScene);
        stage.sizeToScene();
        viewController.setPlayerName(firstPlayerName.getText(), secondPlayerName.getText());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

    }

    /**
     * Sets the {@link View} controller.
     * @param viewController the {@link View} controller.
     */
    @SuppressFBWarnings(
        value = {"EI_EXPOSE_REP2"}, 
        justification = "It is needed the object not its copy"
    )
    public void setViewController(final View viewController) {
        this.viewController = viewController;
    }

    /**
     * Sets player names in {@link Label}.
     */
    public void setPlayerNameLabel() {
        firstPlayerName.setText(viewController.getFirstPlayerName());
        secondPlayerName.setText(viewController.getSecondPlayerName());
    }

    /**
     * Sets first player tank stats and resource to view.
     * @param speed tank speed
     * @param damage tank speed
     * @param life tank life
     * @param resource tank resource
     */
    public void updatePlayer1SettingsLabel(final int speed, final int damage, final int life, final String resource) {
        speedP1.setText(Integer.toString(speed));
        damageP1.setText(Integer.toString(damage));
        lifeP1.setText(Integer.toString(life));
        player1Image.setImage(new Image(ClassLoader.getSystemResource(PATH + "tank/blue" + resource).toExternalForm()));
    }

    /**
     * Sets second player tank stats and resource to view.
     * @param speed tank speed
     * @param damage tank damage
     * @param life tank life
     * @param resource tank resource
     */
    public void updatePlayer2SettingsLabel(final int speed, final int damage, final int life, final String resource) {
        speedP2.setText(Integer.toString(speed));
        damageP2.setText(Integer.toString(damage));
        lifeP2.setText(Integer.toString(life));
        player2Image.setImage(new Image(ClassLoader.getSystemResource(PATH + "tank/green" + resource).toExternalForm()));
    }

    /**
     * Sets map name and resource to view.
     * @param resource the resource
     * @param mapName the name
     */
    public void updateMapSettingsLabels(final String resource, final String mapName) {
        mapImage.setImage(new Image(ClassLoader.getSystemResource(PATH + "map/" + resource).toExternalForm()));
        mapLabel.setText(mapName);
    }

    /**
     * Sets actual {@link Scene}.
     * @param event event.
     */
    public void setPreviousScene(final ActionEvent event) {
        this.prevScene = MainViewController.converterFromEvent(event).getScene();
    }

}
