package it.unibo.tankBattle.controller.api;

import java.util.HashMap;
import it.unibo.tankBattle.common.input.api.InputController;
import it.unibo.tankBattle.model.gameState.api.Player;

public interface GameEngine {
    /**
     * It is called at the beginin by TankBattle.
     */
    public void play();
    /**
     * It is called by the view when the game start.
     */
    public void startGame();
    /**
     * I don't know.
     * @return Idem
     */
    public HashMap<Player, InputController> getControllers();
    /**
     * Called by the view, used to add a command in the command queue.
     * @param player Player that have this command
     * @param keyCode Type of command
     */
    public void notifyCommand(Player player, int keyCode);
    /**
     * Called but the gameState when the game is over.
     */
    public void endgame();
}
