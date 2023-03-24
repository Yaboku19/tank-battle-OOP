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


public class ChooseMenu implements Initializable{

    private Scene prevScene;
    /*private TankImage tankImagePlayer1 = TankImage.SUPERPOWERTANK;
    private TankImage tankImagePlayer2 = TankImage.SIMPLETANK;
    private MapImage mapImageChoose = MapImage.MAP1;
    private Map<String, String> configMap;*/
    private View viewController;
    private final String PATH = "images" + "/";
    //private List tankConfigs = new ArrayList<>();
    //private int contP1 = 0;
    //private int contP2 = 0;

    public ChooseMenu() {
    }

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

    @FXML
    void nextTankPlayer1(ActionEvent event) {
        viewController.updateTankPlayer1(NextAndPrevious.NEXT);
        /*tankImagePlayer1 = tankImagePlayer1.next();
        player1Image.setImage(tankImagePlayer1.getImage());*/
    }

    @FXML
    void prevTankPlayer1(ActionEvent event) {
        viewController.updateTankPlayer1(NextAndPrevious.PREVIOUS);
        /*tankImagePlayer1 = tankImagePlayer1.prev();
        player1Image.setImage(tankImagePlayer1.getImage());*/
    }

    @FXML
    void nextTankPlayer2(ActionEvent event) {
        viewController.updateTankPlayer2(NextAndPrevious.NEXT);
        //viewController.nextTankPlayer2();
        /*tankImagePlayer2 = tankImagePlayer2.next();
        player2Image.setImage(tankImagePlayer2.getImage());*/
    }

    @FXML
    void prevTankPlayer2(ActionEvent event) {
        viewController.updateTankPlayer2(NextAndPrevious.PREVIOUS);
        //viewController.prevTankPlayer2();
        /*tankImagePlayer2 = tankImagePlayer2.prev();
        player2Image.setImage(tankImagePlayer2.getImage());*/
    }

    @FXML
    void nextMap(ActionEvent event) {
        viewController.updateMap(NextAndPrevious.NEXT);
        //viewController.nextMap();
        /*mapImageChoose = mapImageChoose.next();
        mapImage.setImage(mapImageChoose.getImage());*/
    }

    @FXML
    void prevMap(ActionEvent event) {
        viewController.updateMap(NextAndPrevious.PREVIOUS);
        //viewController.prevMap();
        /*mapImageChoose = mapImageChoose.prev();
        mapImage.setImage(mapImageChoose.getImage());*/
    }

    @FXML
    void back(ActionEvent event) {
        Node node = (Node)event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(prevScene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setViewController(View viewController){
        this.viewController = viewController;
    }


    public void setPreviousScene(Scene prevScene){
        this.prevScene = prevScene;
    }

    public void updateP1(int speed, int damage, int life, String resource){
        speedP1.setText(Integer.toString(speed));
        damageP1.setText(Integer.toString(damage));
        lifeP1.setText(Integer.toString(life));
        player1Image.setImage(new Image(ClassLoader.getSystemResource(PATH + "tank/blue" + resource).toExternalForm()));
    }

    public void updateP2(int speed, int damage, int life, String resource){
        speedP2.setText(Integer.toString(speed));
        damageP2.setText(Integer.toString(damage));
        lifeP2.setText(Integer.toString(life));
        player2Image.setImage(new Image(ClassLoader.getSystemResource(PATH + "tank/green" + resource).toExternalForm()));
    }

    public void updateMap(String resource){
        mapImage.setImage(new Image(ClassLoader.getSystemResource(PATH + "map/" + resource).toExternalForm()));
    }

}
