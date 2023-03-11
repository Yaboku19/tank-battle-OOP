package it.unibo.tankBattle.controller.api;

import java.util.Map;
import it.unibo.tankBattle.common.input.api.Command;
import it.unibo.tankBattle.common.input.api.InputController;
import it.unibo.tankBattle.model.gameState.api.Player;

public interface GameEngine {
    /**
     * It is called at the beginin by TankBattle.
     */
    public void play();
    
    public void startGame();

    public Map<Player, InputController> getControllers();

    public void notifyCommand(Player player, Command command);

    public void endgame();
}
