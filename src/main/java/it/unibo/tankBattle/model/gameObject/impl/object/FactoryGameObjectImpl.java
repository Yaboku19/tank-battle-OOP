package it.unibo.tankBattle.model.gameObject.impl.object;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.model.gameObject.api.object.FactoryGameObject;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public class FactoryGameObjectImpl implements FactoryGameObject{

    @Override
    public GameObject createSimpleTank(P2d pos) {
        return new BasicGameObject(new Transform(pos, null, 0, 0));
    }

    @Override
    public GameObject createSimpleBullet(GameObject tank) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createBullet'");
    }

    @Override
    public GameObject createSimpleWall(P2d pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createWall'");
    }


    
}
