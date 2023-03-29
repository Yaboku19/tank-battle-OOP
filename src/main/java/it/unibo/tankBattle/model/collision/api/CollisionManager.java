package it.unibo.tankbattle.model.collision.api;

import java.util.stream.Stream;

import it.unibo.tankbattle.model.gameObject.api.object.GameObject;
/**
 * javadoc.
 */
public interface CollisionManager {
    /**
     * javadoc.
     * @param objects param
     */
    void manageCollisions(Stream<GameObject> objects);
}
