package it.unibo.tankBattle.model.gameState.api;

import java.util.stream.Stream;

import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public interface GameState extends CommandListener{

    public void createWorld(Player firstPlayer, Player secondPlayer);

    public void update(Double time);

    public Stream<GameObject> getTanks();

    public Stream<Transform> getBullets();

    public Stream<Transform> getWalls();

    public GameObject getTankFromPlayer(final Player player);
}
