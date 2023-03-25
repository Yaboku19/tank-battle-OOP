package it.unibo.tankBattle.model.gameObject.api.component;

import it.unibo.tankBattle.controller.api.Player;

public class Tank extends AbstractComponent {

    private final Player player;
    private final double shotCountdown;
    private double timer;
    private final int damage;
    private final double speed;
    private static final double STANDARD_COUNTDOWN = 1000;
    private static final double STANDARD_SPEED = 0.1;
    private static final double SPEED_REDUCER = 100;

    public Tank(Player player) {
        this.player = player;
        this.damage = player.getTankData().getDamage();
        this.speed = STANDARD_SPEED + (double)player.getTankData().getSpeed()/SPEED_REDUCER;
        this.shotCountdown = STANDARD_COUNTDOWN + 100/speed; 
        this.timer = this.shotCountdown;
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

    public int getDamage() {
        return this.damage;
    }

    public double getSpeed() {
        return this.speed;
    }
    
}
