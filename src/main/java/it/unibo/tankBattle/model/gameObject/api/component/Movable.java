package it.unibo.tankBattle.model.gameObject.api.component;

import it.unibo.tankBattle.common.input.api.Directions;

public interface Movable extends Component {

    /**
     * 
     * @return the component speed
     */
    public int getSpeed();

    /**
     * 
     * @return the direction where the object has to move, {@value}Directions.NONE if is not moving
     */
    public Directions getMovingDirection();

    /**
     * 
     * @param dir the next direction
     */
    public void setMovingDirection(Directions dir);
}
