package it.unibo.tankBattle.view.api;

import javax.swing.JFrame;

import it.unibo.tankBattle.common.P2d;

public abstract class Graphics extends JFrame{
    
    abstract public void drawTank(P2d position);

    abstract public void drawBullet(P2d position);

    abstract public void drawMap();
}
