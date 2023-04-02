package it.unibo.tankbattle.view.impl.javafx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
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
 * Represents the main menu {@link Scene} controller.
 */
public class MainViewController {

    private GameController gameController;
    private View viewController;
    private String tank1Resource;
    private String tank2Resource;
    private String mapResource;
    private static final Logger LOGGER = Logger.getLogger("MainViewControllerLog");

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
     * Start a new game with the chosen settings, 
     * standard settings if not chosen.
     * @param event button click
     */
    @FXML
    void play(final ActionEvent event) {
        final Stage stage = converterFromEvent(event);
        try {
            final FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("layout/game.fxml"));
            viewController.setViewResources();
            gameController = new GameController(tank1Resource, tank2Resource, mapResource);
            viewController.setGameController(gameController);
            fxmlLoader.setControllerFactory(controller -> gameController);
            final Scene gameScene = new Scene(fxmlLoader.load());
            viewController.setGameScene(gameScene);
            stage.setScene(gameScene);
            stage.setResizable(true);
            viewController.startGame();
            this.addKeyListener(gameScene);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Game scene load error.");
        }
    }
    /**
     * Sets the {@link Scene} to the Settings scene.
     * @param event button click
     */
    @FXML
    void settings(final ActionEvent event) {
        try {
            final Stage stage = converterFromEvent(event);
            final FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("layout/settings.fxml"));
            final Scene settings = new Scene(fxmlLoader.load());
            //controller = fxmlLoader.getController();
            final SettingsController settingsController = (SettingsController) fxmlLoader.getController();
            viewController.setSettingsController(settingsController);
            settingsController.setViewController(viewController);
            settingsController.setPreviousScene(stage.getScene());
            settingsController.setPlayerNameLabel();
            viewController.askTankPlayer1Settings(NextAndPrevious.NONE);
            viewController.askTankPlayer2Settings(NextAndPrevious.NONE);
            viewController.askMapSettings(NextAndPrevious.NONE);
            stage.setResizable(false);
            stage.setScene(settings);
            stage.sizeToScene();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Settings scene load error.");
        }
    }
    /**
     * Sets the {@link Scene} to the tutorial scene.
     * @param event button click
     */
    @FXML
    void tutorial(final ActionEvent event) {
        try {
            final Stage stage = converterFromEvent(event);
            final FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("layout/tutorial.fxml"));
            final Scene tutorial = new Scene(fxmlLoader.load());
            final TutorialController tutorialController = (TutorialController) fxmlLoader.getController();
            tutorialController.setViewController(viewController);
            tutorialController.setNameLabel();
            tutorialController.setPreviousScene(stage.getScene());
            stage.setScene(tutorial);
            stage.sizeToScene();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Tutorial scene load error.");
        }
    }
    /**
     * Sets the {@link View} controller.
     * @param viewController the {@link View} controller
     */
    @SuppressFBWarnings(
        value = {"EI_EXPOSE_REP2"}, 
        justification = "I need that istance of the object not its copy"
    )
    public void setViewController(final View viewController) {
        this.viewController = viewController;
    }
    /**
     * Sets the tanks and map resources.
     * @param tank1Resource first tank resource
     * @param tank2Resource second tank resource
     * @param mapResource map resource
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

    static Stage converterFromEvent(final ActionEvent event) {
        final Node node = (Node) event.getSource();
        final var converter = node.getScene().getWindow();
        if (!(converter instanceof Stage)) {
            throw new AssertionError("Unexpected type: " + converter);
        }
        return (Stage) converter;
    }
}
