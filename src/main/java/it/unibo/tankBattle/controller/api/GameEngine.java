package it.unibo.tankBattle.controller.api;


public interface GameEngine {
    /**
     * It is called at the beginin by TankBattle.
     */
    public void play();
    
    public void startGame();

    //public Map<Player, InputController> getControllers();

    //public void notifyCommand(Player player, Command command);
}
