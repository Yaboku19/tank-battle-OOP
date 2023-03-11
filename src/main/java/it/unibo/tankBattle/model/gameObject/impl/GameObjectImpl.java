package it.unibo.tankBattle.model.gameObject.impl;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.model.gameObject.api.GameObject;

public abstract class GameObjectImpl implements GameObject {

    
    private P2d position;
    private Directions direction;
    private Directions lastDirection;
    private int lifePoints;
    private final int length;
    private final int damage;
    private final int speed;


    protected GameObjectImpl(final int speed, final  P2d startPos, final  int lifePoints, final  int damage, final int length, final Directions dir) {
        this.position = startPos;
        this.lifePoints = lifePoints;
        this.damage = damage;
        this.speed = speed;
        this.length = length;
        this.direction = dir;
        this.lastDirection = Directions.UP;
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
        return this.lastDirection;
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
        if(!dir.equals(Directions.NONE)) {
            this.lastDirection = dir;
        }
    }

    @Override
    public void update() {
        this.position = this.position.sum(new P2d(speed*direction.getX(), speed*direction.getY())); 
    }

    /**
     * 
     * It decrease Lifepoints of damageReceive.
     * 
     * @param damageReceive the gameObject.getDamage() of the object that has collide with it
     */
    protected void hit(final int damageReceive) {
        this.lifePoints = this.lifePoints - damageReceive; 
    }

    /**
     * 
     * It will knockback a gameObject in the opposite direction of where it has collide.
     * 
     * @param dir the direction passed by manageCollision of where the object has to be knock back
     */
    protected void knockBack(final Directions dir) {
        position = this.position.sum(new P2d(speed*dir.getX(), speed*dir.getY()));
    }

    /**
     * 
     * This method is called in case of the GamoObject collide with another object, this will return
     * the direction of where it has to be knockback
     * 
     * @param collidingObjPos the GameObject that has collide with it 
     * @return Direction of where it has to be knock back
     */
    protected Directions manageCollision(final P2d collidingObjPos) {        
        final double differenceX = collidingObjPos.getX() - this.position.getX();
        final double differenceY = collidingObjPos.getY() - this.position.getY();
        return Math.abs(differenceX) >= Math.abs(differenceY) 
            ? differenceX >= 0 
                ? Directions.LEFT
                : Directions.RIGHT
            : differenceY >=0
                ? Directions.UP
                : Directions.DOWN;
    }

}
