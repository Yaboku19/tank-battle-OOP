package it.unibo.tankbattle.common.input.api;

import java.util.List;

import it.unibo.tankbattle.controller.api.Player;

/**
 * This interface represent an InputController that gets notified when an input occours.
 */
public interface InputController<T> {
    /**
     * javadock.
     * @return return
     */
    List<T> getKeys();
    /**
     * javadoc.
     */
    Command startCommand(T command);
    /**
     * javadoc.
     */
    Command stopCommand(T command);
}
