package it.unibo.tankBattle.model.gameState.api;

import java.util.Set;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.Pair;

public interface GameState {

    public Pair<Integer, Integer> getScore(); //0-0 1-0

    public void update();

    public void resolveEvents(Set<Pair<P2d, P2d>> events);

    public void isOver(); 

    public Set<Pair<P2d, Integer>> getPositionsAndLenght();

    public void input();
}
