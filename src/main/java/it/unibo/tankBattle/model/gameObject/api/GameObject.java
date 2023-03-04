package it.unibo.tankBattle.model.gameObject.api;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;
import javafx.geometry.BoundingBox;

public interface GameObject {
    
    public P2d getPosition();

    public int getCurrentSpeed();

    public Directions getDirection();

    public BoundingBox getBoundingBox();

    public int getDamage();

    public int getLifePoints();

    public int getMaxSpeed();

    public void setDirection(Directions dir);

    public void hit(int damageReceive);

    public void move();

    public void stop();

    public abstract boolean isAlive();

    public abstract void update();

    public abstract void resolveCollision();
}
