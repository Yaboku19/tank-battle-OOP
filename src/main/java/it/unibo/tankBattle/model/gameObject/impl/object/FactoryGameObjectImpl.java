package it.unibo.tankBattle.model.gameObject.impl.object;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.model.gameObject.api.object.FactoryGameObject;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;
import it.unibo.tankBattle.model.gameObject.impl.component.Bullet;
import it.unibo.tankBattle.model.gameObject.impl.component.Tank;
import it.unibo.tankBattle.model.gameObject.impl.component.TankHealth;
import it.unibo.tankBattle.model.gameObject.impl.component.Wall;

public class FactoryGameObjectImpl implements FactoryGameObject{

    @Override
    public GameObject createSimpleTank(P2d pos) {
        return new BasicGameObject(new Transform(pos, null, 0, 0))
                .addComponent(new Tank())
                .addComponent(new TankHealth(100));
    }

    @Override
    public GameObject createSimpleBullet(GameObject tank) {
        return new BasicGameObject(new Transform(new P2d( tank.getTransform().getPosition().getX() 
                        + tank.getTransform().getDirection().getX()*tank.getTransform().getLength(), 
                        tank.getTransform().getPosition().getY() 
                        + tank.getTransform().getDirection().getY()*tank.getTransform().getWidth()),
                        tank.getTransform().getDirection(), 1, 1))
                .addComponent(new Bullet());
    }

    @Override
    public GameObject createSimpleWall(P2d pos) {
        return new BasicGameObject(new Transform(pos, Directions.NONE, 10, 10))
                .addComponent(new Wall());
    }


    
}
