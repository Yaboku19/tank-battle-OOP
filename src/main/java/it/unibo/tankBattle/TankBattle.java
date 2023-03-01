package it.unibo.tankBattle;

import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.controller.impl.BasicGameEngine;

/**
 * 
 */
public class TankBattle {
    public static void main (String[] args) {
        GameEngine application = new BasicGameEngine();
        application.play();
    }
}
