package it.unibo.tankBattle.model.gameObject.impl.object;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.model.gameObject.api.object.*;
import it.unibo.tankBattle.model.gameObject.impl.component.*;

public class FactoryGameObjectImpl implements FactoryGameObject {

    private final double SIMPLE_TANK_DIM = 50;
    private final double SIMPLE_TANK_SPEED = 0.1;
    private final int SIMPLE_TANK_LP = 100;
    private final double SIMPLE_BULLET_DIM = 10;
    private final int SIMPLE_BULLET_DAMAGE = 50;
    private final double SIMPLE_BULLET_SPEED = 0.5;
    private final double SIMPLE_WALL_DIM = 40;

    @Override
    public GameObject createSimpleTank(final P2d pos, final Player player) {
        return new BasicGameObject(new Transform(pos, Directions.UP, SIMPLE_TANK_DIM, SIMPLE_TANK_DIM))
                .addComponent(new SimpleTank(player))
                .addComponent(new TankHealth(SIMPLE_TANK_LP))
                .addComponent(new ActiveCollidableTank())
                .addComponent(new SimpleMovable(SIMPLE_TANK_SPEED))
                .addComponent(new CollisionComponent());
    }

    @Override
    public GameObject createSimpleBullet(final GameObject tank) {
        final Transform bulletTransform = new Transform(new P2d( tank.getTransform().getPosition().getX() 
            + tank.getTransform().getDirection().getX()*(tank.getTransform().getLength()/2 + SIMPLE_BULLET_DIM), 
            tank.getTransform().getPosition().getY() 
            + tank.getTransform().getDirection().getY()*(tank.getTransform().getWidth()/2 + SIMPLE_BULLET_DIM)),
            tank.getTransform().getDirection(), SIMPLE_BULLET_DIM, SIMPLE_BULLET_DIM);

        return new BasicGameObject(bulletTransform)
                .addComponent(new Bullet())
                .addComponent(new SimpleDamageDealer(SIMPLE_BULLET_DAMAGE))
                .addComponent(new SimpleMovable(SIMPLE_BULLET_SPEED, bulletTransform.getDirection()))
                .addComponent(new BulletHealth())
                .addComponent(new ActiveCollidableBullet())
                .addComponent(new CollisionComponent());
    }

    @Override
    public GameObject createSimpleWall(final P2d pos) {
        return new BasicGameObject(new Transform(pos, Directions.NONE, SIMPLE_WALL_DIM, SIMPLE_WALL_DIM))
                .addComponent(new Wall())
                .addComponent(new CollisionComponent());
    }

    @Override
    public double getWallLength() {
        return SIMPLE_WALL_DIM;
    }


    
}
