package it.unibo.tankbattle.model.world.api;

import it.unibo.tankbattle.controller.api.Player;
import it.unibo.tankbattle.model.gamesetup.impl.MapData;
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
