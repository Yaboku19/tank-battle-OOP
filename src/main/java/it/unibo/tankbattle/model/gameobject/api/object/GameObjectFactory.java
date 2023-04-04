package it.unibo.tankbattle.model.gameobject.api.object;

import it.unibo.tankbattle.common.Point2d;
import it.unibo.tankbattle.controller.api.Player;

/**
 * Represents the factory that creates all the differents {@link GameObject}. 
 */
public interface GameObjectFactory {

    /**
     * Creates a new tank, recognizable by the 
     * {@link it.unibo.tankbattle.model.gameobject.api.component.Component Component}
     * {@link it.unibo.tankbattle.model.gameobject.api.component.Tank Tank}.
     * @param pos start {@link Point2d} of the {@link GameObject}
     * @param player the associated {@link Player}
     * @return a new Tank {@link GameObject}
     */
    GameObject createSimpleTank(Point2d pos, Player player);

    /**
     * Creates a new bullet, recognizable by the 
     * {@link it.unibo.tankbattle.model.gameobject.api.component.Component Component}
     * {@link it.unibo.tankbattle.model.gameobject.api.component.Bullet Bullet}.
     * @param tank the {@link GameObject} that shoot the bullet
     * @return a new Bullet {@link GameObject}
     */
    GameObject createSimpleBullet(GameObject tank);

    /**
     * Creates a new wall, recognizable by the 
     * {@link it.unibo.tankbattle.model.gameobject.api.component.Component Component}
     * {@link it.unibo.tankbattle.model.gameobject.api.component.Wall Wall}.
     * @param pos the static {@link Point2d} of the wall
     * @return a new Wall {@link GameObject}
     */
    GameObject createSimpleWall(Point2d pos);

    /**
     * Gets wall standard Length. 
     * @return the standard wall length
     */
    double getWallLength();

}
