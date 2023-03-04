package it.unibo.tankBattle.model.world;

import java.util.HashSet;
import java.util.Set;

import it.unibo.tankBattle.model.api.World;
import it.unibo.tankBattle.model.gameObject.api.GameObject;

public class WorldImpl implements World {
    private final Set<GameObject> wallSet;
    private final Set<GameObject> BulletSet;
    private final GameObject tankPlayerOne;
    private final GameObject tankPlayerTwo;

    protected WorldImpl(final Set<GameObject> wallSet, final GameObject tankOne, final GameObject tankTwo) {
        this.wallSet = new HashSet<>(wallSet);
        this.BulletSet = new HashSet<>();
        tankPlayerOne = tankOne;
        tankPlayerTwo = tankTwo;
    }
    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void addBullet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addBullet'");
    }

    @Override
    public void collision() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'collision'");
    }

    @Override
    public void bulletHitTank() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bulletHitTank'");
    }

    @Override
    public void bulletHitOther() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bulletHitOther'");
    }
    @Override
    public Set<GameObject> getEntities() {
        var entities = new HashSet<>(wallSet);
        entities.addAll(BulletSet);
        entities.add(tankPlayerOne);
        entities.add(tankPlayerTwo);
        return entities;
    }
    
}
