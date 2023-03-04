package it.unibo.tankBattle.model.world.api;

import it.unibo.tankBattle.common.input.api.Directions;
import java.util.Set;
import it.unibo.tankBattle.model.gameObject.api.GameObject;

public interface World {
    // getter tank, obstacles and bullet

    public void update();

    public void addBullet(GameObject tank);

    public void collision(GameObject firsGameObject, GameObject secondGameObject);

    public Set<GameObject> getEntities();

    public Set<GameObject> getWalls();

    public Set<GameObject> getBullets();

    public GameObject firstTank();

    public GameObject secondTank();

    public void changeDirection(Directions direction, int player);
}
