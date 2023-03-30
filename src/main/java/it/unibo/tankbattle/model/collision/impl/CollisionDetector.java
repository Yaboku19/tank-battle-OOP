package it.unibo.tankbattle.model.collision.impl;

import it.unibo.tankbattle.model.gameobject.api.component.Collidable;

/**
 * Represents a strategy to check if two {@link Collidable} objects are colliding.
 */
public interface CollisionDetector {

    /**
     * Checks if any corner of the two {@link Collidable}s is in the area of the other.
     * @param object1 first {@link Collidable} object
     * @param object2 second {@link Collidable} object
     * @return if the objects are colliding
     */
    boolean detect(Collidable object1, Collidable object2);
}
