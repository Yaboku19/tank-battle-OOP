package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.model.gameObject.api.component.AbstractComponent;
import it.unibo.tankBattle.model.gameObject.api.component.Damageable;
import it.unibo.tankBattle.model.gameObject.api.component.Health;
/**
 * javadoc.
 */
public class DamageableImpl extends AbstractComponent implements Damageable {

    private int lifePoints;
    /**
     * javadoc.
     * @param lifePoints param
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
