package it.unibo.tankBattle.model.gameObject.api.object;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.controller.api.Player;

public interface FactoryGameObject {
    
    public GameObject createSimpleTank(final P2d pos, final Player player);

    public GameObject createSimpleBullet(final GameObject tank);

    public GameObject createSimpleWall(final P2d pos);

    public double getWallLength();

}
