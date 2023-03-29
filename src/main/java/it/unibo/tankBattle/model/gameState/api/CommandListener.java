package it.unibo.tankbattle.model.gameState.api;

import it.unibo.tankbattle.common.input.api.Direction;
import it.unibo.tankbattle.controller.api.Player;
/**
 * javadock.
 */
public interface CommandListener {
    /**
     * javadock.
     * @param player param
     */
    void shot(Player player);
    /**
     * javadock.
     * @param direction param
     * @param player param
     */
    void setDirection(Direction direction, Player player);
}
