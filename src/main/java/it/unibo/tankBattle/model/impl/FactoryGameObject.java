package it.unibo.tankBattle.model.impl;

import it.unibo.tankBattle.common.V2d;
import it.unibo.tankBattle.model.api.GameObject;
import javafx.geometry.Point2D;

public class FactoryGameObject {
    
    private static final int DAMAGE_MULTIPLIER = 10;

    public GameObject simpleTank(V2d speed, Point2D startPos, int lifePoints, int damage) {
        return new GameObject(speed , startPos, lifePoints, damage) {

            @Override
            public boolean isAlive(GameObject obj) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'isAlive'");
            }

            @Override
            public void update() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'update'");
            }
            
        };
    }

    public GameObject simpleBullet(V2d speed, Point2D startPos, GameObject tank) {
        return new GameObject(speed, startPos, 1, tank.getDamage()*DAMAGE_MULTIPLIER) {

            @Override
            public boolean isAlive(GameObject obj) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'isAlive'");
            }

            @Override
            public void update() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'update'");
            }
            
        };
    }

}
