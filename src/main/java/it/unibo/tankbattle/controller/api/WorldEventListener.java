package it.unibo.tankbattle.controller.api;

/**
 * The listener for the model.
 */
public interface WorldEventListener {

    /**
     * It is called when the game is over.
     * @param player the player who lose
     */
    void endGame(Player player);
}
