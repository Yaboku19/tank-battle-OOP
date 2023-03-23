package it.unibo.tankBattle.controller.api;

import it.unibo.tankBattle.common.NextAndPrevious;

/**
 * Control the virus data. 
 */
public interface ObjectsManager<T> {

    /**
     *
     * Read all the tanks from the config file.
     */
    void read();

    T getActual();

    void update(NextAndPrevious delta);
}
