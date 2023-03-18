package it.unibo.tankBattle.view.impl.javafx.controller;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.controller.api.Player;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameController {

    private Scene scene;
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
        //assert player1 != null : "fx:id=\"player1\" was not injected: check your FXML file 'game.fxml'.";
        //assert player2 != null : "fx:id=\"player2\" was not injected: check your FXML file 'game.fxml'.";
        Image tank = new Image("/images/tank.gif");
        
        player1 = new ImageView(tank);
        player2 = new ImageView(tank);
        //mainPane = new AnchorPane();
        mainPane.getChildren().add(player1);
        mainPane.getChildren().add(player2);
    }

    public void renderFirstTank(Transform t){
        player1.setX(t.getUpperLeftPosition().getX());
        player1.setY(t.getUpperLeftPosition().getY());
        player1.setFitWidth(t.getWidth());
        player1.setFitHeight(t.getLength());
        player1.setRotate(getRotation(t.getDirection())); 
    }

    public void renderSecondTank(Transform t) {
        player2.setX(t.getUpperLeftPosition().getX());
        player2.setY(t.getUpperLeftPosition().getY());
        player2.setFitWidth(t.getWidth());
        player2.setFitHeight(t.getLength());
        player2.setRotate(getRotation(t.getDirection()));
    }

    public void renderBullet(Set<Transform> bullets) {
        if(bullets.size() > bulletSet.size()){ //to improve
            ImageView bullet = new ImageView("/images/bullet1.png");
            bulletSet.add(bullet);
            mainPane.getChildren().add(bullet);
        }
        if(bullets.size() < bulletSet.size()) {
            bulletSet.remove(bulletSet.iterator().next());
        }
        var iterator = bullets.iterator();
        for (var image : bulletSet) {
            Transform trans = iterator.next();
            image.setX(trans.getUpperLeftPosition().getX());
            image.setY(trans.getUpperLeftPosition().getY());
            image.setFitWidth(trans.getWidth());
            image.setFitHeight(trans.getLength());
            image.setRotate(getRotation(trans.getDirection()));
        }
    }

    public void renderWall(Set<Transform> walls) {
        //System.out.println("wall " + wallSet.size());
        //mainPane.getChildren().removeAll(wallSet);
        //this.wallSet.clear();
        if(this.wallSet.size() == 0) {
            for(var t : walls){
                ImageView wall = new ImageView("/images/obstacle.png");
                mainPane.getChildren().add(wall);
                wall.setX(t.getUpperLeftPosition().getX());
                wall.setY(t.getUpperLeftPosition().getY());
                wall.setFitWidth(t.getWidth());
                wall.setFitHeight(t.getLength());
                wall.setRotate(getRotation(t.getDirection()));
                this.wallSet.add(wall);
            }
        }
    }

    private double getRotation(Directions dir) {
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

}
