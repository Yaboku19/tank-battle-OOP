package it.unibo.tankBattle.view.impl.javafx.controller;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;
import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.common.input.api.Direction;
import javafx.animation.AnimationTimer;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class GameController {

    private Image bulletImage;
    private Image wallImage;
    private Set<ImageView> wallSet = new HashSet<>();
    private double standardHeight = 1;
    private double standardWidth = 1;
    private boolean isProportionSet = false;
    private Set<Transform> activeBullet;
    private Image shotSprite;
    private Set<ImageView> spriteSet = new HashSet<>();
    private MediaPlayer mediaPlayer;
    private Media shoot;

    private static final double RIGHT_ANGLE = 90;
    private static final double STRAIGHT_ANGLE = 180;    

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label firstTankLife;

    @FXML
    private Label secondTankLife;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private ImageView player1;

    @FXML
    private ImageView player2;

    @FXML
    private Image backImage;

    @FXML
    void initialize() {
        //Image tank = new Image("/images/tank.gif");
        bulletImage = new Image("/images/cannonBall1.png");
        wallImage = new Image("/images/box.png");
        mainPane.setBackground(new Background(new BackgroundImage(backImage, 
            BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
            BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        mainPane.getChildren().add(player1);
        mainPane.getChildren().add(player2);
    }

    public GameController(String tank1, String tank2, String map) {
        player1 = new ImageView(new Image(ClassLoader.getSystemResource("images/tank/" + tank1).toExternalForm()));
        player2 = new ImageView(new Image(ClassLoader.getSystemResource("images/tank/" + tank2).toExternalForm()));
        backImage = new Image((ClassLoader.getSystemResource("images/map/" + map).toExternalForm()));
        shotSprite = new Image((ClassLoader.getSystemResource("images/spriteShot.gif").toExternalForm()));
        this.activeBullet = new HashSet<>();
        loadAudioResource();
    }

    public void clear() {
        mainPane.getChildren().removeAll(mainPane.getChildren());
    }

    public void renderFirstTank(Transform t){
        player1.setX(t.getUpperLeftPosition().getX()*getWidth());
        player1.setY(t.getUpperLeftPosition().getY()*getHeight());
        player1.setFitWidth(t.getWidth()*getWidth());
        player1.setFitHeight(t.getLength()*getHeight());
        player1.setRotate(getRotation(t.getDirection()));
        mainPane.getChildren().add(player1);
    }

    public void renderSecondTank(Transform t) {
        player2.setX(t.getUpperLeftPosition().getX()*getWidth());
        player2.setY(t.getUpperLeftPosition().getY()*getHeight());
        player2.setFitWidth(t.getWidth()*getWidth());
        player2.setFitHeight(t.getLength()*getHeight());
        player2.setRotate(getRotation(t.getDirection()));
        mainPane.getChildren().add(player2);
    }

    public void renderBullet(Set<Transform> bullets) {
        for(var b : bullets){
            ImageView bullet = new ImageView(bulletImage);
            bullet.setX(b.getUpperLeftPosition().getX()*getWidth());
            bullet.setY(b.getUpperLeftPosition().getY()*getHeight());
            bullet.setFitWidth(b.getWidth()*getWidth());
            bullet.setFitHeight(b.getLength()*getHeight());
            bullet.setRotate(getRotation(b.getDirection()));
            mainPane.getChildren().add(bullet);
        }
        var newBullets = findNewBullet(bullets);
        if(newBullets.size() > 0) {
            Task<Void> audioTask = new Task<Void>() {
                @Override
                protected Void call() throws Exception {

                   mediaPlayer = new MediaPlayer(shoot);
                   mediaPlayer.play();
          
                   return null;
                }
             };
             new Thread(audioTask).start();
        }
        newBullets.forEach(pos -> renderBulletSprite(pos));
        findExplodeBullet(bullets).forEach(pos -> renderBulletSprite(pos));
        mainPane.getChildren().addAll(spriteSet);
        this.activeBullet = bullets;
    }

    private void loadAudioResource() {
        try {
            shoot = new Media(ClassLoader.getSystemResource("audio/shoot.mp3").toURI().toString());
            mediaPlayer = new MediaPlayer(shoot);
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
    }

    private Set<Transform> findNewBullet(Set<Transform> bullets) {
        Set<Double> activeBulletX = new HashSet<>();
        Set<Double> activeBulletY = new HashSet<>();
        activeBullet.forEach(bull -> {
            activeBulletX.add(bull.getUpperLeftPosition().getX());
            activeBulletY.add(bull.getUpperLeftPosition().getY());
        });
        return bullets.stream()
                .filter(pos -> !activeBulletX.contains(pos.getUpperLeftPosition().getX()))
                .filter(pos -> !activeBulletY.contains(pos.getUpperLeftPosition().getY()))
                .collect(Collectors.toSet());
    }

    private Set<Transform> findExplodeBullet(Set<Transform> bullets) {
        Set<Double> activeBulletX = new HashSet<>();
        Set<Double> activeBulletY = new HashSet<>();
        bullets.forEach(bull -> {
            activeBulletX.add(bull.getUpperLeftPosition().getX());
            activeBulletY.add(bull.getUpperLeftPosition().getY());
        });
        return activeBullet.stream()
                .filter(pos -> !activeBulletX.contains(pos.getUpperLeftPosition().getX()))
                .filter(pos -> !activeBulletY.contains(pos.getUpperLeftPosition().getY()))
                .collect(Collectors.toSet());
    }

    public void renderWall(Set<Transform> walls) {
        wallSet.clear();
        this.setProportion(walls);
        for(var t : walls) {
            ImageView wall = new ImageView(wallImage);
            wall.setX(t.getUpperLeftPosition().getX()*getWidth());
            wall.setY(t.getUpperLeftPosition().getY()*getHeight());
            wall.setFitWidth(t.getWidth()*getWidth());
            wall.setFitHeight(t.getLength()*getHeight());
            wall.setRotate(getRotation(t.getDirection()));
            this.wallSet.add(wall);
        }        
        mainPane.getChildren().addAll(wallSet);
    }

    public void updateLifeLabel(int firstTank, int secondTank){
        firstTankLife.setText(Integer.toString(firstTank));
        secondTankLife.setText(Integer.toString(secondTank));
    }

    private double getRotation(Direction dir) {
        return switch(dir) {
            case RIGHT -> GameController.RIGHT_ANGLE;
            case DOWN -> GameController.STRAIGHT_ANGLE;
            case LEFT -> (GameController.RIGHT_ANGLE + GameController.STRAIGHT_ANGLE);
            default -> 0;
        };
    }

    private double getWidth() {
        return mainPane.getWidth() / standardWidth;
    }

    private double getHeight() {
        return mainPane.getHeight() / standardHeight;
    }

    private void setProportion(Set<Transform> walls) {
        if(!isProportionSet) {
            this.isProportionSet = true;
            double maxX = 0.0;
            double maxY = 0.0;
            for (Transform transform : walls) {
                maxX = Math.max(maxX, transform.getUpperLeftPosition().getX());
                maxY = Math.max(maxY, transform.getUpperLeftPosition().getY());
            }
            this.standardWidth = maxX + walls.iterator().next().getWidth();
            this.standardHeight = maxY + walls.iterator().next().getLength();
        }
    }

    public void renderBulletSprite(Transform shotPoint) {
        final AnimationTimer animation = new AnimationTimer() {

            private ImageView spriteImage;
            private long startTime;

            @Override
            public void start() {
                super.start();
                startTime = System.nanoTime();
                spriteImage = new ImageView(shotSprite);
                spriteImage.setX((shotPoint.getPosition().getX()-shotPoint.getWidth())*getWidth());
                spriteImage.setY((shotPoint.getPosition().getY()-shotPoint.getLength())*getHeight());
                spriteImage.setFitWidth(getWidth()*shotPoint.getWidth()*2);
                spriteImage.setFitHeight(getHeight()*shotPoint.getLength()*2);
                spriteImage.setRotate(getRotation(shotPoint.getDirection()));
                spriteSet.add(spriteImage);
            }

            @Override
            public void handle(long now) {
                long elapsedTime = now - startTime;
                if(elapsedTime > 400_000_000) {
                    spriteSet.remove(spriteImage);
                    this.stop();
                }
            }
        };
        animation.start();
    }

    /*@Override
    public void run() {
        mediaPlayer.play();
    }*/
}
