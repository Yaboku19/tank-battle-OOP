package it.unibo.tankBattle.model.gameState.api;

import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.controller.api.Player;

public interface CommandListener {
    public void shot(Player player);

    public void setDirection(Directions direction, Player player);
}
