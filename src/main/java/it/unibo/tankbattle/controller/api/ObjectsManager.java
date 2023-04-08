package it.unibo.tankbattle.controller.api;

import it.unibo.tankbattle.common.NextAndPrevious;

/**
 * Manage object data from file.
 * @param <T> Data type
 * @param <C> DataList type
 */
public interface ObjectsManager<T, C> {

    /**
     * @return return the actual
     */
    T getActual();

    /**
     * Update the actual.
     * @param delta udpate parameter
     */
    void update(NextAndPrevious delta);
}
