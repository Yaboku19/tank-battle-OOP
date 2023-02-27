package it.unibo.tankBattle;

import it.unibo.tankBattle.controller.api.GameLoop;

/**
 * 
 */
public class TankBattle {
    GameLoop application;
    public void main () {
        //application = new BasicGameLoop();
        application.loop();
    }
}
