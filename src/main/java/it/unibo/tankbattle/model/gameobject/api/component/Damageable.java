package it.unibo.tankbattle.model.gameobject.api.component;

/**
 * Represents a particular {@link Component} that enables the attached
 * {@link it.unibo.tankbattle.model.gameobject.api.object.GameObject} to take damage.
 */
public interface Damageable extends Component {

    /**
     * Gets the current life points of the object.
     * @return the current life points
     */
    int getLifePoints();

    /**
     * Sets the amount of the taken damage.
     * @param damage the amount of the damage
     */
    void takeDamage(int damage);
}
