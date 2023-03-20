package it.unibo.tankBattle.model.gameState.api;

import java.util.stream.Stream;

import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.controller.api.Player;

public interface GameState extends CommandListener{

    public void createWorld(Player firstPlayer, Player secondPlayer);

    public void update(Double time);

    public Stream<Transform> getBulletsTrasform();

    public Stream<Transform> getWallsTrasform();

    public Transform getTankTrasform(final Player player);
}
