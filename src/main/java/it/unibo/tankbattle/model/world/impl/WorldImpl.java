package it.unibo.tankbattle.model.world.impl;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import it.unibo.tankbattle.model.gameobject.api.object.GameObject;
import it.unibo.tankbattle.model.world.api.World;

/**
 * An implementation of {@link World}.
 */
public class WorldImpl implements World {

    private final Set<GameObject> setGameObject;

    /**
     * The constructor of {@link WorldImpl}.
     * @param streamGameObject a Stream of {@link GameObject}
     */
    protected WorldImpl(final Stream<GameObject> streamGameObject) {
        setGameObject = streamGameObject.collect(Collectors.toSet());
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public Stream<GameObject> getEntities() {
        return setGameObject.stream();
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void removeGameObject(final GameObject gameObject) {
        setGameObject.remove(gameObject);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void addGameObject(final GameObject gameObject) {
        setGameObject.add(gameObject);
    }
}
