package it.unibo.tankBattle.controller.impl;

import it.unibo.tankBattle.controller.api.Player;


public class HumanPlayer implements Player {
    private int score;
    private int code;

    HumanPlayer(int code) {
        this.score = 0;
        this.code = code;
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

}
