package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.model.collision.api.CollisionListener;
import it.unibo.tankBattle.model.gameObject.api.component.AbstractComponent;
import it.unibo.tankBattle.model.gameObject.api.component.Health;
import it.unibo.tankBattle.model.gameObject.api.component.ObservableCollidable;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;
/**
 * javadoc.
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
