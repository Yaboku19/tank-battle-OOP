package it.unibo.tankbattle.model.gamestate.api;

import java.util.stream.Stream;
import it.unibo.tankbattle.common.Transform;
import it.unibo.tankbattle.controller.api.Player;
import it.unibo.tankbattle.model.gamesetup.impl.MapData;

/**
 * rappresent the interface of the model.
 */
public interface GameState extends CommandListener {

    /**
     * create a World with the following paramether.
     * @param firstPlayer the first player
     * @param secondPlayer the second player
     * @param dataList the data for the map
     */
    void createWorld(Player firstPlayer, Player secondPlayer, MapData dataList);

    /**
     * give the GameObject to update.
     * @param time indicates how much the GameObject have to be updated
     */
    void update(Double time);

    /**
     * 
     * @return return a Stream {@link Stream} of Trasform {@link Transform} of Bullets
     */
    Stream<Transform> getBulletsTrasform();

    /**
     * 
     * @return return a Stream {@link Stream} of Trasform {@link Transform} of Walls
     */
    Stream<Transform> getWallsTrasform();

    /**
     * 
     * @param player used to identify the tank
     * @return return the {@link Transform} of a tank
     */
    Transform getTankTrasform(Player player);

    /**
     * return the life of a tank.
     * @param player used to identify the tank
     * @return return
     */
    int getTankLife(Player player);

    /**
     * returns the score of the given player.
     * @param player the player
     * @return the score
     */
    int getScore(Player player);
}
