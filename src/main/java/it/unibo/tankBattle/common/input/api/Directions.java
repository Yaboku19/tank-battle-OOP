package it.unibo.tankBattle.common.input.api;

/**
 * Directions that can be used by the player
 */
public enum Directions {
    UP(0, -1), 
    RIGHT(1, 0), 
    DOWN(0, 1), 
    LEFT(-1, 0),
    NONE(0, 0);

    double x;
    double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    Directions(double x, double y) {
        this.x = x;
        this.y = y;
        
    }
}
