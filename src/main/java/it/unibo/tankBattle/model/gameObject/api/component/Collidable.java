package it.unibo.tankBattle.model.gameObject.api.component;

import it.unibo.tankBattle.model.gameObject.api.object.GameObject;
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
