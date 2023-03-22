package it.unibo.tankBattle.view.impl.javafx.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.view.api.GameSetup;
import it.unibo.tankBattle.view.api.MapImage;
import it.unibo.tankBattle.view.api.TankImage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class ChooseMenu implements Initializable{

    private Scene prevScene;
    private TankImage tankImagePlayer1 = TankImage.SUPERPOWERTANK;
    private TankImage tankImagePlayer2 = TankImage.SIMPLETANK;
    private MapImage mapImageChoose = MapImage.MAP1;
    private Map<String, String> configMap;
    private GameEngine controller = null;
    //private List tankConfigs = new ArrayList<>();
    //private int contP1 = 0;
    //private int contP2 = 0;

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
        //controller.nextTankPlayer1();
        //contP1 += 1;
        //updateP1();
        tankImagePlayer1 = tankImagePlayer1.next();
        player1Image.setImage(tankImagePlayer1.getImage());
    }

    @FXML
    void prevTankPlayer1(ActionEvent event) {
        //controller.prevTankPlayer1();
        //contP1 -= 1;
        //updateP1();
        tankImagePlayer1 = tankImagePlayer1.prev();
        player1Image.setImage(tankImagePlayer1.getImage());
    }

    @FXML
    void nextTankPlayer2(ActionEvent event) {
        //controller.nextTankPlayer2();
        tankImagePlayer2 = tankImagePlayer2.next();
        player2Image.setImage(tankImagePlayer2.getImage());
    }

    @FXML
    void prevTankPlayer2(ActionEvent event) {
        //controller.prevTankPlayer2();
        tankImagePlayer2 = tankImagePlayer2.prev();
        player2Image.setImage(tankImagePlayer2.getImage());
    }

    @FXML
    void nextMap(ActionEvent event) {
        //controller.nextMap();
        mapImageChoose = mapImageChoose.next();
        mapImage.setImage(mapImageChoose.getImage());
    }

    @FXML
    void prevMap(ActionEvent event) {
        //controller.prevMap();
        mapImageChoose = mapImageChoose.prev();
        mapImage.setImage(mapImageChoose.getImage());
    }

    @FXML
    void back(ActionEvent event) {
        Node node = (Node)event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(prevScene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        player1Image.setImage(tankImagePlayer1.getImage());
        player2Image.setImage(tankImagePlayer2.getImage());
        mapImage.setImage(mapImageChoose.getImage());
        //loadConfig();
    }

    public void setController(GameEngine controller){
        this.controller = controller;
    }

    /*private void loadConfig(){
        try(InputStream inputStream = ClassLoader.getSystemResourceAsStream("config/config.yaml")){
        //try (InputStream inputStream = new FileInputStream(new File(ClassLoader.getSystemResource("config/config.yaml").toURI()))) {
            Yaml yaml = new Yaml();
            configMap = yaml.load(inputStream);
            System.out.println(configMap);
        } catch (Exception e) {
            System.out.println("eccezioneeeeeeee");
            e.printStackTrace();
        }
        /*for(var key : configMap.keySet()){
            switch(key){
                case "tankImagePlayer1":
                    tankImagePlayer1 = TankImage.SIMPLETANK;
                    break;
                case "tankImagePlayer2":
                    tankImagePlayer2 = TankImage.SIMPLETANK;
                    break;
                case "mapImageChoose":
                    mapImageChoose = MapImage.MAP1;
                    break;
            }
        }

    }*/

    public void setPreviousScene(Scene prevScene){
        this.prevScene = prevScene;
    }

    /*@Override
    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    @Override
    public Integer getSpeed() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSpeed'");
    }

    @Override
    public Integer getLife() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLife'");
    }

    @Override
    public Integer getDamage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLife'");
    }*/


    /*public void updateP1(int speed, int damage, int life, String resource){
        speedP1.setText(speed);
        .
        .
        .
    }
    */


    /*public void updateP2(int speed, int damage, int life, String resource){
        speedP2.setText(speed);
        .
        .
        .
    }
    */
}
