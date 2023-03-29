package it.unibo.tankBattle.view.api;

import java.util.stream.Stream;

import it.unibo.tankBattle.common.NextAndPrevious;
import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.view.impl.javafx.controller.GameController;
import it.unibo.tankBattle.view.impl.javafx.controller.SettingsController;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public interface View {

    public void gameOver();

    public void render(Transform firstTank, Transform secondTank, Stream<Transform> wall, Stream<Transform> bullet,  int lifeFirstTank, int lifeSecondTank);

    public void setController(GameEngine controller);  

    public void updateTankPlayer1(NextAndPrevious delta);

    public void updateTankPlayer2(NextAndPrevious delta);

    public void updateMap(NextAndPrevious delta);

    public void viewUpdateP1(int speed, int damage, int life, String resource);

    public void viewUpdateP2(int speed, int damage, int life, String resource);

    public void viewUpdateMap(String resource);

    public void setResource(String tank1, String tank2, String mapResource);

    public void start(Stage stage);

    public void restart();

    public void newStart();

    public void setViewResources();

    public void startGame();

    public void addCommand(KeyEvent e);

    public void setGameController(GameController gameController);

    public void setGameScene(Scene gameScene);

    public void setWinner(String code);

    public void setSettingsController(SettingsController settingsController);

    public void setPlayerName(String firstPlayerName, String secondPlayerName);

    public String getFirstPlayerName();

    public String getSecondPlayerName();
}
