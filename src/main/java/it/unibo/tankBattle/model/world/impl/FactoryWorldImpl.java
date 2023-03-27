package it.unibo.tankBattle.model.world.impl;

import java.util.HashSet;
import java.util.Set;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.model.gameObject.api.object.FactoryGameObject;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;
import it.unibo.tankBattle.model.gameObject.impl.object.FactoryGameObjectImpl;
import it.unibo.tankBattle.model.gameSetup.impl.MapData;
import it.unibo.tankBattle.model.world.api.FactoryWorld;
import it.unibo.tankBattle.model.world.api.World;

public class FactoryWorldImpl implements FactoryWorld {
    private final FactoryGameObject factoryGO;
    private final double size;

    public FactoryWorldImpl() {
        factoryGO = new FactoryGameObjectImpl();
        this.size = factoryGO.getWallLength();
    }

    @Override
    public World simpleWorld(final Player firstPlayer, final Player secondPlayer, final MapData mapdata) {
        Set<GameObject> entities = getWall(mapdata.getWall());
        entities.add(factoryGO.createSimpleTank(
            position(mapdata.getPositionFirstTank().getX(),mapdata.getPositionFirstTank().getY())
            , firstPlayer));
        entities.add(factoryGO.createSimpleTank(
            position(mapdata.getPositionSecondTank().getX(),mapdata.getPositionSecondTank().getY())
            , secondPlayer));
        return new WorldImpl(entities.stream());
    }

    private Set<GameObject> getWall(final Set<P2d> wall) {
        Set<GameObject> border = new HashSet<>();
        for (var pos : wall) {
            border.add(factoryGO.createSimpleWall(position(pos.getX(), pos.getY())));
        }
        return border;
    }
    
    private P2d position(double multiplier1, double multiplier2) {
        return new P2d(multiplier1 * size + size / 2, multiplier2 * size + size / 2);
    }
}
