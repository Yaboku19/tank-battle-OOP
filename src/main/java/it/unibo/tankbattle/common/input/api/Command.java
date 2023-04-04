package it.unibo.tankbattle.common.input.api;

import it.unibo.tankbattle.model.gamestate.api.CommandListener;

/**
 * This interface represent a Command that come from player. 
 */
public interface Command {
    /**
     * That method execute the command.
     * @param model model command listener.
     */
    void execute(CommandListener model);
}
