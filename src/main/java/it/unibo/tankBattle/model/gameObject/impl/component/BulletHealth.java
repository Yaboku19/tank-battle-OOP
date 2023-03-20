package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.model.gameObject.api.component.AbstractComponent;
import it.unibo.tankBattle.model.gameObject.api.component.Health;

public class BulletHealth extends AbstractComponent implements Health {

    private boolean isAlive = true;

    @Override
    public void update(double time) {

    }

    @Override
    public boolean isAlive() {
        return this.isAlive;    
    }

    public void hit() {
        this.isAlive = false;
    }
    
}
