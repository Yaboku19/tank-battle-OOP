package it.unibo.tankbattle.model.gameObject.impl.component;

import it.unibo.tankbattle.model.collision.api.CollisionListener;
import it.unibo.tankbattle.model.gameObject.api.component.AbstractComponent;
import it.unibo.tankbattle.model.gameObject.api.component.Damageable;
import it.unibo.tankbattle.model.gameObject.api.component.ObservableCollidable;
import it.unibo.tankbattle.model.gameObject.api.object.GameObject;
/**
 * javadoc.
 */
public class DealDamageOnCollision extends AbstractComponent implements CollisionListener {

    private final int damage;
    /**
     * javadoc.
     * @param damage
     */
    public DealDamageOnCollision(final int damage) {
        this.damage = damage;
    }
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
        collidingObject
            .getComponent(Damageable.class)
            .ifPresent(damageable -> damageable.takeDamage(this.damage));
    }
}
