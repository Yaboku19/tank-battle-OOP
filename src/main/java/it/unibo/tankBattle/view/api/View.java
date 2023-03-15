package it.unibo.tankBattle.view.api;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.InputController;
import it.unibo.tankBattle.controller.api.GameEngine;

public interface View {
    
    public void drawTank(P2d position);

    public void drawBullet(P2d position);

    public void drawMap();

    /*abstract public void tutorial();

    abstract public void menu();

    abstract public void chooseMenu();

    abstract public void bugSolve();

    public void startGame();
*/
    public InputController getInputControllerPlayer1();

    public InputController getInputControllerPlayer2();
/*
    public Dimension getSize();
  */

    public void setController(GameEngine controller);  
}
