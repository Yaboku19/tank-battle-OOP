package it.unibo.tankbattle.model.world.api;

import java.util.stream.Stream;

import it.unibo.tankbattle.model.gameobject.api.object.GameObject;
/**
 * The classe where are saved all the GameObject of the Map.
 */
public interface World {
    /**
     * javadock.
     * @return return
     */
    Stream<GameObject> getEntities();
    /**
     * javadock.
     * @param gameObject param
     */
    void removeGameObject(GameObject gameObject);
    /**
     * javadock.
     * @param gameObject param
     */
    void addGameObject(GameObject gameObject);
}
