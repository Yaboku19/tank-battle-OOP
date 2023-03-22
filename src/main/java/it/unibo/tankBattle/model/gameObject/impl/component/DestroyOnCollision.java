package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.model.collision.api.CollisionListener;
import it.unibo.tankBattle.model.gameObject.api.component.AbstractComponent;
import it.unibo.tankBattle.model.gameObject.api.component.Health;
import it.unibo.tankBattle.model.gameObject.api.component.ObservableCollidable;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public class DestroyOnCollision extends AbstractComponent implements CollisionListener {

    @Override
    public void update(double time) {
    }

    @Override
    public void gameObjectAttached(GameObject object) {
        requireSiblingComponent(ObservableCollidable.class).addListener(this);
    }

    @Override
    public void handleCollision(GameObject self, GameObject collidingObject) {
        requireSiblingComponent(Health.class).die();
    }
}
