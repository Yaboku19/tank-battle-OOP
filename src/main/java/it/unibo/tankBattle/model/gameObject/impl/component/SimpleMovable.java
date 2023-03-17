package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.model.gameObject.api.component.Movable;

public class SimpleMovable extends AbstractComponent implements Movable {

    private final double speed;
    private Directions movingDirection;
    

    public SimpleMovable(final double speed) {
        this.speed = speed;
        this.movingDirection = Directions.UP;
    }

    @Override
    public void update(double time) {
        var actualPos = this.getGameObject().getTransform().getPosition(); 
        this.getGameObject()
                .setPosition(new P2d(time*speed*movingDirection.getX() + actualPos.getX(), 
                time*speed*movingDirection.getY() + actualPos.getY()));
    }

    @Override
    public double getSpeed() {
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
