package it.unibo.tankbattle.controller.api;

import it.unibo.tankbattle.common.NextAndPrevious;

/**
 * Control the virus data.
 * @param <T> param
 * @param <C> param 
 */
public interface ObjectsManager<T, C> {
    /**
     * javadoc.
     * @return return
     */
    T getActual();
    /**
     * javadoc.
     * @param delta param
     */
    void update(NextAndPrevious delta);
}
