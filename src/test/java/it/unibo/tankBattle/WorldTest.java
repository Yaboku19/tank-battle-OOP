package it.unibo.tankBattle;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.stream.Collectors;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.controller.impl.BasicGameEngine;
import it.unibo.tankBattle.model.gameState.api.GameState;
import it.unibo.tankBattle.model.gameState.impl.GameStateImpl;
import it.unibo.tankBattle.model.world.api.World;
import it.unibo.tankBattle.model.world.impl.FactoryWorldImpl;

public class WorldTest {
	/*private FactoryWorldImpl factoryWorld;
    private World world;
    private GameState gameState;
    private int size;
    private FactoryGameObject factoryGameObject;

    @org.junit.jupiter.api.BeforeEach       
	public void initFactory() {
        gameState = new GameStateImpl(new BasicGameEngine());
		factoryWorld = new FactoryWorldImpl(gameState);
        world = factoryWorld.simpleWorld(gameState.getFirstPlayer(), gameState.getSecondPlayer());
        factoryGameObject = new FactoryGameObject();
        size = factoryGameObject.simpleWall(new P2d(0, 0)).getLength();
    }

    @org.junit.jupiter.api.Test            
	public void getterTest() {        
        var entities = world.getBullets();
    
        entities.addAll(world.getWalls());
        entities.add(world.getTank(gameState.getFirstPlayer()));
        entities.add(world.getTank(gameState.getSecondPlayer()));

		assertEquals(entities.stream().map(g -> g.getPosition()).collect(Collectors.toSet()),
			world.getEntities().stream().map(g -> g.getPosition()).collect(Collectors.toSet()));
	}

    @org.junit.jupiter.api.Test
    public void shotTest() {

        assertEquals(new HashSet<GameObject>(), world.getBullets());

        world.shot(gameState.getFirstPlayer());
        assertEquals(1, world.getBullets().size());

    }

    @org.junit.jupiter.api.Test
    public void UpdateTest() {

        assertTrue(world
            .getTank(gameState.getFirstPlayer())
            .getPosition()
            .equals(new P2d(size + size /2, size + size / 2)));

        world.setDirection(Directions.RIGHT, gameState.getFirstPlayer());
        world.update();

        assertFalse(world
            .getTank(gameState.getFirstPlayer())
            .getPosition()
            .equals(new P2d(size + size /2, size + size / 2)));

        assertTrue(world
            .getTank(gameState.getFirstPlayer())
            .getPosition()
            .equals(new P2d(size + size / 2 + 1, size + size / 2)));

        assertTrue(world
            .getTank(gameState.getSecondPlayer())
            .getPosition()
            .equals(new P2d(13 * size + size /2, 8 * size + size / 2)));

        world.setDirection(Directions.NONE, gameState.getFirstPlayer());

        world.update();

        assertTrue(world
            .getTank(gameState.getFirstPlayer())
            .getPosition()
            .equals(new P2d(size + size / 2 + 1, size + size / 2)));

        assertTrue(world
            .getTank(gameState.getSecondPlayer())
            .getPosition()
            .equals(new P2d(13 * size + size /2, 8 * size + size / 2)));
    }

    @org.junit.jupiter.api.Test
    public void collisionTest() {
        world.setDirection(Directions.LEFT, gameState.getFirstPlayer());
        world.update();

        assertTrue(world
            .getTank(gameState.getFirstPlayer())
            .getPosition()
            .equals(new P2d(size + size / 2 - 1, size + size / 2)));

        var wall = world.getWalls()
            .stream()
            .filter(w -> w.getPosition().equals(new P2d(size / 2, size + size / 2)))
            .toList()
            .get(0);

        world.collision(wall.getPosition(), new P2d(size + size / 2 - 1, size + size / 2));

        assertTrue(world
            .getTank(gameState.getFirstPlayer())
            .getPosition()
            .equals(new P2d(size + size / 2, size + size / 2)));

    }

    @org.junit.jupiter.api.Test
    public void removeTest() {
        world.setDirection(Directions.RIGHT, gameState.getFirstPlayer());
        world.shot(gameState.getFirstPlayer());
        world.update();

        assertTrue(world
            .getTank(gameState.getFirstPlayer())
            .getPosition()
            .equals(new P2d(size + size / 2 + 1, size + size / 2)));

        var bullet = world.getBullets()
            .stream()
            .toList()
            .get(0);

        int life = world.getTank(gameState.getFirstPlayer())
            .getLifePoints();

        world.collision(new P2d(size + size / 2 + 1, size + size / 2), bullet.getPosition());
        world.update();
        assertEquals(0, world.getBullets().size());
        assertEquals(life - bullet.getDamage(), world.getTank(gameState.getFirstPlayer()).getLifePoints());
        }*/
}

