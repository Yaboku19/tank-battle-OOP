package it.unibo.tankbattle.model.gameObject.api.object;

import it.unibo.tankbattle.common.P2d;
import it.unibo.tankbattle.controller.api.Player;
/**
 * javadoc.
 */
public interface FactoryGameObject {
    /**
     * javadoc.
     * @param pos param
     * @param player param
     * @return return
     */
    GameObject createSimpleTank(P2d pos, Player player);
    /**
     * javadoc.
     * @param tank param
     * @return return
     */
    GameObject createSimpleBullet(GameObject tank);
    /**
     * javadoc.
     * @param pos param
     * @return return
     */
    GameObject createSimpleWall(P2d pos);
    /**
     * javadoc.
     * @return return
     */
    double getWallLength();

}
