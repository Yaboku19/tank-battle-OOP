package it.unibo.tankbattle.model.collision.api;

import it.unibo.tankbattle.model.gameObject.api.object.GameObject;
/**
 * javadoc.
 */
public interface CollisionListener {
    /**
     * javadoc.
     * @param self param
     * @param collidingObject param
     */
    void handleCollision(GameObject self, GameObject collidingObject);
}
