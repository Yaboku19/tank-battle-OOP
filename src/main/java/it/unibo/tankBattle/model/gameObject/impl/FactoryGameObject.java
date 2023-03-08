package it.unibo.tankBattle.model.gameObject.impl;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.model.gameObject.api.GameObject;

public class FactoryGameObject {
    
    private static final int DAMAGE_MULTIPLIER = 10;
    private static final int WALL_LENGTH = 10;
    private static final int TANK_LENGTH = 10;
    private static final int BULLET_LENGTH = 1;

    private final static int STD_TANK_SPEED = 1;
    private final static int STD_TANK_LP = 100;
    private final static int STD_TANK_DAMAGE = 5;
    
    private static final int BULLET_LIFEPOINTS = 1;
    private static final int BULLET_MULTIPLIER_SPEED = 2;

    private static final int WALL_DAMAGE = 0;
    private static final int WALL_SPEED = 0;
    private static final int WALL_LP = 1;



    private GameObject tank(final int speed, final  P2d startPos, final int lifePoints, final int damage) {
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

    public GameObject simpleBullet(final GameObject tank) {
        return new GameObjectImpl(tank.getSpeed() * BULLET_MULTIPLIER_SPEED, 
                    tank.getPosition().sum(new P2d(tank.getDirection().getX()*tank.getLength(), tank.getDirection().getY()*tank.getLength())), 
                    BULLET_LIFEPOINTS,
                    tank.getDamage()*DAMAGE_MULTIPLIER,
                    BULLET_LENGTH,
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
        return new GameObjectImpl(WALL_SPEED, startPos, WALL_LP, WALL_DAMAGE, WALL_LENGTH, Directions.NONE) {

            @Override
            public boolean isAlive() {
                return true;
            }

            @Override
            public void resolveCollision(GameObject obj) {
                
            }
            
        };
    }

    public GameObject standardTank(P2d startPos) {
        return this.tank(STD_TANK_SPEED , startPos, STD_TANK_LP, STD_TANK_DAMAGE);
    }

}
