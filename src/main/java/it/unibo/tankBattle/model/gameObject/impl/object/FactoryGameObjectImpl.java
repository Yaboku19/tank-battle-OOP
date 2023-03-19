package it.unibo.tankBattle.model.gameObject.impl.object;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.model.collision.api.RectangularBoundingBox;
import it.unibo.tankBattle.model.gameObject.api.object.*;
import it.unibo.tankBattle.model.gameObject.impl.component.*;

public class FactoryGameObjectImpl implements FactoryGameObject {

    private final int SIMPLE_TANK_DIM = 50;
    private final int SIMPLE_TANK_SPEED = 1;
    private final int SIMPLE_BULLET_DIM = 10;
    private final int SIMPLE_BULLET_DAMAGE = 50;
    private final int SIMPLE_BULLET_SPEED = 2;
    private final int SIMPLE_WALL_DIM = 20;

    @Override
    public GameObject createSimpleTank(final P2d pos, final Player player) {
        final Transform tankTranform = new Transform(pos, Directions.UP, SIMPLE_TANK_DIM, SIMPLE_TANK_DIM);
        return new BasicGameObject(tankTranform)
                .addComponent(new SimpleTank(player))
                .addComponent(new TankHealth(100))
                .addComponent(new CollidableTank())
                .addComponent(new SimpleMovable(SIMPLE_TANK_SPEED))
                .addComponent(new BoundingBoxComp(new RectangularBoundingBox(tankTranform)));
    }

    @Override
    public GameObject createSimpleBullet(final GameObject tank) {
        final Transform bulletTransform = new Transform(new P2d( tank.getTransform().getPosition().getX() 
            + tank.getTransform().getDirection().getX()*tank.getTransform().getLength(), 
            tank.getTransform().getPosition().getY() 
            + tank.getTransform().getDirection().getY()*tank.getTransform().getWidth()),
            tank.getTransform().getDirection(), SIMPLE_BULLET_DIM, SIMPLE_BULLET_DIM);
        
        return new BasicGameObject(bulletTransform)
                .addComponent(new Bullet())
                .addComponent(new SimpleDamageDealer(SIMPLE_BULLET_DAMAGE))
                .addComponent(new SimpleMovable(SIMPLE_BULLET_SPEED, bulletTransform.getDirection()))
                .addComponent(new BulletHealth())
                .addComponent(new CollidableBullet())
                .addComponent(new BoundingBoxComp(new RectangularBoundingBox(bulletTransform)));
    }

    @Override
    public GameObject createSimpleWall(final P2d pos) {
        final Transform wallTransform = new Transform(pos, Directions.NONE, SIMPLE_WALL_DIM, SIMPLE_WALL_DIM);
        return new BasicGameObject(wallTransform)
                .addComponent(new Wall())
                .addComponent(new BoundingBoxComp(new RectangularBoundingBox(wallTransform)));
    }


    
}
