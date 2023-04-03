package it.unibo.tankbattle.model.gameobject.impl.component;

import it.unibo.tankbattle.model.gameobject.api.component.Health;

/**
 * Represents an implementation of the {@link Health}
 * {@link it.unibo.tankbattle.model.gameobject.api.component.Component}.
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
