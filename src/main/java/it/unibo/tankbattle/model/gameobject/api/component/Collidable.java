package it.unibo.tankbattle.model.gameobject.api.component;

import it.unibo.tankbattle.model.gameobject.api.object.GameObject;

/**
 * Represents a particular {@link Component} that enables the attached {@link GameObject} to collide.
 */
public interface Collidable extends Component {
    
    /**
     * Handles the collision with the given {@link GameObject}.
     * @param collidingObject the colliding object
     */
    void resolveCollision(GameObject collidingObject);
}
