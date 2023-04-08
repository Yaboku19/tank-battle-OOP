package it.unibo.tankbattle.model.collision.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import it.unibo.tankbattle.common.Pair;
import it.unibo.tankbattle.model.collision.api.CollisionManager;
import it.unibo.tankbattle.model.gameobject.api.component.Collidable;
import it.unibo.tankbattle.model.gameobject.api.object.GameObject;

/**
 * Implements {@link CollisionManager} interface using the {@link Collidable} component to resolve collisions.
 */
public class CollisionManagerImpl implements CollisionManager {

    private final CollisionDetector detector;

    /**
     * Initializes a new {@link CollisionManagerImpl} given a {@link CollisionDetector}.
     * @param detector the {@link CollisionDetector}
     */
    public CollisionManagerImpl(final CollisionDetector detector) {
        this.detector = detector;
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void manageCollisions(final Stream<GameObject> objects) {
        final Stream<Pair<Collidable, Collidable>> collidingObjects = findCollidingObjects(
            objects
                .map(x -> x.getComponent(Collidable.class))
                .filter(Optional::isPresent)
                .map(Optional::get)
        );
        collidingObjects
            .toList()
            .forEach(pair -> {
                pair.getX().resolveCollision(pair.getY().getGameObject());
                pair.getY().resolveCollision(pair.getX().getGameObject());
            });
    }

    private Stream<Pair<Collidable, Collidable>> findCollidingObjects(final Stream<Collidable> collidables) {
        final List<Collidable> collidablesList = collidables.toList();
        return IntStream
            .range(0, collidablesList.size())
            .boxed()
            .flatMap(index -> collidablesList
                .stream()
                .skip(index + 1)
                .map(object -> new Pair<>(collidablesList.get(index), object)))
            .filter(pair -> this.detector.detect(
                pair.getX().getGameObject().getTransform(), 
                pair.getY().getGameObject().getTransform())
            );
    }
}
