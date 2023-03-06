package it.unibo.tankBattle.common.input.impl;

import it.unibo.tankBattle.common.Player;
import it.unibo.tankBattle.common.input.api.Command;
/**
 * That class manage shoot of the player
 */
public class Shoot implements Command{

    private int keyCode;

    public Shoot(final int keyCode){
        this.keyCode = keyCode;
    }


    @Override
    public void execute(Player player, int keyCode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
}
