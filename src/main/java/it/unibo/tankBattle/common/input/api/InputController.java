package it.unibo.tankBattle.common.input.api;

import java.util.List;

/**
 * This interface represent an InutController that gets notified when an input
 * occours.
 */
public interface InputController <T>{
    
    public List<T> getKeyCodes();
}
