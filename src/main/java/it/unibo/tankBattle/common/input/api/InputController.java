package it.unibo.tankBattle.common.input.api;

import java.util.List;
import java.util.Queue;

/**
 * This interface represent an InutController that gets notified when an input
 * occours.
 */
public interface InputController {
    /**
     * Return the queue of commands to be executed.
     * 
     * @return the commands queue
     */
    //Queue<Command> getCommands();


    public List<Integer> getKeyCodes();
}
