package it.unibo.tankBattle.model.collision.api;

import it.unibo.tankBattle.model.gameObject.api.object.GameObject;
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
