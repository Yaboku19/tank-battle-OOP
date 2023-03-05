package it.unibo.tankBattle.model.gameObject.api;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;

/**
 * This interface model every gameObject
 */
public interface GameObject {
    
    /**
     * 
     * @return the position of the GameObject
     */
    public P2d getPosition();

    /**
     * 
     * @return the current speed, 0 if is not moving
     */
    public int getCurrentSpeed();

    /**
     * 
     * @return  Directions of where the tank want to shoot or move
     */
    public Directions getDirection();

    /**
     * 
     * @return the damage when a object collide with it
     */
    public int getDamage();

    /**
     * 
     * @return current lifePoints
     */
    public int getLifePoints();

    /**
     * 
     * @return speed when it's moving
     */
    public int getMaxSpeed();

    /**
     * 
     * @return the gameObject length
     */
    public int getLength();

    /**
     *  
     * Sets it current direction to dir 
     *  
     * @param dir direction where it wants to move
     */
    public void setDirection(Directions dir);

    /**
     * 
     * Decrease it's lifePoints of the given damage 
     * 
     * @param damageReceive damage it receive when collide
     */
    public void hit(int damageReceive);

    /**
     * 
     * Sets the current speed to maxSpeed
     */
    public void move();

    /**
     * 
     * Sets the current speed to 0
     */
    public void stop();

    /**
     * 
     * @return true if LifePoints are more than 0, false otherwise
     */
    public abstract boolean isAlive();

    /**
     * Update it's current position each frame
     */
    public abstract void update();

    /**
     * 
     * Move the object to the opposite side from where it has collide
     * 
     * @param obj the object that collide with it
     */
    public abstract void resolveCollision(GameObject obj);

}
