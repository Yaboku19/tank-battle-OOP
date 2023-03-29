package it.unibo.tankbattle.model.gameObject.api.component;

import it.unibo.tankbattle.controller.api.Player;
/**
 * javadoc.
 */
public class Tank extends AbstractComponent {
    private final Player player;
    private final double shotCountdown;
    private double timer;
    private final int damage;
    private final double speed;
    private static final double STANDARD_COUNTDOWN = 1000;
    private static final double STANDARD_SPEED = 0.1;
    private static final double SPEED_REDUCER = 100;
    /**
     * javadoc.
     * @param player param
     */
    public Tank(final Player player) {
        this.player = player;
        this.damage = player.getTankData().getDamage();
        this.speed = STANDARD_SPEED + (double) player.getTankData().getSpeed() / SPEED_REDUCER;
        this.shotCountdown = STANDARD_COUNTDOWN + 100 / speed; 
        this.timer = this.shotCountdown;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void update(final double time) {
        this.timer = this.timer + time;
    }
    /**
     * javadoc.
     * @return return.
     */
    public Player getPlayer() {
        return this.player;
    }
    /**
     * javadoc.
     * @return return
     */
    public boolean canShot() {
        if (this.timer >= shotCountdown) {
            this.timer = 0;
            return true;
        }
        return false;
    }
    /**
     * javadoc.
     * @return return
     */
    public int getDamage() {
        return this.damage;
    }
    /**
     * javadoc.
     * @return return
     */
    public double getSpeed() {
        return this.speed;
    }
}
