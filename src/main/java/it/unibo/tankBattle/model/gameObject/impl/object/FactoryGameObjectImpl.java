package it.unibo.tankBattle.model.gameObject.impl.object;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.common.input.api.Direction;
import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.model.gameObject.api.component.Tank;
import it.unibo.tankBattle.model.gameObject.api.object.FactoryGameObject;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;
import it.unibo.tankBattle.model.gameObject.impl.component.Bullet;
import it.unibo.tankBattle.model.gameObject.impl.component.CollisionComponent;
import it.unibo.tankBattle.model.gameObject.impl.component.DamageableImpl;
import it.unibo.tankBattle.model.gameObject.impl.component.DealDamageOnCollision;
import it.unibo.tankBattle.model.gameObject.impl.component.DestroyOnCollision;
import it.unibo.tankBattle.model.gameObject.impl.component.HealthImpl;
import it.unibo.tankBattle.model.gameObject.impl.component.KnockBack;
import it.unibo.tankBattle.model.gameObject.impl.component.SimpleMovable;
import it.unibo.tankBattle.model.gameObject.impl.component.Wall;
/**
 * javadoc.
 */
public class FactoryGameObjectImpl implements FactoryGameObject {

    private static final double SIMPLE_TANK_DIMENSION = 50;
    private static final double SIMPLE_BULLET_DIMENSION = 10;
    private static final double SIMPLE_WALL_DIMENSION = 40;
    private static final double BULLET_SPEED_MULTIPLIER = 2;
    /**
    * {@inheritDoc}
    */
    @Override
    public GameObject createSimpleTank(final P2d pos, final Player player) {
        final Tank tank = new Tank(player);
        return new BasicGameObject(new Transform(pos, Direction.UP, SIMPLE_TANK_DIMENSION, SIMPLE_TANK_DIMENSION))
                .addComponent(tank)
                .addComponent(new CollisionComponent())
                .addComponent(new DamageableImpl(player.getTankData().getLife()))
                .addComponent(new HealthImpl())
                .addComponent(new SimpleMovable(tank.getSpeed()))
                .addComponent(new KnockBack());
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public GameObject createSimpleBullet(final GameObject tank) {
        final Transform bulletTransform = new Transform(new P2d(tank.getTransform().getPosition().getX() 
            + tank.getTransform().getDirection().getX() * (tank.getTransform().getLength() / 2 + SIMPLE_BULLET_DIMENSION), 
            tank.getTransform().getPosition().getY() 
            + tank.getTransform().getDirection().getY() * (tank.getTransform().getWidth() / 2 + SIMPLE_BULLET_DIMENSION)),
            tank.getTransform().getDirection(), SIMPLE_BULLET_DIMENSION, SIMPLE_BULLET_DIMENSION);

        return new BasicGameObject(bulletTransform)
                .addComponent(new Bullet())
                .addComponent(new CollisionComponent())
                .addComponent(new DealDamageOnCollision(this.getTankDamage(tank)))
                .addComponent(new SimpleMovable(getBulletSpeed(tank), bulletTransform.getDirection()))
                .addComponent(new HealthImpl())
                .addComponent(new DestroyOnCollision());
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public GameObject createSimpleWall(final P2d pos) {
        return new BasicGameObject(new Transform(pos, Direction.NONE, SIMPLE_WALL_DIMENSION, SIMPLE_WALL_DIMENSION))
                .addComponent(new Wall())
                .addComponent(new CollisionComponent());
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public double getWallLength() {
        return SIMPLE_WALL_DIMENSION;
    }

    private int getTankDamage(final GameObject tank) {
        return tank.getComponent(Tank.class).isPresent() 
                ? tank.getComponent(Tank.class).get().getDamage() 
                : 0;
    }

    private double getBulletSpeed(final GameObject tank) {
        return tank.getComponent(Tank.class).isPresent() 
                ? tank.getComponent(Tank.class).get().getSpeed() * BULLET_SPEED_MULTIPLIER
                : 0;
    }
}
