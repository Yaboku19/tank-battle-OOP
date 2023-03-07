package it.unibo.tankBattle.model.gameState.api;

import java.util.Set;
import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.Pair;
import it.unibo.tankBattle.common.input.api.Directions;
/**
 * Classe that is the middle between the GameEngine (Controller) and the World.
 */
public interface GameState {
    /**
     * Give the input to thw world to update.
     */
    public void update();
    /**
     * Choose how the method of world have to be called for all the events. 
     * @param events A set of events
     */
    public void resolveEvents(Set<Pair<P2d, P2d>> events);
    /**
     * It is called by the world when a tank is dead.
     * @param player the Player that own the tank
     */
    public void endGame(Player player);
    /**
     * Used by the controller to send the inputCommand.
     */
    public void input();

    /**
     * 
     * This method get each object's and return it's position and length in order to share
     * less information to manage collision.
     * 
     * @return a set of pair of each object's position and length
     */
    public Set<Pair<P2d, Integer>> getPositionsAndLength();
    /**
     * Return the position of all the walls used for the view.
     * @return a set of position
     */
    public Set<P2d> getWallPositions();
    /**
     * Return the position and the direction of all the bullets used for the view.
     * @return a set of position and directions
     */
    public Set<Pair<P2d, Directions>> getBulletPositionsAndDirection();
    /**
     * Return the position and the direction of a tank indentified by a player.
     * @param player the player
     * @return the position and the direction
     */
    public Pair<P2d, Directions> getTankPositionAndDirection(Player player);
    /**
     * Return the first Player.
     * @return the Player
     */
    public Player getFirstPlayer();
    /**
     * Return the second Player.
     * @return the player
     */
    public Player getSecondPlayer();
    /**
     * Return the score of the two player.
     * @return the score
     */
    public Pair<Integer, Integer> getScore(); //0-0 1-0
}
