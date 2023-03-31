package it.unibo.tankbattle.common.input.api;

import java.util.List;
import java.util.Optional;

/**
 * This interface represent an InputController that gets notified when an input occours.
 * @param <T> param
 */
public interface InputController<T> {

    /**
     * javadoc.
     * @return return
     * @param <T> param
     */
    List<T> getKeys();

    /**
     * javadoc.
     * @param <Command> param
     */

    Optional<Command> startCommand(T command);

    /**
     * javadoc.
     * @param <Command> param
     */
    Optional<Command> stopCommand(T command);
}
