package it.unibo.tankBattle.model.collision.impl;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import it.unibo.tankBattle.common.Pair;
import it.unibo.tankBattle.model.collision.api.BoundingBox;
import it.unibo.tankBattle.model.collision.api.CollisionManager;

public class CollisionManagerImpl implements CollisionManager {

    private CollisionDetector collisionDetector;

    public CollisionManagerImpl(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    @Override
    public Stream<Pair<BoundingBox, BoundingBox>> findCollidingObjects(List<BoundingBox> objects) {
        return IntStream
            .range(0, objects.size())
            .boxed()
            .flatMap(index -> objects.stream().skip(index + 1).map(object -> new Pair<>(objects.get(index), object)))
            .filter(pair -> this.collisionDetector.detect(pair.getX(), pair.getY()));
    }
    
}
