package it.unibo.tankBattle.common.input.impl;

import it.unibo.tankBattle.common.input.api.Command;
import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.model.gameState.api.CommandListener;
/**
 * That class manage shoot of the player.
 */
public class Shoot implements Command {

    private Player player;
    /**
     * javadoc.
     * @param player player
     */
    public Shoot(final Player player) {
        this.player = player;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void execute(final CommandListener model) {
        model.shot(player);
        System.out.println(player.getCode());
    }

}
