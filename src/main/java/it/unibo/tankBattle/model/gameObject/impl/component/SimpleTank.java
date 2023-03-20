package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.model.gameObject.api.component.Tank;

public class SimpleTank extends Tank {

    private final static double SHOT_COUNTDOWN = 1000;

    public SimpleTank(Player player) {
        super(player, SHOT_COUNTDOWN);
    }


}
