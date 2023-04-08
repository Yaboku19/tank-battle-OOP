package it.unibo.tankbattle.controller.api;

import it.unibo.tankbattle.common.NextAndPrevious;
import it.unibo.tankbattle.common.input.api.Command;

/**
 * Represents the MVC Controller.
 */
public interface GameEngine extends Runnable {

    /**
     * Used for start the game loop.
     */
    void startGame();

    /**
     * It is called by the view for add a command.
     * @param command the command
     */
    void notifyCommand(Command command);

    /**
     * @return return the first player
     */
    Player getFirstPlayer();

    /**
     * @return return the second player.
     */
    Player getSecondPlayer();

    /**
     * Update the setting of the first tank.
     * @param delta it's used to indicate how the setting has to be updated
     */
    void updateTankPlayer1(NextAndPrevious delta);

    /**
     * Update the setting of the second tank.
     * @param delta it's used to indicate how the setting has to be updated
     */
    void updateTankPlayer2(NextAndPrevious delta);

    /**
     * Update the setting of the map.
     * @param delta it's used to indicate how the setting has to be updated
     */
    void updateMap(NextAndPrevious delta);

    /**
     * Set the resource of the view.
     */
    void setViewResources();

    /**
     * Used to restart the game with the same settings.
     */
    void restartGame();

    /**
     * Used to restart configuration.
     */
    void restartApplication();
}
