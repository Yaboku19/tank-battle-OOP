package it.unibo.tankBattle.model.world.api;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;
import java.util.Set;
import it.unibo.tankBattle.model.gameObject.api.GameObject;
import it.unibo.tankBattle.model.gameState.api.Player;
/**
 * The classe where are saved all the GameObject of the Map.
 */
public interface World {
    /**
     *  method used for the update of all gameObject in World.
     */
    public void update();
    /**
     * method for manage the collision between two GameObject.
     * @param firsGameObject first GameObject
     * @param secondGameObject secon GameObject
     */
    public void collision(P2d firsGameObject, P2d secondGameObject);
    /**
     * return all the GameObject in World.
     * @return all the GameObject
     */
    public Set<GameObject> getEntities();
    /**
     * return all GameObject that are Walls.
     * @return walls
     */
    public Set<GameObject> getWalls();
    /**
     * return all GameObject that are Bullets.
     * @return bullets
     */
    public Set<GameObject> getBullets();
    /**
     * return a tank using a paramather Player.
     * @param player used for identify the tank
     * @return the tank
     */
    public GameObject getTank(Player player);
    /**
     * method that give the command to shot at a tank.
     * @param player used for identify the tank
     */
    public void shot(Player player);
    /**
     * method that give the command to change their direction, used for the movement,
     *  in particular when the direction is NONE the tank will not move.
     * @param direction direction that will be set in tank
     * @param player used for identify the tank
     */
    public void setDirection(Directions direction, Player player);
}
