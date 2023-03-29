package it.unibo.tankbattle.common;

import it.unibo.tankbattle.common.input.api.Direction;
/**
 * javadoc.
 */
public class Transform {

    private P2d position;
    private Direction direction;
    private double length;
    private double width;

    /**
     * javadoc.
     * @param position param
     * @param direction param
     * @param length param
     * @param width param
     */
    public Transform(final P2d position, final Direction direction, final double length, final double width) {
        this.position = position;
        this.direction = direction;
        this.length = length;
        this.width = width;
    }
    /**
     * javadoc.
     * @return return
     */
    public P2d getPosition() {
        return this.position;
    }
    /**
     * javadoc.
     * @return return
     */
    public Direction getDirection() {
        return this.direction;
    }
    /**
     * javadoc.
     * @return return
     */
    public double getLength() {
        return this.length;
    }
    /**
     * javadoc.
     * @return return
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * javadoc.
     * @return return
     */
    public P2d getUpperLeftPosition() {
        return new P2d(this.position.getX() - length / 2, this.position.getY() - width / 2);
    }
}
