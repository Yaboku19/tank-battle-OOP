package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.model.gameObject.api.component.Health;

public class TankHealth extends AbstractComponent implements Health {


    private int lifePoints;

    public TankHealth(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    @Override
    public void update(double time) {

    }

    @Override
    public boolean isAlive() {
        return this.lifePoints > 0;
    }

    public void decreaseLifePoints(int damageReceive) {
        this.lifePoints = this.lifePoints - damageReceive;
    }

    public int getLifePoints() {
        return this.lifePoints;
    }

    
}
