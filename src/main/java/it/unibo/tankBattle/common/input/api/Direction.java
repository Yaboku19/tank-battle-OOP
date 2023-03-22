package it.unibo.tankBattle.common.input.api;

import it.unibo.tankBattle.common.P2d;

/**
 * Directions that can be used by the player
 */
public enum Direction {
    UP(0, -1), 
    RIGHT(1, 0), 
    DOWN(0, 1), 
    LEFT(-1, 0),
    NONE(0, 0);

    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public P2d getVector() {
        return new P2d(this.x, this.y);
    }

    Direction(double x, double y) {
        this.x = x;
        this.y = y;
        
    }
}
