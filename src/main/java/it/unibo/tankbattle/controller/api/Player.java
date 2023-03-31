package it.unibo.tankbattle.controller.api;

import it.unibo.tankbattle.model.gamesetup.impl.TankData;

/**
 * rappresent the player.
 */
public interface Player {

    /**
     * 
     * @return return the score
     */
    int getScore();

    /**
     * increment the score of the player.
     */
    void incScore();

    /**
     * 
     * @return return the name of the player
     */
    String getName();

    /**
     * 
     * @return return the data of the tank oth the player
     */
    TankData getTankData();
}
