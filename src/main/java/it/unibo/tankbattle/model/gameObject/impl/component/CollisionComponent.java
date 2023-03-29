package it.unibo.tankbattle.model.gameobject.impl.component;

import java.util.LinkedList;
import java.util.List;

import it.unibo.tankbattle.model.collision.api.CollisionListener;
import it.unibo.tankbattle.model.gameobject.api.component.AbstractComponent;
import it.unibo.tankbattle.model.gameobject.api.component.Collidable;
import it.unibo.tankbattle.model.gameobject.api.component.ObservableCollidable;
import it.unibo.tankbattle.model.gameobject.api.object.GameObject;
/**
 * javadoc.
 */
public class CollisionComponent extends AbstractComponent implements Collidable, ObservableCollidable  {

    private final List<CollisionListener> listeners = new LinkedList<>();
    /**
    * {@inheritDoc}
    */
    @Override
    public void update(final double time) {
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void addListener(final CollisionListener listener) {
        this.listeners.add(listener);
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void removeListener(final CollisionListener listener) {
        this.listeners.remove(listener);
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void resolveCollision(final GameObject collidingObject) {
        this.listeners.forEach(listener -> listener.handleCollision(getGameObject(), collidingObject));
    }
}
