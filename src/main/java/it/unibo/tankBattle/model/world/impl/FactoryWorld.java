package it.unibo.tankBattle.model.world.impl;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.model.world.api.World;
import it.unibo.tankBattle.model.gameObject.api.object.FactoryGameObject;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;
import it.unibo.tankBattle.model.gameObject.impl.object.FactoryGameObjectImpl;
import it.unibo.tankBattle.model.gameState.api.GameState;
import it.unibo.tankBattle.model.gameState.api.Player;


public class FactoryWorld {
    private final Set<GameObject> border;
    private final FactoryGameObject factory;
    private final static int ROW = 9;
    private final static int COLUMN = 14;
    //private final int size;
    private final GameState gameState;

    public FactoryWorld(final GameState gameState) {
        this.gameState = gameState;
        factory = new FactoryGameObjectImpl();
        border = new HashSet<>();
        //size = factory.createSimpleWall(new P2d(0, 0)).getLength(); // toDo
        for (int i = 0; i < ROW ; i++) {
            border.add(factory.createSimpleWall(new P2d(getPosition(0), getPosition(i))));
            border.add(factory.createSimpleWall(new P2d(getPosition(COLUMN), getPosition(i))));
        }
        for (int i = 0; i < COLUMN ; i++) {
            border.add(factory.createSimpleWall(new P2d(getPosition(i) , getPosition(0))));
            border.add(factory.createSimpleWall(new P2d(getPosition(i), getPosition(ROW))));
        }
    }

    public World simpleWorld(final Player playerUno, final Player playerDue) {
        final GameObject tankOne = factory
            .createSimpleTank(new P2d(getPosition(1), getPosition(1)));

        final GameObject tankTwo = factory
            .createSimpleTank(new P2d(getPosition(COLUMN - 1), getPosition(ROW - 1)));

        final Map<Player, GameObject> tankMap = new HashMap<>();
        tankMap.put(playerUno, tankOne);
        tankMap.put(playerDue, tankTwo);
        return new WorldImpl(border, gameState, tankMap);
    }

    private int getPosition(final int i) {
        return i; //size * i + size / 2;
    }
}
