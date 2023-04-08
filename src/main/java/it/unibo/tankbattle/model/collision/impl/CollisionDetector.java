package it.unibo.tankbattle.model.collision.impl;

import it.unibo.tankbattle.common.Transform;

/**
 * Represents a strategy to check if the {@link Transform} of two objects are colliding.
 */
public interface CollisionDetector {

    /**
     * Checks if any corner of the two {@link Transform}s is in the area of the other.
     * @param object1 first {@link Transform} object
     * @param object2 second {@link Transform} object
     * @return if the objects are colliding
     */
    boolean detect(Transform object1, Transform object2);
}
