package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.model.gameObject.api.component.DamageDealer;

public class SimpleDamageDealer extends AbstractComponent implements DamageDealer {

    private final int damage;

    public SimpleDamageDealer(final int damage) {
        this.damage = damage;
    }

    @Override
    public void update(double time) {

    }

    @Override
    public int getDamage() {
        return this.damage;
    }
    
}
