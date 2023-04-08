package it.unibo.tankbattle.model.gameobject.api.component;

import it.unibo.tankbattle.model.collision.api.CollisionListener;

/**
 * Represents a way to register {@link CollisionListener}s to be notified when collisions happen.
 */
public interface ObservableCollidable extends Component {

    /**
     * Adds a {@link CollisionListener}.
     * @param listener the {@link CollisionListener} to be added
     */
    void addListener(CollisionListener listener);

    /**
     * Removes a {@link CollisionListener}.
     * @param listener the {@link CollisionListener} to be removed
     */
    void removeListener(CollisionListener listener);
}
