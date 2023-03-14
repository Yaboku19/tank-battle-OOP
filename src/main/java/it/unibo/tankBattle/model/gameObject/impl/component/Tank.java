package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.controller.api.Player;

public class Tank extends AbstractComponent {

    private final Player player;

    public Tank(final Player player) {
        this.player = player;
    }

    @Override
    public void update(double time) {

    }

    public Player getPlayer() {
        return this.player;
    }
    
}
