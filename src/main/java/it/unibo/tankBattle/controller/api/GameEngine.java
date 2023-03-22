package it.unibo.tankBattle.controller.api;

import it.unibo.tankBattle.common.input.api.Command;

public interface GameEngine extends Runnable{
    
    public void startGame();

    public void notifyCommand(Command command);

    public Player getFirstPlayer();

    public Player getSecondPlayer();
}
