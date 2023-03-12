package it.unibo.tankBattle.model.world.api;

import it.unibo.tankBattle.model.gameState.api.Player;

public interface FactoryWorld {
    
    public World simpleWorld(Player firstPlayer, Player secondPlayer);
}
