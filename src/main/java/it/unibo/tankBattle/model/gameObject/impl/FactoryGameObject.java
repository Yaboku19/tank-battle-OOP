package it.unibo.tankBattle.model.gameObject.impl;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.model.gameObject.api.GameObject;

public class FactoryGameObject {
    
    private static final int DAMAGE_MULTIPLIER = 10;
    private static final int BULLET_LIFEPOINTS = 1;

    public GameObject simpleTank(int speed, P2d startPos, int lifePoints, int damage) {
        return new GameObjectImpl(speed , startPos, lifePoints, damage) {

            @Override
            public boolean isAlive() {
                return this.getLifePoints() > 0;
            }

            @Override
            public void update() {
                this.updatePosition();
            }

            @Override
            public void resolveCollision() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'resolveCollision'");
            }
            
        };
    }

    public GameObject simpleBullet(int speed, GameObject tank) {
        return new GameObjectImpl(speed, tank.getPosition(), BULLET_LIFEPOINTS, tank.getDamage()*DAMAGE_MULTIPLIER) {

            @Override
            public boolean isAlive() {
                return this.getLifePoints() > 0;
            }

            @Override
            public void update() {
                this.updatePosition();
            }

            @Override
            public void resolveCollision() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'resolveCollision'");
            }
            
        };
    }

    public GameObject simpleWall(P2d startPos) {
        return new GameObjectImpl(0, startPos, 1, 0) {

            @Override
            public boolean isAlive() {
                return true;
            }

            @Override
            public void update() {
                
            }

            @Override
            public void resolveCollision() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'resolveCollision'");
            }
            
        };
    }

}
