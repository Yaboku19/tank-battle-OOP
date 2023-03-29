package it.unibo.tankbattle.controller.api;

import it.unibo.tankbattle.model.gamesetup.impl.TankData;
/**
 * javadoc.
 */
public interface Player {
    /**
     * javadoc.
     * @return return
     */
    int getScore();
    /**
     * javadoc.
     */
    void incScore();
    /**
     * javadoc.
     * @return return
     */
    String getCode();
    /**
     * javadoc.
     * @return return
     */
    TankData getTankData();
}
