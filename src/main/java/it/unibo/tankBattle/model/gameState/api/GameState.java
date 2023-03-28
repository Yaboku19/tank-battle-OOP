package it.unibo.tankBattle.model.gameState.api;

import java.util.stream.Stream;

import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.model.gameSetup.impl.MapData;
/**
 * javadock.
 */
public interface GameState extends CommandListener {
    /**
     * javadock.
     * @param firstPlayer param
     * @param secondPlayer param
     * @param dataList param
     */
    void createWorld(Player firstPlayer, Player secondPlayer, MapData dataList);
    /**
     * javadock.
     * @param time param
     */
    void update(Double time);
    /**
     * javadock.
     * @return param
     */
    Stream<Transform> getBulletsTrasform();
    /**
     * javsdock.
     * @return param
     */
    Stream<Transform> getWallsTrasform();
    /**
     * javadock.
     * @param player param
     * @return return
     */
    Transform getTankTrasform(Player player);
    /**
     * javadock.
     * @param player param
     * @return return
     */
    int getTankLife(Player player);
}
