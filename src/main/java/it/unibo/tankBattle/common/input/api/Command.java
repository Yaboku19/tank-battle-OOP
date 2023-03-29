package it.unibo.tankbattle.common.input.api;

import it.unibo.tankbattle.model.gameState.api.CommandListener;

/**
 * This interface represent a Command that come from user. 
 */
public interface Command {
    /**
     * javadoc.
     * @param model param
     */
    void execute(CommandListener model);
}
