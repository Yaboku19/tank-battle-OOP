package it.unibo.tankbattle.model.gameobject.api.component;

import it.unibo.tankbattle.model.gameobject.api.object.GameObject;
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
