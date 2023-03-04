package it.unibo.tankBattle.common.input.api;

/**
 * Directions that can be used by the player
 */
public enum Directions {
    UP(-1, 0), 
    RIGHT(0, 1), 
    DOWN(1, 0), 
    LEFT(0, -1);

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
