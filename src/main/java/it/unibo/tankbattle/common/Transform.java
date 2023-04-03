package it.unibo.tankbattle.common;

import it.unibo.tankbattle.common.input.api.Direction;
/**
 * This class represent the values that every {@link it.unibo.tankbattle.model.gameobject.api.object.GameObject} has.
 */
public class Transform {

    private final P2d position;
    private final Direction direction;
    private final double length;
    private final double width;

    /**
     * Create a new Transform with the given values.
     * @param position start position
     * @param direction start {@link Direction}
     * @param length the object length
     * @param width the object width
     */
    public Transform(final P2d position, final Direction direction, final double length, final double width) {
        this.position = position;
        this.direction = direction;
        this.length = length;
        this.width = width;
    }
    /**
     * Gets the center position.
     * @return the actual P2d
     */
    public P2d getPosition() {
        return this.position;
    }
    /**
     * Gets the actual {@link Direction}.
     * @return the actual {@link Direction}
     */
    public Direction getDirection() {
        return this.direction;
    }
    /**
     * Gets the object length.
     * @return the object length
     */
    public double getLength() {
        return this.length;
    }
    /**
     * Gets the object width.
     * @return the object width
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * Gets the upper-left position of the object.
     * @return the upper-left position of the object
     */
    public P2d getUpperLeftPosition() {
        return new P2d(this.position.getX() - length / 2, this.position.getY() - width / 2);
    }
}
