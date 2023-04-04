package it.unibo.tankbattle.model.gameobject.impl.component;

import it.unibo.tankbattle.model.collision.api.CollisionListener;
import it.unibo.tankbattle.model.gameobject.api.component.Health;
import it.unibo.tankbattle.model.gameobject.api.component.ObservableCollidable;
import it.unibo.tankbattle.model.gameobject.api.object.GameObject;

/**
 * Represents a particular {@link it.unibo.tankbattle.model.gameobject.api.component.Component Component}
 * that enables the attached {@link GameObject} to be destroyed after a collision.
 */
public class DestroyOnCollision extends AbstractComponent implements CollisionListener {

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
    public void gameObjectAttached(final GameObject object) {
        requireSiblingComponent(ObservableCollidable.class).addListener(this);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void handleCollision(final GameObject self, final GameObject collidingObject) {
        requireSiblingComponent(Health.class).die();
    }
}
