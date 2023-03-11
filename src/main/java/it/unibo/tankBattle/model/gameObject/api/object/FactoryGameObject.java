package it.unibo.tankBattle.model.gameObject.api.object;

import it.unibo.tankBattle.common.P2d;

public interface FactoryGameObject {
    
    public GameObject createSimpleTank(P2d pos);

    public GameObject createSimpleBullet(GameObject tank);

    public GameObject createSimpleWall(P2d pos);

}
