package it.unibo.tankBattle.model.gameState.api;

import java.util.stream.Stream;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public interface GameState {

    public void createWorld();

    public void update(Double time);

    public void shot(Player player);

    public void setDirection(Directions direction, Player player);

    public Stream<GameObject> getTanks();

    public Stream<GameObject> getBullets();

    public Stream<GameObject> getWalls();

    public Player getFirstPlayer();

    public Player getSecondPlayer();
}
