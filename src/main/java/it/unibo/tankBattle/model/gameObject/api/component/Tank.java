package it.unibo.tankBattle.model.gameObject.api.component;

import it.unibo.tankBattle.controller.api.Player;

public class Tank extends AbstractComponent {

    private final Player player;
    private final double shotCountdown;
    private double timer;
    private final int damage;
    private final double speed;

    public Tank(Player player) {
        this.player = player;
        this.damage = player.getTankData().getDamage();
        this.speed = (double) player.getTankData().getSpeed()/10;
        System.out.println(this.speed);
        this.shotCountdown = 1000 + 100/speed; //to update
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
