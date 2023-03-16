package it.unibo.tankBattle.controller.api;

import it.unibo.tankBattle.common.input.api.Command;
import it.unibo.tankBattle.model.gameState.api.GameState;

public interface GameEngine extends Runnable{
    /**
     * It is called at the beginin by TankBattle.
     */
    public void play();
    
    public void startGame();

    public void notifyCommand(Command command);

    public Player getFirstPlayer();

    public Player getSecondPlayer();
}
