package it.unibo.tankBattle.view.api;

import javax.swing.JFrame;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.InputController;

public abstract class View extends JFrame{
    
    abstract public void drawTank(P2d position);

    abstract public void drawBullet(P2d position);

    abstract public void drawMap();

    abstract public void tutorial();

    abstract public void menu();

    abstract public void chooseMenu();

    abstract public void bugSolve();

    abstract public void startGame();

    abstract public InputController getInputControllerPlayer1();

    abstract public InputController getInputControllerPlayer2();
    
}
