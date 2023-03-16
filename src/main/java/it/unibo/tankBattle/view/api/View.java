package it.unibo.tankBattle.view.api;

import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.controller.api.GameEngine;

public interface View {
    
    public void drawTank(Transform position);

    public void drawBullet(Transform position);

    public void drawMap();

    public void setController(GameEngine controller);  
}
