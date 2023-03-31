package it.unibo.tankbattle.model.gamestate.api;

import it.unibo.tankbattle.common.input.api.Direction;
import it.unibo.tankbattle.controller.api.Player;

/**
 * Rappresent the Obser of {@link Command}.
 */
public interface CommandListener {

    /**
     * give the input to a player to shot.
     * @param player the player 
     */
    void shot(Player player);

    /**
     * give the input to a player to change direction.
     * @param direction the direction
     * @param player the player
     */
    void setDirection(Direction direction, Player player);
}
