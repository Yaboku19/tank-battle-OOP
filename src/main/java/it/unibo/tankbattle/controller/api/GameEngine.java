package it.unibo.tankbattle.controller.api;

import it.unibo.tankbattle.common.NextAndPrevious;
import it.unibo.tankbattle.common.input.api.Command;

/**
 * rappresent the Controller.
 */
public interface GameEngine extends Runnable {

    /**
     * used for start the game loop.
     */
    void startGame();

    /**
     * it is called by the view for add a command.
     * @param command the command
     */
    void notifyCommand(Command command);

    /**
     * 
     * @return return the first player
     */
    Player getFirstPlayer();

    /**
     * 
     * @return return the second player.
     */
    Player getSecondPlayer();

    /**
     * update the setting of the first tank.
     * @param delta it's used to indicate how the setting has to be updated
     */
    void updateTankPlayer1(NextAndPrevious delta);

    /**
     * update the setting of the second tank.
     * @param delta it's used to indicate how the setting has to be updated
     */
    void updateTankPlayer2(NextAndPrevious delta);

    /**
     * update the setting of the map.
     * @param delta it's used to indicate how the setting has to be updated
     */
    void updateMap(NextAndPrevious delta);

    /**
     * set the resource of the view.
     */
    void setViewResources();

    /**
     * used for restart the game with the same settings.
     */
    void restart();

    /**
     * javadoc.
     */
    void newStart();
}
