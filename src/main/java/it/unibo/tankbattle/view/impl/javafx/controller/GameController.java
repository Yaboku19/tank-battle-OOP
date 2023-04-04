package it.unibo.tankbattle.view.impl.javafx.controller;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;
import it.unibo.tankbattle.common.Transform;
import it.unibo.tankbattle.common.input.api.Direction;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * This represents the contoller of the game Scene.
 */
public class GameController {

    private final Image bulletImage;
    private final Image wallImage;
    private final ImageView player1;
    private final ImageView player2;
    private final Image backImage;
    private final Set<ImageView> wallSet = new HashSet<>();
    private double standardHeight = 1;
    private double standardWidth = 1;
    private boolean isProportionSet;
    private Set<Transform> activeBullet;
    private final Image shotSprite;
    private final Set<ImageView> spriteSet = new HashSet<>();
    private Media shoot;
    private static final Logger LOGGER = Logger.getLogger("GameControllerLog");


    private static final double RIGHT_ANGLE = 90;
    private static final double STRAIGHT_ANGLE = 180;
    private static final long ANIMATION_TIME = 400_000_000;

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
    private Label player1Label;

    @FXML
    private Label player2Label;

    @FXML
    private Label scoreLabel;

    /**
    * Initialize the GameController.
    */
    @FXML
    void initialize() {

        mainPane.setBackground(new Background(new BackgroundImage(backImage, 
            BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
            BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
    }

    /**
     * Create a new GameController, with the specified resources.
     * @param tank1 the first tank resources
     * @param tank2 the second tank resources
     * @param map the map resources
     */
    public GameController(final String tank1, final String tank2, final String map) {
        player1 = new ImageView(new Image(ClassLoader.getSystemResource("images/tank/" + tank1).toExternalForm()));
        player2 = new ImageView(new Image(ClassLoader.getSystemResource("images/tank/" + tank2).toExternalForm()));
        bulletImage = new Image(ClassLoader.getSystemResource("images/bullet/cannonBall.png").toExternalForm());
        wallImage = new Image(ClassLoader.getSystemResource("images/obstacles/obstacle" + map).toExternalForm());
        backImage = new Image(ClassLoader.getSystemResource("images/map/background" + map).toExternalForm());
        shotSprite = new Image(ClassLoader.getSystemResource("images/bullet/spriteShot.gif").toExternalForm());
        this.activeBullet = new HashSet<>();
        loadAudioResource();
    }

    /**
     * Remove all the children from the mainPane, it's called each frame.
     */
    public void clear() {
        mainPane.getChildren().removeAll(mainPane.getChildren());
    }

    /**
     * Render the first tank.
     * @param transform the first tank {@link Transform}
     */
    public void renderFirstTank(final Transform transform) {
        player1.setX(transform.getUpperLeftPosition().getX() * getWidth());
        player1.setY(transform.getUpperLeftPosition().getY() * getHeight());
        player1.setFitWidth(transform.getWidth() * getWidth());
        player1.setFitHeight(transform.getLength() * getHeight());
        player1.setRotate(getRotation(transform.getDirection()));
        mainPane.getChildren().add(player1);
        firstTankLife.setTranslateX(getWidth());
        firstTankLife.setTranslateY(getHeight());
    }

    /**
     * Render the second tank.
     * @param transform the second tank {@link Transform}
     */
    public void renderSecondTank(final Transform transform) {
        player2.setX(transform.getUpperLeftPosition().getX() * getWidth());
        player2.setY(transform.getUpperLeftPosition().getY() * getHeight());
        player2.setFitWidth(transform.getWidth() * getWidth());
        player2.setFitHeight(transform.getLength() * getHeight());
        player2.setRotate(getRotation(transform.getDirection()));
        mainPane.getChildren().add(player2);
    }

    /**
     * Render all the bullets presents.
     * @param bullets the bullets {@link Set} of {@link Transform}
     */
    public void renderBullet(final Set<Transform> bullets) {
        for (final Transform b : bullets) {
            final ImageView bullet = new ImageView(bulletImage);
            bullet.setX(b.getUpperLeftPosition().getX() * getWidth());
            bullet.setY(b.getUpperLeftPosition().getY() * getHeight());
            bullet.setFitWidth(b.getWidth() * getWidth());
            bullet.setFitHeight(b.getLength() * getHeight());
            bullet.setRotate(getRotation(b.getDirection()));
            mainPane.getChildren().add(bullet);
        }
        final var newBullets = findBullet(bullets, this.activeBullet);
        if (!newBullets.isEmpty()) {
            playShootAudio();
        }
        newBullets.forEach(pos -> renderBulletSprite(pos));
        findBullet(this.activeBullet, bullets).forEach(pos -> renderBulletSprite(pos));
        mainPane.getChildren().addAll(spriteSet);
        this.activeBullet = new HashSet<>(bullets);
    }
    /**
     * Render all the walls presents.
     * @param walls the walls {@link Set} of {@link Transform}
     */
    public void renderWall(final Set<Transform> walls) {
        wallSet.clear();
        this.setProportion(walls);
        for (final var t : walls) {
            final ImageView wall = new ImageView(wallImage);
            wall.setX(t.getUpperLeftPosition().getX() * getWidth());
            wall.setY(t.getUpperLeftPosition().getY() * getHeight());
            wall.setFitWidth(t.getWidth() * getWidth());
            wall.setFitHeight(t.getLength() * getHeight());
            wall.setRotate(getRotation(t.getDirection()));
            this.wallSet.add(wall);
        }
        mainPane.getChildren().addAll(wallSet);
    }

    /**
     * This method render lifes label in the scene.
     * @param firstTank first tank's life
     * @param secondTank second tank's life
     */
    public void updateLifeLabel(final int firstTank, final int secondTank) {
        firstTankLife.setText(Integer.toString(firstTank));
        secondTankLife.setText(Integer.toString(secondTank));
        mainPane.getChildren().add(firstTankLife);
        mainPane.getChildren().add(secondTankLife);
    }

    /**
     * This method render players names and scores in the scene.
     * @param firstPlayerName first player name
     * @param secondPlayerName second player name
     * @param firstPlayerScore first player score
     * @param secondPlayerScore second player score
     */
    public void drawLabel(final String firstPlayerName, final String secondPlayerName, 
            final int firstPlayerScore, final int secondPlayerScore) {
        player1Label.setText(firstPlayerName);
        player2Label.setText(secondPlayerName);
        scoreLabel.setText(Integer.toString(secondPlayerScore) + " - " + Integer.toString(firstPlayerScore));
        mainPane.getChildren().add(player1Label);
        mainPane.getChildren().add(player2Label);
        mainPane.getChildren().add(scoreLabel);
    }

    /**
     * This method start an {@link AnimationTimer} of the explosion bullet 
     * with data of the given {@link Transform}.
     * @param shotPoint {@link Transform} with the dimension and position of the 
     * {@link AnimationTimer}
     */
    public void renderBulletSprite(final Transform shotPoint) {
        final AnimationTimer animation = new AnimationTimer() {

            private ImageView spriteImage;
            private long startTime;

            @Override
            public void start() {
                super.start();
                startTime = System.nanoTime();
                spriteImage = new ImageView(shotSprite);
                spriteImage.setX((shotPoint.getPosition().getX() - shotPoint.getWidth()) * getWidth());
                spriteImage.setY((shotPoint.getPosition().getY() - shotPoint.getLength()) * getHeight());
                spriteImage.setFitWidth(getWidth() * shotPoint.getWidth() * 2);
                spriteImage.setFitHeight(getHeight() * shotPoint.getLength() * 2);
                spriteImage.setRotate(getRotation(shotPoint.getDirection()));
                spriteSet.add(spriteImage);
            }

            @Override
            public void handle(final long now) {
                final long elapsedTime = now - startTime;
                if (elapsedTime > GameController.ANIMATION_TIME) {
                    spriteSet.remove(spriteImage);
                    this.stop();
                }
            }
        };
        animation.start();
    }

    private double getRotation(final Direction dir) {
        return switch (dir) {
            case RIGHT -> GameController.RIGHT_ANGLE;
            case DOWN -> GameController.STRAIGHT_ANGLE;
            case LEFT -> GameController.RIGHT_ANGLE + GameController.STRAIGHT_ANGLE;
            default -> 0;
        };
    }

    private double getWidth() {
        return mainPane.getWidth() / standardWidth;
    }

    private double getHeight() {
        return mainPane.getHeight() / standardHeight;
    }

    private void setProportion(final Set<Transform> walls) {
        if (!isProportionSet) {
            this.isProportionSet = true;
            double maxX = 0.0;
            double maxY = 0.0;
            for (final Transform transform : walls) {
                maxX = Math.max(maxX, transform.getUpperLeftPosition().getX());
                maxY = Math.max(maxY, transform.getUpperLeftPosition().getY());
            }
            this.standardWidth = maxX + walls.iterator().next().getWidth();
            this.standardHeight = maxY + walls.iterator().next().getLength();
        }
    }

    private void playShootAudio() {
        final Task<Void> audioTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

               final MediaPlayer mediaPlayer = new MediaPlayer(shoot);
               mediaPlayer.play();

               return null;
            }
         };
         new Thread(audioTask).start();
    }

    private void loadAudioResource() {
        try {
            shoot = new Media(ClassLoader.getSystemResource("audio/shoot.mp3").toURI().toString());
        } catch (URISyntaxException e) {
            LOGGER.log(Level.SEVERE, "load of audio gone wrong");
        }

    }

    private Set<Transform> findBullet(final Set<Transform> newBullet, final Set<Transform> oldBullet) {
        final Set<Double> bulletX = new HashSet<>();
        final Set<Double> bulletY = new HashSet<>();
        oldBullet.forEach(bull -> {
            bulletX.add(bull.getUpperLeftPosition().getX());
            bulletY.add(bull.getUpperLeftPosition().getY());
        });
        return newBullet.stream()
                .filter(pos -> !bulletX.contains(pos.getUpperLeftPosition().getX()))
                .filter(pos -> !bulletY.contains(pos.getUpperLeftPosition().getY()))
                .collect(Collectors.toSet());
    }
}
