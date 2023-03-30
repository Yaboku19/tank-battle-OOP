package it.unibo.tankbattle.model.gameobject.impl.component;

import it.unibo.tankbattle.common.P2d;
import it.unibo.tankbattle.common.input.api.Direction;
import it.unibo.tankbattle.model.gameobject.api.component.AbstractComponent;
import it.unibo.tankbattle.model.gameobject.api.component.Movable;

/**
 * Represents an implementation of the {@link Movable} {@link Component}.
 */
public class SimpleMovable extends AbstractComponent implements Movable {

    private final double speed;
    private Direction movingDirection;

    /**
     * Initializes a {@link SimpleMovable} given its speed and with a {@value Direction#NONE} direction.
     * @param speed the speed of the object
     */
    public SimpleMovable(final double speed) {
        this.speed = speed;
        this.movingDirection = Direction.NONE;
    }

    /**
     * Initializes a {@link SimpleMovable} given its speed and direction.
     * @param speed the speed of the object
     * @param direction the direction of the object
     */
    public SimpleMovable(final double speed, final Direction direction) {
        this.speed = speed;
        this.movingDirection = direction;
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
