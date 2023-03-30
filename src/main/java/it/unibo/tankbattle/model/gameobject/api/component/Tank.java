package it.unibo.tankbattle.model.gameobject.api.component;

import it.unibo.tankbattle.controller.api.Player;

/**
 * Represents a particular {@link Component} that marks the attached {@link GameObject} as a {@link Tank}.
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
     * Initializes a new {@link Tank} given its associated {@link Player}.
     * @param player the associated {@link Player}
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
     * Gets the associated {@link Player}.
     * @return the associated {@link Player}
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Returns whether this {@link Tank} can shoot.
     * @return whether this {@link Tank} can shoot
     */
    public boolean canShoot() {
        if (this.timer >= shotCountdown) {
            this.timer = 0;
            return true;
        }
        return false;
    }

    /**
     * Gets the damage of the shooting.
     * @return the damage
     */
    public int getDamage() {
        return this.damage;
    }

    /**
     * Gets the speed of this {@link Tank}.
     * @return the speed of this {@link Tank}
     */
    public double getSpeed() {
        return this.speed;
    }
}
