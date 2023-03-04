package it.unibo.tankBattle.model.world.api;

import it.unibo.tankBattle.common.input.api.Directions;
import java.util.Set;
import it.unibo.tankBattle.model.gameObject.api.GameObject;

public interface World {
    // getter tank, obstacles and bullet

    public void update();

    public void shot(int player);

    public void collision(GameObject firsGameObject, GameObject secondGameObject);

    public Set<GameObject> getEntities();

    public Set<GameObject> getWalls();

    public Set<GameObject> getBullets();

    public GameObject getFirstTank();

    public GameObject getSecondTank();

    public void buttonPressed(Directions direction, int player);

    public void buttonRelased(int player);
}
