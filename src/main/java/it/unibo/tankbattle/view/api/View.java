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
 * javadock.
 */
public interface View {
    /**
     * javadock.
     */
    void gameOver();
    /**
     * javadock.
     * @param firstTank param
     * @param secondTank param
     * @param wall param
     * @param bullet param
     * @param lifeFirstTank param
     * @param lifeSecondTank param
     */
    void render(Transform firstTank, Transform secondTank, Stream<Transform> wall,
        Stream<Transform> bullet,  int lifeFirstTank, int lifeSecondTank);
    /**
     * javadock.
     * @param controller param
     */
    void setController(GameEngine controller);
    /**
     * javadock.
     * @param delta param
     */
    void updateTankPlayer1(NextAndPrevious delta);
    /**
     * javadock.
     * @param delta param
     */
    void updateTankPlayer2(NextAndPrevious delta);
    /**
     * javadock.
     * @param delta param
     */
    void updateMap(NextAndPrevious delta);
    /**
     * javadock.
     * @param speed param
     * @param damage param
     * @param life param
     * @param resource param
     */
    void viewUpdateP1(int speed, int damage, int life, String resource);
    /**
     * javadock.
     * @param speed param
     * @param damage param
     * @param life param
     * @param resource param
     */
    void viewUpdateP2(int speed, int damage, int life, String resource);
    /**
     * javadock.
     * @param resource param
     */
    void viewUpdateMap(String resource);
    /**
     * javadock.
     * @param tank1 param
     * @param tank2 param
     * @param mapResource param
     */
    void setResource(String tank1, String tank2, String mapResource);
    /**
     * javadock.
     * @param stage param
     */
    void start(Stage stage);
    /**
     * javadock.
     */
    void restart();
    /**
     * javadock.
     */
    void newStart();
    /**
     * javadock.
     */
    void setViewResources();
    /**
     * javadock.
     */
    void startGame();
    /**
     * javadock.
     * @param e param
     */
    void addCommand(KeyEvent e);
    /**
     * javadock.
     * @param gameController param
     */
    void setGameController(GameController gameController);
    /**
     * javadock.
     * @param gameScene param
     */
    void setGameScene(Scene gameScene);
    /**
     * javadock.
     * @param code param
     */
    void setWinner(String code);
    /**
     * javadock.
     * @param settingsController param
     */
    void setSettingsController(SettingsController settingsController);
}
