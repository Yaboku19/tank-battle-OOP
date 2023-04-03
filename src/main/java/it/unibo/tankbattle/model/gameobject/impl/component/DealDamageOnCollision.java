package it.unibo.tankbattle.model.gameobject.impl.component;

import it.unibo.tankbattle.model.collision.api.CollisionListener;
import it.unibo.tankbattle.model.gameobject.api.component.Damageable;
import it.unibo.tankbattle.model.gameobject.api.component.ObservableCollidable;
import it.unibo.tankbattle.model.gameobject.api.object.GameObject;

/**
 * Represents a particular {@link it.unibo.tankbattle.model.gameobject.api.component.Component} that enables the attached 
 * {@link GameObject} to deal the received damage after a collision.
 */
public class DealDamageOnCollision extends AbstractComponent implements CollisionListener {

    private final int damage;

    /**
     * Initializes a {@link DealDamageOnCollision} given its damage.
     * @param damage the damage
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
