package it.unibo.tankBattle.model.world.impl;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.model.world.api.World;
import it.unibo.tankBattle.model.gameObject.api.GameObject;
import it.unibo.tankBattle.model.gameObject.impl.FactoryGameObject;
import it.unibo.tankBattle.model.gameState.api.GameState;
import it.unibo.tankBattle.model.gameState.api.Player;


public class FactoryWorld {
    private final Set<GameObject> border;
    private final FactoryGameObject factory;
    private final static int ROW = 9;
    private final static int COLUMN = 14;
    private final int size;
    private final GameState gameState;

    public FactoryWorld(final GameState gameState) {
        this.gameState = gameState;
        factory = new FactoryGameObject();
        border = new HashSet<>();
        size = factory.simpleWall(new P2d(0, 0)).getLength();
        for (int i = 0; i < ROW ; i++) {
            border.add(factory.simpleWall(new P2d(getPosition(0), getPosition(i))));
            border.add(factory.simpleWall(new P2d(getPosition(COLUMN), getPosition(i))));
        }
        for (int i = 0; i < COLUMN ; i++) {
            border.add(factory.simpleWall(new P2d(getPosition(i) , getPosition(0))));
            border.add(factory.simpleWall(new P2d(getPosition(i), getPosition(ROW))));
        }
    }

    public World simpleWorld(Player playerUno, Player playerDue) {
        GameObject tankOne = factory
            .standardTank(new P2d(getPosition(1), getPosition(1))); // toDo

        GameObject tankTwo = factory
            .standardTank(new P2d(getPosition(COLUMN - 1), getPosition(ROW - 1)));

        Map<Player, GameObject> tankMap = new HashMap<>();
        tankMap.put(playerUno, tankOne);
        tankMap.put(playerDue, tankTwo);
        return new WorldImpl(border, gameState, tankMap);
    }

    private int getPosition(int i) {
        return size * i + size / 2;
    }
}
