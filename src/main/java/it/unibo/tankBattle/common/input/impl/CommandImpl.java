package it.unibo.tankBattle.common.input.impl;

import it.unibo.tankBattle.common.input.api.Command;
import it.unibo.tankBattle.controller.api.Player;

public class CommandImpl implements Command{

    private int keyCode;

    public CommandImpl(final int keyCode){
        this.keyCode = keyCode;
    }

    @Override
    public void execute(Player player) {
        // TODO Auto-generated method stub
    }
    
}
