package it.unibo.tankbattle.model.world.api;

import it.unibo.tankbattle.controller.api.Player;
import it.unibo.tankbattle.model.gamesetup.impl.MapData;

/**
 * rappresent the factory of {@link World} .
 */
public interface FactoryWorld {

    /**
     * create a new World.
     * @param firstPlayer player for the first tank
     * @param secondPlayer player for the second tank
     * @param mapData data for the settings of the map
     * @return the new World
     */
    World simpleWorld(Player firstPlayer, Player secondPlayer, MapData mapData);
}
