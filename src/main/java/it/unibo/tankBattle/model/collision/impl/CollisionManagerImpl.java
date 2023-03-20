package it.unibo.tankBattle.model.collision.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import it.unibo.tankBattle.common.Pair;
import it.unibo.tankBattle.model.collision.api.CollisionManager;
import it.unibo.tankBattle.model.gameObject.api.component.Collidable;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public class CollisionManagerImpl implements CollisionManager {

    private final CollisionDetector detector;

    public CollisionManagerImpl(CollisionDetector detector) {
        this.detector = detector;
    }

    @Override
    public void manageCollisions(Stream<GameObject> objects) {
        Stream<Pair<Collidable, Collidable>> collidingObjects = findCollidingObjects(
            objects
                .map(x -> x.getComponent(Collidable.class))
                .filter(Optional::isPresent)
                .map(Optional::get)
        );
        collidingObjects.forEach(pair -> {
            pair.getX().resolveCollision(pair.getY());
            pair.getY().resolveCollision(pair.getX());
        });
    }

    private Stream<Pair<Collidable, Collidable>> findCollidingObjects(Stream<Collidable> collidables) {
        List<Collidable> collidablesList = collidables.toList();
        return IntStream
            .range(0, collidablesList.size())
            .boxed()
            .flatMap(index -> collidablesList
                .stream()
                .skip(index + 1)
                .map(object -> new Pair<>(collidablesList.get(index), object)))
            .filter(pair -> this.detector.detect(pair.getX(), pair.getY()));
    }
    
}
