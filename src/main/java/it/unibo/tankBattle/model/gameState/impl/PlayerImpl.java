package it.unibo.tankBattle.model.gameState.impl;

import it.unibo.tankBattle.model.gameState.api.Player;

public class PlayerImpl implements Player {
    private int score;

    protected PlayerImpl() {
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void incScore() {
        score++;
    }
}
