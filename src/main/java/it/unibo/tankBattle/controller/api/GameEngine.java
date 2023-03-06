package it.unibo.tankBattle.controller.api;

import java.util.HashMap;

import it.unibo.tankBattle.common.input.api.InputController;

public interface GameEngine {
    public void play();

    public void processInput();

    public void initGame();
    
    public void startGame();

    public HashMap<String, InputController> getControllers();

    public void notifyCommand(int keyCode);
}
