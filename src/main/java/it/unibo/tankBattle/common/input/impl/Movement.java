package it.unibo.tankBattle.common.input.impl;


import it.unibo.tankBattle.common.input.api.Command;
import it.unibo.tankBattle.common.input.api.Direction;
import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.model.gameState.api.CommandListener;
/**
 * That class manage the movement of the players
 */
public class Movement implements Command{

    private Direction dir;
    private Player player;
    //private GameEngine controller;

    public Movement(final Direction dir, final Player player){//}, final GameEngine controller){
        this.dir = dir;
        this.player = player;
        //this.controller = controller;
    }

    @Override
    public void execute(CommandListener model) {
        //player.getTrasform.SetDirection(dir);
        model.setDirection(dir, player);
    }
    
}
