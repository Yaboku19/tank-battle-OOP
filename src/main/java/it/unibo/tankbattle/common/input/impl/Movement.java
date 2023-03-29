package it.unibo.tankbattle.common.input.impl;


import it.unibo.tankbattle.common.input.api.Command;
import it.unibo.tankbattle.common.input.api.Direction;
import it.unibo.tankbattle.controller.api.Player;
import it.unibo.tankbattle.model.gameState.api.CommandListener;
/**
 * That class manage the movement of the players.
 */
public class Movement implements Command {

    private final Direction dir;
    private final Player player;
    //private GameEngine controller;
    /**
     * javadoc.
     * @param dir param
     * @param player param
     */
    public Movement(final Direction dir, final Player player) {
        this.dir = dir;
        this.player = player;
        //this.controller = controller;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void execute(final CommandListener model) {
        //player.getTrasform.SetDirection(dir);
        model.setDirection(dir, player);
    }

}
