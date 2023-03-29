package it.unibo.tankbattle.model.gameobject.api.component;

import it.unibo.tankbattle.model.gameobject.api.object.GameObject;
/**
 * javadoc.
 */
public interface Collidable extends Component {
    /**
     * javadoc.
     * @param collidingObject param
     */
    void resolveCollision(GameObject collidingObject);
}
