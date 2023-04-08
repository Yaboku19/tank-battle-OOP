package it.unibo.tankbattle.common.input.api;

import it.unibo.tankbattle.common.Point2d;

/**
 * Directions that can be used.
 */
public enum Direction {
    /**
     * Up direction.
     */
    UP(0, -1),
    /**
     * Right direction.
     */ 
    RIGHT(1, 0),
    /**
     * Down direction.
     */
    DOWN(0, 1),
    /**
     * Left direction.
     */
    LEFT(-1, 0),
    /**
     * Stop direction.
     */
    NONE(0, 0);

    private double x;
    private double y;
    /**
     * @return return x value.
     */
    public double getX() {
        return x;
    }
    /**
     * @return return y value.
     */
    public double getY() {
        return y;
    }
    /**
     * @return return vector create by x and y.
     */
    public Point2d getVector() {
        return new Point2d(this.x, this.y);
    }
    /**
     * @param x x value.
     * @param y y value.
     */
    Direction(final double x, final double y) {
        this.x = x;
        this.y = y; 
    }
}
