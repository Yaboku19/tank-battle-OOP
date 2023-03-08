package it.unibo.tankBattle.common.input.impl;


import it.unibo.tankBattle.common.input.api.Command;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.model.gameState.api.Player;

/**
 * That class manage the movement of the players
 */
public class Movement implements Command{

    private Directions dir;

    public Movement(final Directions dir){
        this.dir = dir;
    }

    @Override
    public void execute(Player player) {
        
    }
    
}
