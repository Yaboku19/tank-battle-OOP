package it.unibo.tankbattle.common.input.impl;

import it.unibo.tankbattle.common.input.api.Command;
import it.unibo.tankbattle.common.input.api.Direction;
import it.unibo.tankbattle.controller.api.Player;
import it.unibo.tankbattle.model.gamestate.api.CommandListener;
/**
 * That class manage the movement of the players.
 */
public class Movement implements Command {

    private final Direction dir;
    private final Player player;
    /**
     * @param dir new direction to set
     * @param player player to set new direction
     */
    public Movement(final Direction dir, final Player player) {
        this.dir = dir;
        this.player = player;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void execute(final CommandListener model) {
        model.setDirection(dir, player);
    }
}
