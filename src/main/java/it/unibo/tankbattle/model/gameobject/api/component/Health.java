package it.unibo.tankbattle.model.gameobject.api.component;

/**
 * Represents a particular {@link Component} that enables the attached
 * {@link it.unibo.tankbattle.model.gameobject.api.object.GameObject} to be removed from the world.
 */
public interface Health extends Component {

    /**
     * Checks if the object is currently alive.
     * @return whether the object is currently alive
     */
    boolean isAlive();

    /**
     * Makes this object die.
     */
    void die();
}
