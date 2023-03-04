package it.unibo.tankBattle.model.impl;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.model.api.GameObject;
import javafx.geometry.BoundingBox;

public abstract class GameObjectImpl implements GameObject{

    private final int maxSpeed;
    private P2d position;
    private int currentSpeed;
    private Directions direction;
    private BoundingBox hitBox;
    private final int damage;
    private int lifePoints;

    public GameObjectImpl(int speed, P2d startPos, int lifePoints, int damage) {
        this.maxSpeed = speed;
        this.position = startPos;
        this.lifePoints = lifePoints;
        this.damage = damage;
        this.direction = Directions.UP;
    }

    @Override
    public P2d getPosition() {
        return position;
    }

    @Override
    public int getCurrentSpeed() {
        return currentSpeed;
    }

    @Override
    public Directions getDirection() {
        return direction;
    }

    @Override
    public BoundingBox getBoundingBox() {
        return hitBox;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getLifePoints() {
        return lifePoints;
    }

    @Override
    public void setDirection(Directions dir) {
        this.direction = dir;
    }

    @Override
    public void setPosition() {
        this.position.sum(new P2d(currentSpeed*direction.getX(), currentSpeed*direction.getY())); 
    }

    @Override
    public void hit(int damageReceive) {
        this.lifePoints = this.lifePoints - damageReceive; 
    }

    @Override
    public void move() {
        this.currentSpeed = maxSpeed;
    }

    @Override
    public void stop() {
        this.currentSpeed = 0;
    }
    
    public abstract boolean isAlive(GameObjectImpl obj);

    public abstract void update();
    
}
