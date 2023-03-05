package it.unibo.tankBattle.common.input.api;

/**
 * Directions that can be used by the player
 */
public enum Directions {
    UP(0, -1), 
    RIGHT(1, 0), 
    DOWN(0, 1), 
    LEFT(-1, 0);

    int x;
    int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    Directions(int x, int y) {
        this.x = x;
        this.y = y;
        
    }
}
