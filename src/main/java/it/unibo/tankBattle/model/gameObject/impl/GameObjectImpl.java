package it.unibo.tankBattle.model.gameObject.impl;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.model.gameObject.api.GameObject;

public abstract class GameObjectImpl implements GameObject{

    
    private P2d position;
    private int currentSpeed;
    private Directions direction;
    private int lifePoints;
    private final int length;
    private final int damage;
    private final int maxSpeed;

    protected GameObjectImpl(final int speed,final  P2d startPos,final  int lifePoints,final  int damage, final int length) {
        this.maxSpeed = speed;
        this.position = startPos;
        this.lifePoints = lifePoints;
        this.damage = damage;
        this.currentSpeed = 0;
        this.length = length;
        this.direction = Directions.UP;
        currentSpeed = 0;
        direction = Directions.UP;
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
    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public Directions getDirection() {
        return direction;
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
    public int getLength() {
        return length;
    }

    @Override
    public void setDirection(final Directions dir) {
        this.direction = dir;
    }

    @Override
    public void hit(final int damageReceive) {
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
    
    protected void updatePosition() {
        position = this.position.sum(new P2d(currentSpeed*direction.getX(), currentSpeed*direction.getY())); 
    }

    protected void knockBack(final Directions dir) {
        position = this.position.sum(new P2d(maxSpeed*dir.getX(), maxSpeed*dir.getY()));
    }

    protected Directions manageCollision(final P2d collidingObjPos) {        
        final int differenceX = collidingObjPos.getX() - this.position.getX(); //maggiore di 0 se è piu a destra di me
        final int differenceY = collidingObjPos.getY() - this.position.getY(); //maggiore di 0 se è piu in giu di me
        return Math.abs(differenceX) >= Math.abs(differenceY) 
            ? differenceX >= 0 
                ? Directions.LEFT
                : Directions.RIGHT
            : differenceY >=0
                ? Directions.UP
                : Directions.DOWN;
    }

}
