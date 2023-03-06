package it.unibo.tankBattle.common.input.api;

import it.unibo.tankBattle.model.gameState.api.Player;

/**
 * This interface represent a Command that come from user. 
 */
public interface Command {
    
    void execute(Player player, int keyCode);
}
