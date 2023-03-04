package it.unibo.tankBattle.controller.api;
import it.unibo.tankBattle.common.input.api.Command;

public interface GameEngine {
    public void play();

    public void processInput();

    public void initGame();
    
    public void startGame();

    public void notifyCommand(int keyCode);
}
