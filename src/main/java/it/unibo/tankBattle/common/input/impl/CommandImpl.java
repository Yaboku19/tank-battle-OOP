package it.unibo.tankBattle.common.input.impl;

import it.unibo.tankBattle.common.Player;
import it.unibo.tankBattle.common.input.api.Command;

public class CommandImpl implements Command{

    private int keyCode;

    public CommandImpl(final int keyCode){
        this.keyCode = keyCode;
    }

    @Override
    public void execute(Player player, int keyCode) {
        // TODO Auto-generated method stub
    }
    
}
