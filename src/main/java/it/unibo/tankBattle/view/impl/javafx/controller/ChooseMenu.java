package it.unibo.tankBattle.view.impl.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ChooseMenu {

    private Scene prevScene;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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

    @FXML
    void nextMap(ActionEvent event) {

    }

    @FXML
    void nextTankPlayer1(ActionEvent event) {

    }

    @FXML
    void nextTankPlayer2(ActionEvent event) {

    }

    @FXML
    void prevMap(ActionEvent event) {

    }

    @FXML
    void prevTankPlayer1(ActionEvent event) {

    }

    @FXML
    void prevTankPlayer2(ActionEvent event) {

    }

    @FXML
    void back(ActionEvent event) {
        Node node = (Node)event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(prevScene);
    }

    @FXML
    void save(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert mapImage != null : "fx:id=\"mapImage\" was not injected: check your FXML file 'chooseMenu.fxml'.";
        assert nextMap != null : "fx:id=\"nextMap\" was not injected: check your FXML file 'chooseMenu.fxml'.";
        assert nextTankPlayer1 != null : "fx:id=\"nextTankPlayer1\" was not injected: check your FXML file 'chooseMenu.fxml'.";
        assert nextTankPlayer2 != null : "fx:id=\"nextTankPlayer2\" was not injected: check your FXML file 'chooseMenu.fxml'.";
        assert player1Image != null : "fx:id=\"player1Image\" was not injected: check your FXML file 'chooseMenu.fxml'.";
        assert player2Image != null : "fx:id=\"player2Image\" was not injected: check your FXML file 'chooseMenu.fxml'.";
        assert prevMap != null : "fx:id=\"prevMap\" was not injected: check your FXML file 'chooseMenu.fxml'.";
        assert prevTankPlayer1 != null : "fx:id=\"prevTankPlayer1\" was not injected: check your FXML file 'chooseMenu.fxml'.";
        assert prevTankPlayer2 != null : "fx:id=\"prevTankPlayer2\" was not injected: check your FXML file 'chooseMenu.fxml'.";

    }

    public void setPreviousScene(Scene prevScene){
        this.prevScene = prevScene;
    }

}
