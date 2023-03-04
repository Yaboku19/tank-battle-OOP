package it.unibo.tankBattle.model.impl;

import it.unibo.tankBattle.common.P2d;

public class FactoryGameObject {
    
    private static final int DAMAGE_MULTIPLIER = 10;

    public GameObjectImpl simpleTank(int speed, P2d startPos, int lifePoints, int damage) {
        return new GameObjectImpl(speed , startPos, lifePoints, damage) {

            @Override
            public boolean isAlive(GameObjectImpl obj) {
                return this.getLifePoints() > 0;
            }

            @Override
            public void update() {
                this.setPosition();
            }
            
        };
    }

    public GameObjectImpl simpleBullet(int speed, P2d startPos, GameObjectImpl tank) {
        return new GameObjectImpl(speed, startPos, 1, tank.getDamage()*DAMAGE_MULTIPLIER) {

            @Override
            public boolean isAlive(GameObjectImpl obj) {
                return this.getLifePoints() > 0;
            }

            @Override
            public void update() {
                this.setPosition();
            }
            
        };
    }

    public GameObjectImpl simpleWall(P2d startPos) {
        return new GameObjectImpl(0, startPos, 1, 0) {

            @Override
            public boolean isAlive(GameObjectImpl obj) {
                return true;
            }

            @Override
            public void update() {
                
            }
            
        };
    }

}
