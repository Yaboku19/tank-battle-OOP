package it.unibo.tankBattle.model.collision.api;

import java.util.stream.Stream;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public interface CollisionManager {
    
    void manageCollisions(Stream<GameObject> objects);

}
