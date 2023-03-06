package it.unibo.tankBattle.model.gameState.impl;

public class Player {
    private int score;

    protected Player() {
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void incScore() {
        score++;
    }
}
