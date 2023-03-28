package it.unibo.tankBattle.model.world.api;

import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.model.gameSetup.impl.MapData;
/**
 * javadock.
 */
public interface FactoryWorld {
    /**
     * javadock.
     * @param firstPlayer param
     * @param secondPlayer param
     * @param mapData param
     * @return return
     */
    World simpleWorld(Player firstPlayer, Player secondPlayer, MapData mapData);
}
