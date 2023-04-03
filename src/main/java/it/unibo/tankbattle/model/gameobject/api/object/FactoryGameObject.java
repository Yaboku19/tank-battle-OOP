package it.unibo.tankbattle.model.gameobject.api.object;

import it.unibo.tankbattle.common.P2d;
import it.unibo.tankbattle.controller.api.Player;

/**
 * Represents the factory that creates all the differents {@link GameObject}. 
 */
public interface FactoryGameObject {

    /**
     * Create a new tank, recognizable by the 
     * {@link it.unibo.tankbattle.model.gameobject.api.component.Component}
     * {@link it.unibo.tankbattle.model.gameobject.api.component.Tank}.
     * @param pos start {@link P2d} of the {@link GameObject}
     * @param player the associated {@link Player}
     * @return a new Tank {@link GameObject}
     */
    GameObject createSimpleTank(P2d pos, Player player);

    /**
     * Create a new bullet, recognizable by the 
     * {@link it.unibo.tankbattle.model.gameobject.api.component.Component}
     * {@link it.unibo.tankbattle.model.gameobject.api.component.Bullet}.
     * @param tank the {@link GameObject} that shoot the bullet
     * @return a new Bullet {@link GameObject}
     */
    GameObject createSimpleBullet(GameObject tank);

    /**
     * Create a new wall, recognizable by the 
     * {@link it.unibo.tankbattle.model.gameobject.api.component.Component}
     * {@link it.unibo.tankbattle.model.gameobject.api.component.Wall}.
     * @param pos the static {@link P2d} of the wall
     * @return a new Wall {@link GameObject}
     */
    GameObject createSimpleWall(P2d pos);

    /**
     * Get's the wall standard Length. 
     * @return the standard wall length
     */
    double getWallLength();

}
