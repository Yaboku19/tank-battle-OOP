package it.unibo.tankbattle.model.gameobject.impl.component;

import it.unibo.tankbattle.model.collision.api.CollisionListener;
import it.unibo.tankbattle.model.gameobject.api.component.ObservableCollidable;
import it.unibo.tankbattle.model.gameobject.api.object.GameObject;

/**
 * Represents an abstract {@link it.unibo.tankbattle.model.gameobject.api.component.Component Component}
 * that observes the collisions and manages the related {@link CollisionListener}.
 */
public abstract class CollisionHandlingComponent extends AbstractComponent implements CollisionListener {

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
}
