package it.unibo.tankBattle.model.gameState.impl;

import it.unibo.tankBattle.model.gameState.api.Player;

public class PlayerImpl implements Player {
    private int score;

    PlayerImpl() {
        this.score = 0;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void incScore() {
        score++;
    }
    
}
