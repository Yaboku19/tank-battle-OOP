package it.unibo.tankbattle.model.world.api;

import java.util.stream.Stream;
import it.unibo.tankbattle.model.gameobject.api.object.GameObject;

/**
 * rappresent the database of the games, it has all the {@link GameObject}.
 */
public interface World {

    /**
     * return all the GameObject.
     * @return A {@link Stream} of GameObject
     */
    Stream<GameObject> getEntities();

    /**
     * remove a gameObject.
     * @param gameObject gameObject that have to be deleted
     */
    void removeGameObject(GameObject gameObject);

    /**
     * add a new GameObject.
     * @param gameObject gameObject that have to be added
     */
    void addGameObject(GameObject gameObject);
}
