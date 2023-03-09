package it.unibo.tankBattle.model.collision.api;

import java.util.List;
import java.util.stream.Stream;
import it.unibo.tankBattle.common.Pair;

public interface CollisionManager {
    
    Stream<Pair<BoundingBox, BoundingBox>> findCollidingObjects(List<BoundingBox> objects);

}
