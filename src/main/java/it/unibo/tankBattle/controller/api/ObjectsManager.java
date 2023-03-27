package it.unibo.tankBattle.controller.api;

import it.unibo.tankBattle.common.NextAndPrevious;

/**
 * Control the virus data. 
 */
public interface ObjectsManager<T, C> {

    T getActual();

    void update(NextAndPrevious delta);
}
