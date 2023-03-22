package it.unibo.tankBattle.model.gameObject.api.component;

import it.unibo.tankBattle.controller.api.Player;

public class Tank extends AbstractComponent {

    private final Player player;
    private final double shotCountdown;
    private double timer;

    public Tank(Player player, double shotCountdown) {
        this.player = player;
        this.shotCountdown = shotCountdown;
        this.timer = shotCountdown;
    }

    @Override
    public void update(double time) {
        this.timer = this.timer + time; 
    }

    public Player getPlayer() {
        return this.player;
    }

    public boolean canShot() {
        if(this.timer >= shotCountdown) {
            this.timer = 0;
            return true;
        }
        return false;
    }

    
}
