package it.unibo.tankbattle.model.collision.impl;

import it.unibo.tankbattle.model.gameobject.api.component.Collidable;
/**
 * javadoc.
 */
public interface CollisionDetector {
    /**
     * javadoc.
     * @param object1 param
     * @param object2 param
     * @return return
     */
    boolean detect(Collidable object1, Collidable object2);
}
