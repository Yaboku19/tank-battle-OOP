package it.unibo.tankBattle.model.world.impl;

import java.util.HashSet;
import java.util.Set;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.model.gameObject.api.object.FactoryGameObject;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;
import it.unibo.tankBattle.model.gameObject.impl.object.FactoryGameObjectImpl;
import it.unibo.tankBattle.model.world.api.FactoryWorld;
import it.unibo.tankBattle.model.world.api.World;

public class FactoryWorldImpl implements FactoryWorld {
    private final FactoryGameObject factoryGO;
    private static final int ROW = 9;
    private static final int COLUMN = 14;
    private final double size;

    public FactoryWorldImpl() {
        factoryGO = new FactoryGameObjectImpl();
        this.size = factoryGO.getWallLength();
    }

    @Override
    public World simpleWorld(final Player firstPlayer, final Player secondPlayer) {
        Set<GameObject> entities = getBorder();
        entities.add(factoryGO.createSimpleTank(position(2,2), firstPlayer));
        entities.add(factoryGO.createSimpleTank(position(COLUMN - 2, ROW - 2), secondPlayer));
        return new WorldImpl(entities.stream());
    }

    private Set<GameObject> getBorder() {
        Set<GameObject> border = new HashSet<>();
        for(int i = 0; i <= ROW; i++) {
            border.add(factoryGO.createSimpleWall(position(0, i)));
            border.add(factoryGO.createSimpleWall(position(COLUMN, i)));
        }
        for(int i = 1; i < COLUMN; i++) {
            border.add(factoryGO.createSimpleWall(position(i, 0)));
            border.add(factoryGO.createSimpleWall(position(i, ROW)));
        }
        return border;
    }
    
    private P2d position(int multiplier1, int multiplier2) {
        return new P2d(multiplier1 * size + size / 2, multiplier2 * size + size / 2);
    }
}
