package it.unibo.tankbattle.controller.api;

import it.unibo.tankbattle.common.NextAndPrevious;

/**
 * Control the virus data.
 * @param <T> Data type
 * @param <C> DataList type
 */
public interface ObjectsManager<T, C> {

    /**
     * 
     * @return return the actual
     */
    T getActual();

    /**
     * update the actual.
     * @param delta how the update has to be done
     */
    void update(NextAndPrevious delta);
}
