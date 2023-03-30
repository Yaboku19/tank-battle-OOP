package it.unibo.tankbattle.view.impl.javafx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import it.unibo.tankbattle.common.NextAndPrevious;
import it.unibo.tankbattle.view.api.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * javadock.
 */
public class MainViewController {

    private GameController gameController;
    private View viewController;
    private String tank1Resource;
    private String tank2Resource;
    private String mapResource;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox buttonBox;

    @FXML
    private Button playButton;

    @FXML
    private Button settingButton;

    @FXML
    private Button tutorialButton;

    @FXML
    void initialize() {

    }
    /**
     * javadoc.
     * @param event param
     */
    @FXML
    void play(final ActionEvent event) {
        final Node node = (Node) event.getSource();
        final Stage stage = (Stage) node.getScene().getWindow();
        try {
            final FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("layout/game.fxml"));
            viewController.setViewResources();
            gameController = new GameController(tank1Resource, tank2Resource, mapResource);
            viewController.setGameController(gameController);
            fxmlLoader.setControllerFactory(controller -> gameController);
            final Scene gameScene = new Scene(fxmlLoader.load());
            //addKeyListener();
            viewController.setGameScene(gameScene);
            stage.setScene(gameScene);
            //this.setDiagonalResize();
            stage.setResizable(true);
            viewController.startGame();
            this.addKeyListener(gameScene);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    /**
     * javadoc.
     * @param event param
     */
    @FXML
    void settings(final ActionEvent event) {
        try {
            final Node node = (Node) event.getSource();
            final Stage stage = (Stage) node.getScene().getWindow();
            final FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("layout/settings.fxml"));
            final Scene settings = new Scene(fxmlLoader.load());
            //controller = fxmlLoader.getController();
            final SettingsController settingsController = (SettingsController) fxmlLoader.getController();
            viewController.setSettingsController(settingsController);
            settingsController.setViewController(viewController);
            settingsController.setPreviousScene(stage.getScene());
            settingsController.setNameLabel();
            viewController.updateTankPlayer1(NextAndPrevious.NONE);
            viewController.updateTankPlayer2(NextAndPrevious.NONE);
            viewController.updateMap(NextAndPrevious.NONE);
            stage.setResizable(false);
            stage.setScene(settings);
            stage.sizeToScene();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    /**
     * javadoc.
     * @param event param
     */
    @FXML
    void tutorial(final ActionEvent event) {
        try {
            final Node node = (Node) event.getSource();
            final Stage stage = (Stage) node.getScene().getWindow();
            final FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("layout/tutorial.fxml"));
            final Scene tutorial = new Scene(fxmlLoader.load());
            //controller = fxmlLoader.getController();
            final TutorialController tutorialController = (TutorialController) fxmlLoader.getController();
            tutorialController.setPreviousScene(stage.getScene());
            stage.setScene(tutorial);
            //stage.setHeight(stage.getHeight()-0.01);
            //stage.setHeight(stage.getHeight()-0.01);
            stage.sizeToScene();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
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
     * @param tank1Resource param
     * @param tank2Resource param
     * @param mapResource param
     */
    public void setResource(final String tank1Resource, final String tank2Resource, final String mapResource) {
        this.tank1Resource = tank1Resource;
        this.tank2Resource = tank2Resource;
        this.mapResource = mapResource;
    }

    private void addKeyListener(final Scene gameScene) {
        final EventHandler<KeyEvent> keyPressListener = e -> {
            viewController.addCommand(e);
        };

        final EventHandler<KeyEvent> keyReleasedListener = e -> {
            viewController.addCommand(e);
        };
        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, keyPressListener);
        gameScene.addEventHandler(KeyEvent.KEY_RELEASED, keyReleasedListener);
    }

}
