package it.unibo.tankBattle.common.input.impl;

import it.unibo.tankBattle.common.input.api.Command;
import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.controller.api.Player;
/**
 * That class manage shoot of the player
 */
public class Shoot implements Command{

    private Player player;
    private GameEngine controller;

    public Shoot(final Player player, final GameEngine controller){
        this.player = player;
        this.controller = controller;
    }

    
    @Override
    public void execute() {
        controller.getWorld().shot(player);
        System.out.println(player.getCode());
    }
    
}
