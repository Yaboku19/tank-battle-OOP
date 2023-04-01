package it.unibo.tankbattle.view.api;

import java.util.stream.Stream;

import it.unibo.tankbattle.common.NextAndPrevious;
import it.unibo.tankbattle.common.Transform;
import it.unibo.tankbattle.view.impl.javafx.controller.GameController;
import it.unibo.tankbattle.view.impl.javafx.controller.SettingsController;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * This interface represents a javafx main controller.
 */
public interface View {

    /**
     * Use that method to start the application.
     * @param stage is the first stage.
     */
    void start(Stage stage);

    /**
     * Use that method to start the game.
     */
    void startGame();

    /**
     * Use that method to render game elements.
     * @param firstTank first tank Transform
     * @param secondTank second tank Transform
     * @param wall walls' Transform set
     * @param bullet bullets' Transform set
     * @param lifeFirstTank first player tank's life
     * @param lifeSecondTank second player tank's life
     * @param firstPlayerScore first player score
     * @param secondPlayerScore second player score
     */
    void render(Transform firstTank, Transform secondTank, Stream<Transform> wall, 
            Stream<Transform> bullet,  int lifeFirstTank, int lifeSecondTank,
            int firstPlayerScore, int secondPlayerScore);

    /**
     * Use that method to manage game over.
     */
    void gameOver();

    /**
     * Use that method to ask to controller next Tank for player 1.
     * @param delta next
     */
    void updateTankPlayer1(NextAndPrevious delta);

    /**
     * Use that method to ask to controller next Tank for player 2.
     * @param delta next
     */
    void updateTankPlayer2(NextAndPrevious delta);

    /**
     * Use that method to ask to controller new map.
     * @param delta next or previous
     */
    void updateMap(NextAndPrevious delta);

    /**
     * Use that method to update view settings for player 1.
     * @param speed tank speed
     * @param damage tank damage
     * @param life tank life
     * @param resource tank resource
     */
    void viewUpdateP1(int speed, int damage, int life, String resource);

    /**
     * Use that method to update view settings for player 2.
     * @param speed tank speed
     * @param damage tank damage
     * @param life tank life
     * @param resource tank resource
     */
    void viewUpdateP2(int speed, int damage, int life, String resource);

    /**
     * Use that method to update map image.
     * @param resource path of map resource
     */
    void viewUpdateMap(String resource);

    /**
     * Sets the game objects resources.
     * @param tank1 first tank resource
     * @param tank2 second tank resource
     * @param mapResource map resource
     */
    void setResource(String tank1, String tank2, String mapResource);

    /**
     * Use that method to restart the game.
     */
    void restart();

    /**
     * Use that method to do a new start og the game.
     */
    void newStart();

    /**
     * Use that method to tell the controller to set view resources. 
     */
    void setViewResources();

    /**
     * Use that method to manage new user command.
     * @param e event made by user.
     */
    void addCommand(KeyEvent e);

    /**
     * Use that method to set the game view controller.
     * @param gameController game view controller.
     */
    void setGameController(GameController gameController);

    /**
     * Use that method to set game scene.
     * @param gameScene game scene.
     */
    void setGameScene(Scene gameScene);

    /**
     * Use that method to set the winner.
     * @param name name of the winner.
     */
    void setWinner(String name);

    /**
     * Use that method to set settings view controller.
     * @param settingsController settings view controller.
     */
    void setSettingsController(SettingsController settingsController);

    /**
     * Use that method to set players names.
     * @param firstPlayerName first player name.
     * @param secondPlayerName second player name.
     */
    void setPlayerName(String firstPlayerName, String secondPlayerName);

    /**
     * Use this method to get the first player name.
     * @return first player name
     */
    String getFirstPlayerName();

    /**
     * Use this method to get the second player name.
     * @return second player's name
     */
    String getSecondPlayerName();
}
