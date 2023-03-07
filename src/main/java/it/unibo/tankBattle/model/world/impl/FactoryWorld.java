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
    private final static int SIZE = 3;
    private final static int STDSPEED = 1;
    private final static int STDHEALTH = 1000;
    private final static int STDDAMAGE = 1;
    private final GameState gameState;

    public FactoryWorld(final GameState gameState) {
        this.gameState = gameState;
        factory = new FactoryGameObject();
        border = new HashSet<>();
        for (int i = 0; i < ROW ; i++) {
            border.add(factory.simpleWall(new P2d(1, i * SIZE + 1)));
            border.add(factory.simpleWall(new P2d(COLUMN * SIZE + 1, i * SIZE + 1)));
        }
        for (int i = 0; i < COLUMN ; i++) {
            border.add(factory.simpleWall(new P2d(i * SIZE + 1, 1)));
            border.add(factory.simpleWall(new P2d(i * SIZE + 1, ROW * SIZE + 1)));
        }
    }

    public World simpleWorld(Player playerUno, Player playerDue) {
        GameObject tankOne = factory
            .simpleTank(STDSPEED, new P2d(4, 4), STDHEALTH, STDDAMAGE); // toDo
        GameObject tankTwo = factory
            .simpleTank(STDSPEED, new P2d((COLUMN - 1)* 3 + 1,(ROW - 1)* 3 + 1), STDHEALTH, STDDAMAGE);
        Map<Player, GameObject> tankMap = new HashMap<>();
        tankMap.put(playerUno, tankOne);
        tankMap.put(playerDue, tankTwo);
        return new WorldImpl(border, gameState, tankMap);
    }
}
