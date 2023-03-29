package it.unibo.tankbattle.common.input.api;

import java.util.List;

/**
 * This interface represent an InputController that gets notified when an input occours.
 */
public interface InputController {
    /**
     * javadock.
     * @return return
     */
    List<Integer> getKeyCodes();
}
