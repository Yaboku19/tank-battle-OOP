package it.unibo.tankBattle.common.input.api;

import java.util.List;

/**
 * This interface represent an InputController that gets notified when an input
 * occours.
 */
public interface InputController{
    
    public List<T> getKeyCodes();
}
