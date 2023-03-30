package it.unibo.tankbattle.model.gameobject.api.component;

import it.unibo.tankbattle.common.input.api.Direction;

/**
 * Represents a particular {@link Component} that enables the attached {@link GameObject} to move.
 */
public interface Movable extends Component {

    /**
     * Gets the current speed of the object.
     * @return the current speed
     */
    double getSpeed();

    /**
     * Gets the direction where the object is moving.
     * @return the direction, or {@value Direction#NONE} if it is not moving
     */
    Direction getMovingDirection();

    /**
     * Sets the direction where the object is moving.
     * @param direction the direction
     */
    void setMovingDirection(Direction direction);
}
