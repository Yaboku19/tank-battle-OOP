package it.unibo.tankBattle.model.gameState.api;

import java.util.Set;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.Pair;
import it.unibo.tankBattle.model.gameState.impl.Player;

public interface GameState {

    public Pair<Integer, Integer> getScore(); //0-0 1-0

    public void update();

    public void resolveEvents(Set<Pair<P2d, P2d>> events);

    public void isOver(Player player); 

    /**
     * 
     * This method get each object's and return it's position and length in order to share
     * less information to manage collision
     * 
     * @return a set of pair of each object's position and length
     */
    public Set<Pair<P2d, Integer>> getPositionsAndLength();

    public void input();

    public Player getFirstPlayer();

    public Player getSecondPlayer();
}
