package it.unibo.tankBattle.view.impl.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.unibo.tankBattle.common.NextAndPrevious;
import it.unibo.tankBattle.view.api.View;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainViewController {

    private GameController gameController;
    private SettingsController settingsController;
    //private GameOverController gameOverController;
    private View viewController;
    private Node node;
    private Stage stage;
    private Scene gameScene;
    //private Scene mainMenuScene;
    private String tank1Resource;
    private String tank2Resource;
    private String mapResource;
    private ChangeListener<? super Number> widthChangeListener;
    private ChangeListener<? super Number> heightChangeListener;
    private boolean isDiagonalResize = false;
    
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

    @FXML
    void play(ActionEvent event) {
        node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("layout/game.fxml"));
            viewController.setViewResources();
            gameController = new GameController(tank1Resource, tank2Resource, mapResource);
            viewController.setGameController(gameController);
            fxmlLoader.setControllerFactory(controller -> gameController);
            gameScene = new Scene(fxmlLoader.load());
            addKeyListener();
            viewController.setGameScene(gameScene);
            stage.setScene(gameScene);
            this.setDiagonalResize();
            stage.setResizable(true);
            viewController.startGame();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @FXML
    void settings(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("layout/settings.fxml"));
            Scene settings = new Scene(fxmlLoader.load());
            //controller = fxmlLoader.getController();
            settingsController = (SettingsController)fxmlLoader.getController();
            viewController.setSettingsController(settingsController);
            settingsController.setViewController(viewController);
            settingsController.setPreviousScene(stage.getScene());
            viewController.updateTankPlayer1(NextAndPrevious.NONE);
            viewController.updateTankPlayer2(NextAndPrevious.NONE);
            viewController.updateMap(NextAndPrevious.NONE);
            stage.setResizable(false);
            stage.setScene(settings);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @FXML
    void tutorial(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("layout/tutorial.fxml"));
            Scene tutorial = new Scene(fxmlLoader.load());
            //controller = fxmlLoader.getController();
            TutorialController tutorialController = (TutorialController)fxmlLoader.getController();
            tutorialController.setPreviousScene(stage.getScene());
            stage.setScene(tutorial);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    public void setViewController(View viewController){
        this.viewController = viewController;
    }

    public void setResource(String tank1Resource, String tank2Resource, String mapResource){
        this.tank1Resource = tank1Resource;
        this.tank2Resource = tank2Resource;
        this.mapResource = mapResource;
    }

    private void addKeyListener(){
        EventHandler<KeyEvent> keyPressListener = e -> {
            viewController.addCommand(e);
        };
    
        EventHandler<KeyEvent> keyReleasedListener = e -> {
            viewController.addCommand(e);
        
        };
        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, keyPressListener);
        gameScene.addEventHandler(KeyEvent.KEY_RELEASED, keyReleasedListener);
    }

    private void setDiagonalResize() {
        if(!isDiagonalResize) {
            isDiagonalResize = true;
            widthChangeListener = (observable, oldValue, newValue) -> {
                stage.setHeight(newValue.doubleValue() * 2.0/ 3.0);
            };
            heightChangeListener = (observable, oldValue, newValue) -> {
                stage.setWidth(newValue.doubleValue() * 3.0 / 2.0);
            };
            stage.widthProperty().addListener(widthChangeListener);
            stage.heightProperty().addListener(heightChangeListener);
        }
    }
}
