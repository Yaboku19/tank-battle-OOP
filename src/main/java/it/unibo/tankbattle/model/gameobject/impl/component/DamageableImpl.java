package it.unibo.tankbattle.model.gameobject.impl.component;

import it.unibo.tankbattle.model.gameobject.api.component.AbstractComponent;
import it.unibo.tankbattle.model.gameobject.api.component.Damageable;
import it.unibo.tankbattle.model.gameobject.api.component.Health;

/**
 * Represents an implementation of the {@link Damageable} {@link Component}.
 */
public class DamageableImpl extends AbstractComponent implements Damageable {

    private int lifePoints;

    /**
     * Initializes a {@link DamageableImpl} given its life points.
     * @param lifePoints the life points of the object
     */
    public DamageableImpl(final int lifePoints) {
        this.lifePoints = lifePoints;
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void update(final double time) {
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public int getLifePoints() {
        return this.lifePoints; 
    }
    
    /**
    * {@inheritDoc}
    */
    @Override
    public void takeDamage(final int damage) {
        this.lifePoints = this.lifePoints - damage;
        if (this.lifePoints <= 0) {
            getSiblingComponent(Health.class).ifPresent(Health::die);
        }
    }
}
