package it.unibo.tankBattle.model.gameState.api;

import it.unibo.tankBattle.common.input.api.Direction;
import it.unibo.tankBattle.controller.api.Player;

public interface CommandListener {
    public void shot(Player player);

    public void setDirection(Direction direction, Player player);
}
