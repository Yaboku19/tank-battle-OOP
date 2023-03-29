package it.unibo.tankbattle.common.input.api;

import it.unibo.tankbattle.common.P2d;

/**
 * Directions that can be used by the player.
 */
public enum Direction {
    /**
     * javadoc.
     */
    UP(0, -1),
    /**
     * javadoc.
     */ 
    RIGHT(1, 0),
    /**
     * javadoc.
     */
    DOWN(0, 1),
    /**
     * javadoc.
     */
    LEFT(-1, 0),
    /**
     * javadoc.
     */
    NONE(0, 0);

    private double x;
    private double y;
    /**
     * javadoc.
     * @return return
     */
    public double getX() {
        return x;
    }
    /**
     * javadoc.
     * @return return
     */
    public double getY() {
        return y;
    }
    /**
     * javadoc.
     * @return return
     */
    public P2d getVector() {
        return new P2d(this.x, this.y);
    }
    /**
     * javadoc.
     * @param x param
     * @param y param
     */
    Direction(final double x, final double y) {
        this.x = x;
        this.y = y; 
    }
}
