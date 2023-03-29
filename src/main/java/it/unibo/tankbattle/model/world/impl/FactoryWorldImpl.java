package it.unibo.tankbattle.model.world.impl;

import java.util.HashSet;
import java.util.Set;

import it.unibo.tankbattle.common.P2d;
import it.unibo.tankbattle.controller.api.Player;
import it.unibo.tankbattle.model.gameSetup.impl.MapData;
import it.unibo.tankbattle.model.gameobject.api.object.FactoryGameObject;
import it.unibo.tankbattle.model.gameobject.api.object.GameObject;
import it.unibo.tankbattle.model.gameobject.impl.object.FactoryGameObjectImpl;
import it.unibo.tankbattle.model.world.api.FactoryWorld;
import it.unibo.tankbattle.model.world.api.World;
/**
 * javadock.
 */
public class FactoryWorldImpl implements FactoryWorld {
    private final FactoryGameObject factoryGO;
    private final double size;
    /**
     * javadock.
     */
    public FactoryWorldImpl() {
        factoryGO = new FactoryGameObjectImpl();
        this.size = factoryGO.getWallLength();
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public World simpleWorld(final Player firstPlayer, final Player secondPlayer, final MapData mapdata) {
        Set<GameObject> entities = getWall(mapdata.getWall());
        entities.add(factoryGO.createSimpleTank(
            position(mapdata.getPositionFirstTank().getX(), mapdata.getPositionFirstTank().getY()),
            firstPlayer));
        entities.add(factoryGO.createSimpleTank(
            position(mapdata.getPositionSecondTank().getX(), mapdata.getPositionSecondTank().getY()),
            secondPlayer));
        return new WorldImpl(entities.stream());
    }

    private Set<GameObject> getWall(final Set<P2d> wall) {
        Set<GameObject> border = new HashSet<>();
        for (var pos : wall) {
            border.add(factoryGO.createSimpleWall(position(pos.getX(), pos.getY())));
        }
        return border;
    }

    private P2d position(final double multiplier1, final double multiplier2) {
        return new P2d(multiplier1 * size + size / 2, multiplier2 * size + size / 2);
    }
}
