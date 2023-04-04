package it.unibo.tankbattle.controller.api;

import it.unibo.tankbattle.model.gamesetup.impl.TankData;

/**
 * Represents the player.
 */
public interface Player {

    /**
     * @return the score
     */
    int getScore();

    /**
     * Increments the score of the player.
     */
    void incScore();

    /**
     * @return the name of the player
     */
    String getName();

    /**
     * @return the data of the tank oth the player
     */
    TankData getTankData();
}
