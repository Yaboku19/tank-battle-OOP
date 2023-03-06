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
     * @return the speed
     */
    public int getSpeed();

    /**
     * 
     * @return  Directions of where the object want to move
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
     * @return true if LifePoints are more than 0, false otherwise
     */
    public abstract boolean isAlive();

    /**
     * Update it's current position each frame
     */
    public void update();

    /**
     * 
     * Move the object to the opposite side from where it has collide
     * 
     * @param obj the object that collide with it
     */
    public abstract void resolveCollision(GameObject obj);

}
