package it.unibo.tankBattle.model.world.api;

import it.unibo.tankBattle.controller.api.Player;

public interface FactoryWorld {
    
    public World simpleWorld(Player firstPlayer, Player secondPlayer);
}
