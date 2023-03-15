package it.unibo.tankBattle.controller.api;

import it.unibo.tankBattle.common.input.api.Command;

public interface GameEngine {
    /**
     * It is called at the beginin by TankBattle.
     */
    public void play();
    
    public void startGame();

    //public Map<Player, InputController> getControllers();

    public void notifyCommand(Player player, Command command);

    public Player getFirstPlayer();

    public Player getSecondPlayer();
}
