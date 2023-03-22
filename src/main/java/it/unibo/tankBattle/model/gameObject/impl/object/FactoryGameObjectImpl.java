package it.unibo.tankBattle.model.gameObject.impl.object;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.common.input.api.Direction;
import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.model.gameObject.api.object.*;
import it.unibo.tankBattle.model.gameObject.impl.component.*;

public class FactoryGameObjectImpl implements FactoryGameObject {

    private final double SIMPLE_TANK_DIMENSION = 50;
    private final double SIMPLE_TANK_SPEED = 0.1;
    private final int SIMPLE_TANK_LIFEPOINTS = 100;
    private final double SIMPLE_BULLET_DIMENSION = 10;
    private final int SIMPLE_BULLET_DAMAGE = 50;
    private final double SIMPLE_BULLET_SPEED = 0.5;
    private final double SIMPLE_WALL_DIMENSION = 40;

    @Override
    public GameObject createSimpleTank(final P2d pos, final Player player) {
        return new BasicGameObject(new Transform(pos, Direction.UP, SIMPLE_TANK_DIMENSION, SIMPLE_TANK_DIMENSION))
                .addComponent(new SimpleTank(player))
                .addComponent(new CollisionComponent())
                .addComponent(new DamageableImpl(SIMPLE_TANK_LIFEPOINTS))
                .addComponent(new HealthImpl())
                .addComponent(new KnockBack())
                .addComponent(new SimpleMovable(SIMPLE_TANK_SPEED));
    }

    @Override
    public GameObject createSimpleBullet(final GameObject tank) {
        final Transform bulletTransform = new Transform(new P2d( tank.getTransform().getPosition().getX() 
            + tank.getTransform().getDirection().getX()*(tank.getTransform().getLength()/2 + SIMPLE_BULLET_DIMENSION), 
            tank.getTransform().getPosition().getY() 
            + tank.getTransform().getDirection().getY()*(tank.getTransform().getWidth()/2 + SIMPLE_BULLET_DIMENSION)),
            tank.getTransform().getDirection(), SIMPLE_BULLET_DIMENSION, SIMPLE_BULLET_DIMENSION);

        return new BasicGameObject(bulletTransform)
                .addComponent(new Bullet())
                .addComponent(new CollisionComponent())
                .addComponent(new DealDamageOnCollision(SIMPLE_BULLET_DAMAGE))
                .addComponent(new SimpleMovable(SIMPLE_BULLET_SPEED, bulletTransform.getDirection()))
                .addComponent(new HealthImpl())
                .addComponent(new DestroyOnCollision());
    }

    @Override
    public GameObject createSimpleWall(final P2d pos) {
        return new BasicGameObject(new Transform(pos, Direction.NONE, SIMPLE_WALL_DIMENSION, SIMPLE_WALL_DIMENSION))
                .addComponent(new Wall())
                .addComponent(new CollisionComponent());
    }

    @Override
    public double getWallLength() {
        return SIMPLE_WALL_DIMENSION;
    }
}
