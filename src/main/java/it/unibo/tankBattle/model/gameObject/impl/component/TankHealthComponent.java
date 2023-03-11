package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.model.gameObject.api.component.HealthComponent;

public class TankHealthComponent extends AbstractComponent implements HealthComponent {


    private int lifePoints;
    

    public TankHealthComponent(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    @Override
    public void update(double time) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean isAlive() {
        return this.lifePoints > 0;
    }

    public void decreaseLifePoints(int damageReceive) {
        this.lifePoints = this.lifePoints - damageReceive;
    }

    
}
