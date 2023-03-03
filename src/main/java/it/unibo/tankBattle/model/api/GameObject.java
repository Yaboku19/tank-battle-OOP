package it.unibo.tankBattle.model.api;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;
import javafx.geometry.BoundingBox;

public abstract class GameObject {

    private final int maxSpeed;
    private P2d position;
    private int currentSpeed;
    private Directions direction;
    private BoundingBox hitBox;
    private final int damage;
    private int lifePoints;

    public GameObject(int speed, P2d startPos, int lifePoints, int damage) {
        this.maxSpeed = speed;
        this.position = startPos;
        this.lifePoints = lifePoints;
        this.damage = damage;
        this.direction = Directions.UP;
    }

    public P2d getPosition() {
        return position;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public Directions getDirection() {
        return direction;
    }

    public BoundingBox getBoundingBox() {
        return hitBox;
    }

    public int getDamage() {
        return damage;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setDirection(Directions dir) {
        this.direction = dir;
    }

    public void setPosition(P2d newPos) {
        this.position = newPos; 
    }

    public void hit(int damageReceive) {
        this.lifePoints = this.lifePoints - damageReceive; 
    }

    public void move() {
        this.currentSpeed = maxSpeed;
    }

    public void stop() {
        this.currentSpeed = 0;
    }
    
    public abstract boolean isAlive(GameObject obj);

    public abstract void update();
    
}
