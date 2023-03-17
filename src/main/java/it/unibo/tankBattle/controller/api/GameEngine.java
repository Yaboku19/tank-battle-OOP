package it.unibo.tankBattle.controller.api;

import java.util.Set;

import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.common.input.api.Command;

public interface GameEngine extends Runnable{
    /**
     * It is called at the beginin by TankBattle.
     */
    public void play();
    
    public void startGame();

    public void notifyCommand(Command command);

    public Player getFirstPlayer();

    public Player getSecondPlayer();

    public Set<Transform> getTankTransform();
}
