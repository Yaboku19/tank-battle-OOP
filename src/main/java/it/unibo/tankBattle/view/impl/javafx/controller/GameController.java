package it.unibo.tankBattle.view.impl.javafx.controller;

import java.net.URL;
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
        player1.setX(t.getPosition().getX());
        player1.setY(t.getPosition().getY());
        player1.setFitWidth(t.getWidth());
        player1.setFitHeight(t.getLength());
        player1.setRotate(getRotation(t.getDirection())); 
    }

    public void renderSecondTank(Transform t){
        player2.setX(t.getPosition().getX());
        player2.setY(t.getPosition().getY());
        player2.setFitWidth(t.getWidth());
        player2.setFitHeight(t.getLength());
        player2.setRotate(getRotation(t.getDirection()));
    }

    public void renderBullet(Set<Transform> bullets){
        System.out.println("bullets " + bullets.size());
        for(var t : bullets){
            ImageView bullet = new ImageView("/images/bullet.png");
            mainPane.getChildren().add(bullet);
            bullet.setX(t.getPosition().getX());
            bullet.setY(t.getPosition().getY());
            bullet.setFitWidth(t.getWidth());
            bullet.setFitHeight(t.getLength());
            bullet.setRotate(getRotation(t.getDirection()));
        }
    }

    public void renderWall(Set<Transform> walls){
        System.out.println("wall " + walls.size());
        for(var t : walls){
            ImageView wall = new ImageView("/images/wall.png");
            mainPane.getChildren().add(wall);
            wall.setX(t.getPosition().getX());
            wall.setY(t.getPosition().getY());
            wall.setFitWidth(t.getWidth());
            wall.setFitHeight(t.getLength());
            wall.setRotate(getRotation(t.getDirection()));
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
