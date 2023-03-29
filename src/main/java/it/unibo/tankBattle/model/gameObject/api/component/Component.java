package it.unibo.tankbattle.model.gameObject.api.component;

import it.unibo.tankbattle.model.gameObject.api.object.GameObject;
/**
 * javadoc.
 */
public interface Component {
    /**
     * javadoc.
     * @param time param
     */
    void update(double time);
    /**
     * javadoc.
     * @return return
     */
    GameObject getGameObject();
    /**
     * javadoc.
     * @param obj param
     */
    void attachGameObject(GameObject obj);
}
