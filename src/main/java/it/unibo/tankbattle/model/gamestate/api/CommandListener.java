package it.unibo.tankbattle.model.gamestate.api;

import it.unibo.tankbattle.common.input.api.Direction;
import it.unibo.tankbattle.controller.api.Player;

/**
 * Represents the Observer of {@link it.unibo.tankbattle.common.input.api.Command Command}.
 */
public interface CommandListener {

    /**
     * Gives signal to shoot.
     * @param player the player who shot 
     */
    void shoot(Player player);

    /**
     * Gives signal to change direction.
     * @param direction the new direction
     * @param player the player who changed direction
     */
    void setDirection(Direction direction, Player player);
}
