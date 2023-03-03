package it.unibo.tankBattle.model.impl;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.model.api.GameObject;

public class FactoryGameObject {
    
    private static final int DAMAGE_MULTIPLIER = 10;

    public GameObject simpleTank(int speed, P2d startPos, int lifePoints, int damage) {
        return new GameObject(speed , startPos, lifePoints, damage) {

            @Override
            public boolean isAlive(GameObject obj) {
                return this.getLifePoints() > 0;
            }

            @Override
            public void update() {
                this.setPosition();
            }
            
        };
    }

    public GameObject simpleBullet(int speed, P2d startPos, GameObject tank) {
        return new GameObject(speed, startPos, 1, tank.getDamage()*DAMAGE_MULTIPLIER) {

            @Override
            public boolean isAlive(GameObject obj) {
                return this.getLifePoints() > 0;
            }

            @Override
            public void update() {
                this.setPosition();
            }
            
        };
    }

    public GameObject simpleWall(P2d startPos) {
        return new GameObject(0, startPos, 1, 0) {

            @Override
            public boolean isAlive(GameObject obj) {
                return true;
            }

            @Override
            public void update() {
                
            }
            
        };
    }

}
