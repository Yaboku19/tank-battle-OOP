package it.unibo.tankbattle.model.collision.api;

import java.util.stream.Stream;
import it.unibo.tankbattle.model.gameobject.api.object.GameObject;

/**
 * Represents a strategy to manage the colliding objects.
 */
public interface CollisionManager {

    /**
     * Checks all the objects in a Stream and calls the {@link Collidable#resolveCollision(GameObject) resolveCollision}
     * method on the ones who are colliding.
     * @param objects stream of all the colliding objects
     */
    void manageCollisions(Stream<GameObject> objects);
}
