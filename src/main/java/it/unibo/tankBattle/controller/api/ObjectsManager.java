package it.unibo.tankBattle.controller.api;

import it.unibo.tankBattle.common.NextAndPrevious;

/**
 * Control the virus data. 
 */
public interface ObjectsManager<T, C> {

    /**
     *
     * Read all the tanks from the config file.
     */
    void read(Class<C> clas);

    T getActual();

    void update(NextAndPrevious delta);
}
