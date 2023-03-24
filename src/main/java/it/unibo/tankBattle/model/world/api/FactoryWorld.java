package it.unibo.tankBattle.model.world.api;

import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.model.gameSetup.impl.MapData;

public interface FactoryWorld {
    
    public World simpleWorld(Player firstPlayer, Player secondPlayer, MapData mapData);
}
