package it.unibo.tankBattle.common.input.api;

import it.unibo.tankBattle.model.gameState.api.CommandListener;

/**
 * This interface represent a Command that come from user. 
 */
public interface Command {
    
    void execute(CommandListener model);
}
