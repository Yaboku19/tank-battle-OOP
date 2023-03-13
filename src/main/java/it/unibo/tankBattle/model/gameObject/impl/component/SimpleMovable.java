package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.model.gameObject.api.component.Movable;

public class SimpleMovable extends AbstractComponent implements Movable {

    private final int speed;
    private Directions movingDirection;
    

    public SimpleMovable(final int speed) {
        this.speed = speed;
        this.movingDirection = Directions.UP;
    }

    @Override
    public void update(double time) {
        //toDo
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public Directions getMovingDirection() {
        return this.movingDirection;
    }

    @Override
    public void setMovingDirection(final Directions dir) {
        this.movingDirection = dir;
    }
    
}
