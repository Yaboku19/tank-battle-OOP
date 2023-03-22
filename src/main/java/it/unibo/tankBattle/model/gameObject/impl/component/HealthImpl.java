package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.model.gameObject.api.component.AbstractComponent;
import it.unibo.tankBattle.model.gameObject.api.component.Health;

public class HealthImpl extends AbstractComponent implements Health {

    private boolean alive = true;

    @Override
    public void update(double time) {
    }

    @Override
    public boolean isAlive() {
        return this.alive;
    }

    @Override
    public void die() {
        this.alive = false;
    }
    
}
