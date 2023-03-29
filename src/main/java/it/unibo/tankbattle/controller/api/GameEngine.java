package it.unibo.tankbattle.controller.api;

import it.unibo.tankbattle.common.NextAndPrevious;
import it.unibo.tankbattle.common.input.api.Command;
/**
 * javadoc.
 */
public interface GameEngine extends Runnable {
    /**
     * javadoc.
     */
    void startGame();
    /**
     * javadoc.
     * @param command param
     */
    void notifyCommand(Command command);
    /**
     * javadoc.
     * @return return
     */
    Player getFirstPlayer();
    /**
     * javadoc.
     * @return return
     */
    Player getSecondPlayer();
    /**
     * javadoc.
     * @param delta param
     */
    void updateTankPlayer1(NextAndPrevious delta);
    /**
     * javadoc.
     * @param delta param
     */
    void updateTankPlayer2(NextAndPrevious delta);
    /**
     * javadoc.
     * @param delta param
     */
    void updateMap(NextAndPrevious delta);
    /**
     * javadoc.
     */
    void setViewResources();
    /**
     * javadoc.
     */
    void restart();
    /**
     * javadoc.
     */
    void newStart();
}
