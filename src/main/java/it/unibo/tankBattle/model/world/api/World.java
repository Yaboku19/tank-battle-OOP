package it.unibo.tankBattle.model.world.api;

import java.util.stream.Stream;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;
/**
 * The classe where are saved all the GameObject of the Map.
 */
public interface World {
    public Stream<GameObject> getEntities();

    public void removeGameObject(final GameObject gameObject);

    public void addGameObject(final GameObject gameObject);
}
