package it.unibo.tankBattle.model.gameObject.impl;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.model.gameObject.api.GameObject;

public class FactoryGameObject {
    
    private static final int DAMAGE_MULTIPLIER = 10;
    private static final int BULLET_LIFEPOINTS = 1;
    private static final int TANK_LENGTH = 10;
    private static final int BULLET_LENGTH = 1;
    private static final int WALL_LENGTH = 10;
    

    public GameObject simpleTank(final int speed,final  P2d startPos,final  int lifePoints,final  int damage) {
        return new GameObjectImpl(speed , startPos, lifePoints, damage, TANK_LENGTH, Directions.NONE) {

            @Override
            public boolean isAlive() {
                return this.getLifePoints() > 0;
            }

            @Override
            public void resolveCollision(GameObject obj) {
                this.knockBack(this.manageCollision(obj.getPosition()));
                this.hit(obj.getDamage());
            }
            
        };
    }

    public GameObject simpleBullet(int speed, GameObject tank) {
        return new GameObjectImpl(speed, 
            tank.getPosition().sum(new P2d(tank.getDirection().getX()*tank.getLength(), tank.getDirection().getY()*tank.getLength())), 
            BULLET_LIFEPOINTS, 
            tank.getDamage()*DAMAGE_MULTIPLIER, BULLET_LENGTH, 
            tank.getDirection()) {

                @Override
                public boolean isAlive() {
                    return this.getLifePoints() > 0;
                }

                @Override
                public void resolveCollision(GameObject obj) {
                    this.hit(BULLET_LIFEPOINTS);
                }
            
        };
    }

    public GameObject simpleWall(P2d startPos) {
        return new GameObjectImpl(0, startPos, 1, 0, WALL_LENGTH, Directions.NONE) {

            @Override
            public boolean isAlive() {
                return true;
            }

            @Override
            public void resolveCollision(GameObject obj) {
                
            }
            
        };
    }

}
