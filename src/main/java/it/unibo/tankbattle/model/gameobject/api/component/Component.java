package it.unibo.tankbattle.model.gameobject.api.component;

import it.unibo.tankbattle.model.gameobject.api.object.GameObject;

/**
 * Represents an abstraction over the behaviour attachable to a {@link GameObject}.
 */
public interface Component {

    /**
     * Given an elapsed time, updates the behaviour of the {@link GameObject}.
     * @param time the elapsed time
     */
    void update(double time);

    /**
     * Gets the {@link GameObject} attached to this {@link Component}.
     * @return the attached {@link GameObject}
     */
    GameObject getGameObject();

    /**
     * Specifies the {@link GameObject} to which this {@link Component} gets attached.
     * @param object the given {@link GameObject}
     */
    void attachGameObject(GameObject object);
}
