package it.unibo.tankBattle.model.collision.impl;

import it.unibo.tankBattle.model.gameObject.api.component.Collidable;
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
