package it.unibo.tankBattle.model.gameObject.impl.component;

import java.util.LinkedList;
import java.util.List;

import it.unibo.tankBattle.model.gameObject.api.component.AbstractComponent;
import it.unibo.tankBattle.model.gameObject.api.component.Collidable;
import it.unibo.tankBattle.model.gameObject.api.component.CollisionListener;
import it.unibo.tankBattle.model.gameObject.api.component.ObservableCollidable;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public class CollisionComponent extends AbstractComponent implements Collidable, ObservableCollidable  {

    private final List<CollisionListener> listeners = new LinkedList<>();

    @Override
    public void update(double time) {
    }

    @Override
    public void addListener(CollisionListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeListener(CollisionListener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public void resolveCollision(GameObject collidingObject) {
        this.listeners.forEach(listener -> listener.handleCollision(getGameObject(), collidingObject));
    }
    
}
