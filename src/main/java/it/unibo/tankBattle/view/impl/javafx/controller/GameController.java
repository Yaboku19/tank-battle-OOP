package it.unibo.tankBattle.view.impl.javafx.controller;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.common.input.api.Direction;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class GameController {

    private Scene scene;
    private Image bulletImage;
    private Image wallImage;
    private Set<ImageView> wallSet = new HashSet<>();
    private Set<ImageView> bulletSet = new HashSet<>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private ImageView player1;

    @FXML
    private ImageView player2;

    @FXML
    void initialize() {
        //Image tank = new Image("/images/tank.gif");
        bulletImage = new Image("/images/bullet1.png");
        wallImage = new Image("/images/obstacle.png");
        
        //player1 = new ImageView(tank);
        //player2 = new ImageView(tank);
        mainPane.getChildren().add(player1);
        mainPane.getChildren().add(player2);
    }

    public GameController(String tank1, String tank2){
        player1 = new ImageView(new Image(ClassLoader.getSystemResource("images/tank/" + tank1).toExternalForm()));
        player2 = new ImageView(new Image(ClassLoader.getSystemResource("images/tank/" + tank2).toExternalForm()));
    }

    public void clear(){
        mainPane.getChildren().removeAll(mainPane.getChildren());
    }

    public void renderFirstTank(Transform t){
        player1.setX(t.getUpperLeftPosition().getX());
        player1.setY(t.getUpperLeftPosition().getY());
        player1.setFitWidth(t.getWidth());
        player1.setFitHeight(t.getLength());
        player1.setRotate(getRotation(t.getDirection())); 
        mainPane.getChildren().add(player1);
    }

    public void renderSecondTank(Transform t) {
        player2.setX(t.getUpperLeftPosition().getX());
        player2.setY(t.getUpperLeftPosition().getY());
        player2.setFitWidth(t.getWidth());
        player2.setFitHeight(t.getLength());
        player2.setRotate(getRotation(t.getDirection()));
        mainPane.getChildren().add(player2);
    }

    public void renderBullet(Set<Transform> bullets) {
        for(var b : bullets){
            ImageView bullet = new ImageView(bulletImage);
            bullet.setX(b.getUpperLeftPosition().getX());
            bullet.setY(b.getUpperLeftPosition().getY());
            bullet.setFitWidth(b.getWidth());
            bullet.setFitHeight(b.getLength());
            bullet.setRotate(getRotation(b.getDirection()));
            mainPane.getChildren().add(bullet);
        }
    }

    public void renderWall(Set<Transform> walls) {
        if(this.wallSet.size() == 0) {
            System.out.println("wallSet.size = 0");
            System.out.println("set dei walls " + walls.size());
            for(var t : walls){
                ImageView wall = new ImageView(wallImage);
                wall.setX(t.getUpperLeftPosition().getX());
                wall.setY(t.getUpperLeftPosition().getY());
                wall.setFitWidth(t.getWidth());
                wall.setFitHeight(t.getLength());
                wall.setRotate(getRotation(t.getDirection()));
                this.wallSet.add(wall);
            }
            System.out.println("wallSet.size = " + wallSet.size());
        }        
        mainPane.getChildren().addAll(wallSet);
    }

    private double getRotation(Direction dir) {
        switch(dir) {
            case RIGHT:
                return 90;
            case DOWN:
                return 180;
            case LEFT: 
                return 270;
            default:
                return 0;
        }
    }

    public void setTanksResource(String tank1Resource, String tank2Resource){

        /*player1 = new ImageView(new Image(tank1Resource));
        player2 = new ImageView(new Image(tank2Resource));   */
    }

}
