package it.unibo.tankbattle.model.world.impl;

import java.util.HashSet;
import java.util.Set;
import it.unibo.tankbattle.common.Point2d;
import it.unibo.tankbattle.controller.api.Player;
import it.unibo.tankbattle.model.gameobject.api.object.GameObjectFactory;
import it.unibo.tankbattle.model.gameobject.api.object.GameObject;
import it.unibo.tankbattle.model.gameobject.impl.object.GameObjectFactoryImpl;
import it.unibo.tankbattle.model.gamesetup.impl.MapData;
import it.unibo.tankbattle.model.world.api.WorldFactory;
import it.unibo.tankbattle.model.world.api.World;

/**
 * An implementention of {@link WorldFactory}.
 */
public class WorldFactoryImpl implements WorldFactory {
    private final GameObjectFactory factoryGO;
    private final double size;

    /**
     * The constructor of {@link WorldFactory} with no arguments.
     */
    public WorldFactoryImpl() {
        factoryGO = new GameObjectFactoryImpl();
        this.size = factoryGO.getWallLength();
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public World simpleWorld(final Player firstPlayer, final Player secondPlayer, final MapData mapdata) {
        final Set<GameObject> entities = getWall(mapdata.getWall());
        entities.add(factoryGO.createSimpleTank(
            position(mapdata.getPositionFirstTank().getX(), mapdata.getPositionFirstTank().getY()),
            firstPlayer));
        entities.add(factoryGO.createSimpleTank(
            position(mapdata.getPositionSecondTank().getX(), mapdata.getPositionSecondTank().getY()),
            secondPlayer));
        return new WorldImpl(entities.stream());
    }

    private Set<GameObject> getWall(final Set<Point2d> wall) {
        final Set<GameObject> border = new HashSet<>();
        for (final var pos : wall) {
            border.add(factoryGO.createSimpleWall(position(pos.getX(), pos.getY())));
        }
        return border;
    }

    private Point2d position(final double multiplier1, final double multiplier2) {
        return new Point2d(multiplier1 * size + size / 2, multiplier2 * size + size / 2);
    }
}
