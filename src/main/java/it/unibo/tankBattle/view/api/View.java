package it.unibo.tankBattle.view.api;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.InputController;
import it.unibo.tankBattle.controller.api.GameEngine;

public interface View {
    
    public void drawTank(P2d position);

    public void drawBullet(P2d position);

    public void drawMap();

    public void setController(GameEngine controller);  
}
