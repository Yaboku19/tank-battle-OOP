package it.unibo.tankBattle.common.input.impl;


import it.unibo.tankBattle.common.input.api.Command;
import it.unibo.tankBattle.model.gameState.impl.Player;

/**
 * That class manage the movement of the players
 */
public class Movement implements Command{

    private int keyCode;

    public Movement(final int keyCode){
        this.keyCode = keyCode;
    }

    @Override
    public void execute(Player player, int keyCode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
}
