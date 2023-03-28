package it.unibo.tankBattle.model.gameObject.api.component;

import it.unibo.tankBattle.model.collision.api.CollisionListener;
/**
 * javadoc.
 */
public interface ObservableCollidable extends Component {
    /**
     * javadoc.
     * @param listener param
     */
    void addListener(CollisionListener listener);
    /**
     * javadoc.
     * @param listener param
     */
    void removeListener(CollisionListener listener);
}
