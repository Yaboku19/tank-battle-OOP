package it.unibo.tankBattle.model.gameObject.impl.object;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.model.gameObject.api.object.FactoryGameObject;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;
import it.unibo.tankBattle.model.gameObject.impl.component.Bullet;
import it.unibo.tankBattle.model.gameObject.impl.component.CollidableTank;
import it.unibo.tankBattle.model.gameObject.impl.component.SimpleDamageDealer;
import it.unibo.tankBattle.model.gameObject.impl.component.SimpleMovable;
import it.unibo.tankBattle.model.gameObject.impl.component.Tank;
import it.unibo.tankBattle.model.gameObject.impl.component.TankHealth;
import it.unibo.tankBattle.model.gameObject.impl.component.Wall;
import it.unibo.tankBattle.model.gameState.api.Player;

public class FactoryGameObjectImpl implements FactoryGameObject {

    private final int SIMPLE_TANK_DIM = 10;
    private final int SIMPLE_TANK_SPEED = 1;
    private final int SIMPLE_BULLET_DIM = 1;
    private final int SIMPLE_BULLET_DAMAGE = 50;
    private final int SIMPLE_BULLET_SPEED = 2;
    private final int SIMPLE_WALL_DIM = 10;

    @Override
    public GameObject createSimpleTank(final P2d pos, final Player player) {
        return new BasicGameObject(new Transform(pos, Directions.UP, SIMPLE_TANK_DIM, SIMPLE_TANK_DIM))
                .addComponent(new Tank(player))
                .addComponent(new TankHealth(100))
                .addComponent(new CollidableTank())
                .addComponent(new SimpleMovable(SIMPLE_TANK_SPEED));
    }

    @Override
    public GameObject createSimpleBullet(final GameObject tank) {
        return new BasicGameObject(new Transform(new P2d( tank.getTransform().getPosition().getX() 
                        + tank.getTransform().getDirection().getX()*tank.getTransform().getLength(), 
                        tank.getTransform().getPosition().getY() 
                        + tank.getTransform().getDirection().getY()*tank.getTransform().getWidth()),
                        tank.getTransform().getDirection(), SIMPLE_BULLET_DIM, SIMPLE_BULLET_DIM))
                .addComponent(new Bullet())
                .addComponent(new SimpleDamageDealer(SIMPLE_BULLET_DAMAGE))
                .addComponent(new SimpleMovable(SIMPLE_BULLET_SPEED));
    }

    @Override
    public GameObject createSimpleWall(final P2d pos) {
        return new BasicGameObject(new Transform(pos, Directions.NONE, SIMPLE_WALL_DIM, SIMPLE_WALL_DIM))
                .addComponent(new Wall());
    }


    
}
