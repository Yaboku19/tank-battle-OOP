package it.unibo.tankBattle.model.world.impl;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;
import it.unibo.tankBattle.model.world.api.World;

public class WorldImpl implements World{
    private final Set<GameObject> setGameObject;

    protected WorldImpl (final Stream<GameObject> streamGameObject) {
        setGameObject = streamGameObject.collect(Collectors.toSet());
    }

    @Override
    public Stream<GameObject> getEntities() {
        return setGameObject.stream();
    }

    @Override
    public void removeGameObject(final GameObject gameObject) {
        setGameObject.remove(gameObject);
    }

    @Override
    public void addGameObject(final GameObject gameObject) {
        setGameObject.add(gameObject);
    }
    
}
