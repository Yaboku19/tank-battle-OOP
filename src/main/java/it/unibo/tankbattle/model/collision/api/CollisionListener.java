package it.unibo.tankbattle.model.collision.api;

import it.unibo.tankbattle.model.gameobject.api.object.GameObject;

/**
 * Represents a listener of the collisions.
 */
public interface CollisionListener {

    /**
     * Invoked when the listener needs to be notified of a collision.
     * @param self first {@link GameObject} 
     * @param collidingObject the other {@link GameObject} colliding
     */
    void handleCollision(GameObject self, GameObject collidingObject);
}
