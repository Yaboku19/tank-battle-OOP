package it.unibo.tankBattle.controller.api;

public interface GameEngine {
    public void play();

    public void processInput();

    public void initGame();
    
    public void startGame();

    public void notifyCommand(int keyCode);
}
