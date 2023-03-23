package it.unibo.tankBattle.controller.api;

import java.io.File;
import java.util.List;
import java.util.Map;

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
