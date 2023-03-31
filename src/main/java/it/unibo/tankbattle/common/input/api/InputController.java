package it.unibo.tankbattle.common.input.api;

import java.util.List;
import java.util.Optional;

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
    Optional<Command> startCommand(T command);
    /**
     * javadoc.
     */
    Optional<Command> stopCommand(T command);
}
