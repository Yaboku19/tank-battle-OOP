package it.unibo.tankBattle.model.gameState.api;

import it.unibo.tankBattle.common.input.api.Direction;
import it.unibo.tankBattle.controller.api.Player;
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
