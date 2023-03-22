package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.model.gameObject.api.component.AbstractComponent;
import it.unibo.tankBattle.model.gameObject.api.component.Damageable;
import it.unibo.tankBattle.model.gameObject.api.component.Health;

public class DamageableImpl extends AbstractComponent implements Damageable {

    private int lifePoints;

    public DamageableImpl(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    @Override
    public void update(double time) {
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints; 
    }

    @Override
    public void takeDamage(int damage) {
        this.lifePoints = this.lifePoints - damage;
        if (this.lifePoints <= 0) {
            getSiblingComponent(Health.class).ifPresent(Health::die);
        }
    }
    
}
