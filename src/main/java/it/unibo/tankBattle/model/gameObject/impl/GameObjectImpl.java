package it.unibo.tankBattle.model.gameObject.impl;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.model.gameObject.api.GameObject;

public abstract class GameObjectImpl implements GameObject{

    
    private P2d position;
    private Directions direction;
    private int lifePoints;
    private final int length;
    private final int damage;
    private final int speed;


    protected GameObjectImpl(final int speed,final  P2d startPos,final  int lifePoints,final  int damage, final int length, final Directions dir) {
        this.position = startPos;
        this.lifePoints = lifePoints;
        this.damage = damage;
        this.speed = speed;
        this.length = length;
        this.direction = dir;
    }

    @Override
    public P2d getPosition() {
        return this.position;
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public Directions getDirection() {
        return this.direction;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public int getLength() {
        return this.length;
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
    public void update() {
        this.position = this.position.sum(new P2d(speed*direction.getX(), speed*direction.getY())); 
    }

    protected void knockBack(final Directions dir) {
        position = this.position.sum(new P2d(speed*dir.getX(), speed*dir.getY()));
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
