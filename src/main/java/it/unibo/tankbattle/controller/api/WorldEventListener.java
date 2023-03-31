package it.unibo.tankbattle.controller.api;

/**
 * the listener for the model.
 */
public interface WorldEventListener {

    /**
     * it is called when the game is over.
     * @param player the player how lose
     */
    void endGame(Player player);
}
