package it.unibo.tankBattle.controller.impl;

import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.model.gameSetup.impl.TankData;


public class HumanPlayer implements Player {
    
    private int score;
    private final String name;
    private final TankData tankData;

    HumanPlayer(String name, TankData tankData) {
        this.score = 0;
        this.name = name;
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
    public String getCode() {
        return name;
    }

    @Override
    public TankData getTankData() {
       return tankData;
    }

}
