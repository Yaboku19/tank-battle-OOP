package it.unibo.tankBattle.controller.api;

import java.util.HashMap;

import it.unibo.tankBattle.common.input.api.Command;
import it.unibo.tankBattle.common.input.api.InputController;
import it.unibo.tankBattle.model.gameState.api.Player;

public interface GameEngine {
    public void play();

    public void processInput();
    
    public void startGame();

    public HashMap<Player, InputController> getControllers();

    public void notifyCommand(Player player, Command command);

    public void endgame();
}
