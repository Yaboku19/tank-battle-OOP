package it.unibo.tankBattle.model.gameObject.impl;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.model.gameObject.api.GameObject;

public class FactoryGameObject {
    
    private static final int DAMAGE_MULTIPLIER = 10;
    private static final int BULLET_LIFEPOINTS = 1;
    private static final int TANK_LENGTH = 10;
    private static final int BULLET_LENGTH = 1;
    private static final int WALL_LENGTH = 10;
    

    public GameObject simpleTank(final int speed,final  P2d startPos,final  int lifePoints,final  int damage) {
        return new GameObjectImpl(speed , startPos, lifePoints, damage, TANK_LENGTH) {

            @Override
            public boolean isAlive() {
                return this.getLifePoints() > 0;
            }

            @Override
            public void update() {
                this.updatePosition();
            }

            @Override
            public void resolveCollision(GameObject obj) {
                this.knockBack(this.manageCollision(obj.getPosition()));
            }
            
        };
    }

    public GameObject simpleBullet(int speed, GameObject tank) {
        return new GameObjectImpl(speed, tank.getPosition(), BULLET_LIFEPOINTS, tank.getDamage()*DAMAGE_MULTIPLIER, BULLET_LENGTH) {

            @Override
            public boolean isAlive() {
                return this.getLifePoints() > 0;
            }

            @Override
            public void update() {
                this.updatePosition();
            }

            @Override
            public void resolveCollision(GameObject obj) {
                
            }
            
        };
    }

    public GameObject simpleWall(P2d startPos) {
        return new GameObjectImpl(0, startPos, 1, 0, WALL_LENGTH) {

            @Override
            public boolean isAlive() {
                return true;
            }

            @Override
            public void update() {
                
            }

            @Override
            public void resolveCollision(GameObject obj) {
                
            }
            
        };
    }

}
