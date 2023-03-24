package it.unibo.tankBattle.controller.impl;

import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.model.gameSetup.impl.TankData;


public class HumanPlayer implements Player {
    
    private int score;
    private final int code;
    private final TankData tankData;

    HumanPlayer(int code, TankData tankData) {
        this.score = 0;
        this.code = code;
        this.tankData = tankData;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void incScore() {
        score++;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public TankData getTankData() {
       return tankData;
    }

}
