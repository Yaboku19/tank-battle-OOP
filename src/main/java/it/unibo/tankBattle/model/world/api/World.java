package it.unibo.tankBattle.model.world.api;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.Player;
import it.unibo.tankBattle.common.input.api.Directions;
import java.util.Set;
import it.unibo.tankBattle.model.gameObject.api.GameObject;

public interface World {

    public void update();

    public void shot(Player player);

    public void collision(P2d firsGameObject, P2d secondGameObject);

    public Set<GameObject> getEntities();

    public Set<GameObject> getWalls();

    public Set<GameObject> getBullets();

    public Set<GameObject> getTanks();

    public void setDirection(Directions direction, Player player);
}
