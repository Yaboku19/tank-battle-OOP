package it.unibo.tankbattle.model.gameObject.api.component;

import it.unibo.tankbattle.common.input.api.Direction;
/**
 * javadoc.
 */
public interface Movable extends Component {

    /**
     * javadoc.
     * @return the component speed
     */
    double getSpeed();

    /**
     * javadoc.
     * @return the direction where the object has to move, {@value}Directions.NONE if is not moving
     */
    Direction getMovingDirection();

    /**
     * javadoc.
     * @param dir the next direction
     */
    void setMovingDirection(Direction dir);
}
