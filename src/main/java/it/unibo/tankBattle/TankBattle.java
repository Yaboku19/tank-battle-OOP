package it.unibo.tankBattle;

import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.controller.impl.BasicGameEngine;
import it.unibo.tankBattle.view.api.View;
import javafx.application.Application;

/**
 * 
 */
public class TankBattle {
    public static void main (String[] args) {
        /*GameEngine application = new BasicGameEngine();
        application.play();*/
        Application.launch(View.class, args);
    }
}
