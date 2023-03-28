package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.model.gameObject.api.component.AbstractComponent;
import it.unibo.tankBattle.model.gameObject.api.component.Health;
/**
 * javadoc.
 */
public class HealthImpl extends AbstractComponent implements Health {

    private boolean alive = true;
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
    public boolean isAlive() {
        return this.alive;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void die() {
        this.alive = false;
    } 
}
