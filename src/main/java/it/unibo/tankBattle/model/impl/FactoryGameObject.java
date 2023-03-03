package it.unibo.tankBattle.model.impl;

import it.unibo.tankBattle.model.api.GameObject;
import javafx.geometry.Point2D;

public class FactoryGameObject {
    
    private static final int DAMAGE_MULTIPLIER = 10;

    public GameObject simpleTank(int speed, Point2D startPos, int lifePoints, int damage) {
        return new GameObject(speed , startPos, lifePoints, damage) {

            @Override
            public boolean isAlive(GameObject obj) {
                return this.getLifePoints() > 0;
            }

            @Override
            public void update() {
                this.setPosition(new Point2D(0,0));
            }
            
        };
    }

    public GameObject simpleBullet(int speed, Point2D startPos, GameObject tank) {
        return new GameObject(speed, startPos, 1, tank.getDamage()*DAMAGE_MULTIPLIER) {

            @Override
            public boolean isAlive(GameObject obj) {
                return this.getLifePoints() > 0;
            }

            @Override
            public void update() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'update'");
            }
            
        };
    }

    public GameObject simpleWall(Point2D startPos) {
        return new GameObject(0, startPos, 1, 0) {

            @Override
            public boolean isAlive(GameObject obj) {
                return true;
            }

            @Override
            public void update() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'update'");
            }
            
        };
    }

}
