package it.unibo.tankBattle.common.input.api;

import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.model.gameState.api.GameState;

/**
 * This interface represent a Command that come from user. 
 */
public interface Command {
    
    void execute(GameState model);
}
