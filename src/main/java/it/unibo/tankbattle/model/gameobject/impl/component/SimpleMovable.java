package it.unibo.tankbattle.model.gameobject.impl.component;

import it.unibo.tankbattle.common.P2d;
import it.unibo.tankbattle.common.input.api.Direction;
import it.unibo.tankbattle.model.gameobject.api.component.AbstractComponent;
import it.unibo.tankbattle.model.gameobject.api.component.Movable;
/**
 * javadoc.
 */
public class SimpleMovable extends AbstractComponent implements Movable {

    private final double speed;
    private Direction movingDirection;
    /**
     * javadoc.
     * @param speed param
     */
    public SimpleMovable(final double speed) {
        this.speed = speed;
        this.movingDirection = Direction.NONE;
    }
    /**
     * javadoc.
     * @param speed param
     * @param dir param
     */
    public SimpleMovable(final double speed, final Direction dir) {
        this.speed = speed;
        this.movingDirection = dir;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void update(final double time) {
        final var actualPos = this.getGameObject().getTransform().getPosition(); 
        this.getGameObject()
                .setPosition(new P2d(time * speed * movingDirection.getX() + actualPos.getX(), 
                time * speed * movingDirection.getY() + actualPos.getY()));
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public double getSpeed() {
        return this.speed;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public Direction getMovingDirection() {
        return this.movingDirection;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void setMovingDirection(final Direction dir) {
        this.movingDirection = dir;
    }
}
