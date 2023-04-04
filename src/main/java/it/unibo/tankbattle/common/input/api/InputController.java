package it.unibo.tankbattle.common.input.api;

import java.util.List;
import java.util.Optional;

/**
 * This interface represent an InputController that gets notified when an input occours.
 * @param <T> param
 */
public interface InputController<T> {

    /**
     * @return key list of controller.
     */
    List<T> getKeys();

    /**
     * Start command passed.
     * @param command start command
     * @return Optional of the new command created
     */

    Optional<Command> startCommand(T command);

    /**
     * Stop command passed.
     * @param command stop command
     * @return Optional of the new command created
     */
    Optional<Command> stopCommand(T command);
}
