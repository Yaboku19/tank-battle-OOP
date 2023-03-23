package it.unibo.tankBattle.controller.api;


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

    void next();

    void previous();


}
