package it.unibo.tankBattle.common;

public class Player {
    private int code;
    private int score;

    public Player (final int code, final int score){
        this.code = code;
        this.score = score;
    }

    public int getCode() {
        return code;
    }

    public int getScore() {
        return score;
    }

    public void incScore(){
        this.score ++;
    }

    
}
