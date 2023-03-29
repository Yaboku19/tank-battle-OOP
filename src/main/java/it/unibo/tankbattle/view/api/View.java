package it.unibo.tankbattle.view.api;

import java.util.stream.Stream;

import it.unibo.tankbattle.common.NextAndPrevious;
import it.unibo.tankbattle.common.Transform;
import it.unibo.tankbattle.controller.api.GameEngine;
import it.unibo.tankbattle.view.impl.javafx.controller.GameController;
import it.unibo.tankbattle.view.impl.javafx.controller.SettingsController;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * javadoc.
 */
public interface View {

    /**
     * javadoc.
     */
    void gameOver();

    /**
     * javadoc.
     * @param firstTank
     * @param secondTank
     * @param wall
     * @param bullet
     * @param lifeFirstTank
     * @param lifeSecondTank
     */
    void render(Transform firstTank, Transform secondTank, Stream<Transform> wall, 
            Stream<Transform> bullet,  int lifeFirstTank, int lifeSecondTank);

    /**
     * javadoc.
     * @param controller
     */
    void setController(GameEngine controller);

    /**
     * javadoc.
     * @param delta
     */
    void updateTankPlayer1(NextAndPrevious delta);

    /**
     * javadoc.
     * @param delta
     */
    void updateTankPlayer2(NextAndPrevious delta);

    /**
     * javadoc.
     * @param delta
     */
    void updateMap(NextAndPrevious delta);

    /**
     * javadoc.
     * @param speed
     * @param damage
     * @param life
     * @param resource
     */
    void viewUpdateP1(int speed, int damage, int life, String resource);

    /**
     * javadoc.
     * @param speed
     * @param damage
     * @param life
     * @param resource
     */
    void viewUpdateP2(int speed, int damage, int life, String resource);

    /**
     * javadoc.
     * @param resource
     */
    void viewUpdateMap(String resource);

    /**
     * javadoc.
     * @param tank1
     * @param tank2
     * @param mapResource
     */
    void setResource(String tank1, String tank2, String mapResource);

    /**
     * javadoc.
     * @param stage
     */
    void start(Stage stage);

    /**
     * javadoc.
     */
    void restart();

    /**
     * javadoc.
     */
    void newStart();

    /**
     * javadoc.
     */
    void setViewResources();

    /**
     * javadoc.
     */
    void startGame();

    /**
     * javadoc.
     * @param e
     */
    void addCommand(KeyEvent e);

    /**
     * javadoc.
     * @param gameController
     */
    void setGameController(GameController gameController);

    /**
     * javadoc.
     * @param gameScene
     */
    void setGameScene(Scene gameScene);

    /**
     * javadoc.
     * @param code
     */
    void setWinner(String code);

    /**
     * javadoc.
     * @param settingsController
     */
    void setSettingsController(SettingsController settingsController);

    /**
     * javadoc.
     * @param firstPlayerName
     * @param secondPlayerName
     */
    void setPlayerName(String firstPlayerName, String secondPlayerName);

    /**
     * javadoc.
     * @return first player's name
     */
    String getFirstPlayerName();

    /**
     * javadoc.
     * @return second player's name
     */
    String getSecondPlayerName();

}
