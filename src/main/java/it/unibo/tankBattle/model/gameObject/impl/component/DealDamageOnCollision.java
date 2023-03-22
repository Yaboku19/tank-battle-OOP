package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.model.collision.api.CollisionListener;
import it.unibo.tankBattle.model.gameObject.api.component.AbstractComponent;
import it.unibo.tankBattle.model.gameObject.api.component.Damageable;
import it.unibo.tankBattle.model.gameObject.api.component.ObservableCollidable;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public class DealDamageOnCollision extends AbstractComponent implements CollisionListener {

    private final int damage;

    public DealDamageOnCollision(final int damage) {
        this.damage = damage;
    }

    @Override
    public void update(double time) {
    }

    @Override
    public void gameObjectAttached(GameObject object) {
        requireSiblingComponent(ObservableCollidable.class).addListener(this);
    }

    @Override
    public void handleCollision(GameObject self, GameObject collidingObject) {
        collidingObject
            .getComponent(Damageable.class)
            .ifPresent(damageable -> damageable.takeDamage(this.damage));
    }
}
