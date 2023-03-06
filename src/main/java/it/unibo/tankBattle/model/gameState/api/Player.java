package it.unibo.tankBattle.model.gameState.api;
/**
 * The class that identify the player.
 */
public interface Player {
    /**
     * Return the score of the player.
     * @return the score
     */
    public int getScore();
    /**
     * Add one to the sscore.
     */
    public void incScore();
}
