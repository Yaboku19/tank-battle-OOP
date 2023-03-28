package it.unibo.tankBattle.model.collision.api;

import java.util.stream.Stream;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;
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
