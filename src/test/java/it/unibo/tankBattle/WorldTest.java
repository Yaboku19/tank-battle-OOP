package it.unibo.tankBattle;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.stream.Collectors;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.controller.impl.BasicGameEngine;
import it.unibo.tankBattle.model.gameObject.api.GameObject;
import it.unibo.tankBattle.model.gameState.api.GameState;
import it.unibo.tankBattle.model.gameState.impl.GameStateImpl;
import it.unibo.tankBattle.model.world.api.World;
import it.unibo.tankBattle.model.world.impl.FactoryWorld;

public class WorldTest {
	private FactoryWorld factoryWorld;
    private World world;
    private GameState gameState;

    @org.junit.jupiter.api.BeforeEach       
	public void initFactory() {
        gameState = new GameStateImpl(new BasicGameEngine());
		factoryWorld = new FactoryWorld(gameState);
        world = factoryWorld.simpleWorld(gameState.getFirstPlayer(), gameState.getSecondPlayer());
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
            .equals(new P2d(4, 4)));

        world.setDirection(Directions.RIGHT, gameState.getFirstPlayer());
        world.update();

        assertFalse(world
            .getTank(gameState.getFirstPlayer())
            .getPosition()
            .equals(new P2d(4, 4)));

        assertTrue(world
            .getTank(gameState.getFirstPlayer())
            .getPosition()
            .equals(new P2d(5, 4)));

        assertTrue(world
            .getTank(gameState.getSecondPlayer())
            .getPosition()
            .equals(new P2d(13 * 3 + 1, 8 * 3 + 1)));

        world.setDirection(Directions.NONE, gameState.getFirstPlayer());

        world.update();

        assertTrue(world
            .getTank(gameState.getFirstPlayer())
            .getPosition()
            .equals(new P2d(5, 4)));

        assertTrue(world
            .getTank(gameState.getSecondPlayer())
            .getPosition()
            .equals(new P2d(13 * 3 + 1, 8 * 3 + 1)));

    }

    @org.junit.jupiter.api.Test
    public void collisionTest() {
        world.setDirection(Directions.LEFT, gameState.getFirstPlayer());
        world.update();

        assertTrue(world
            .getTank(gameState.getFirstPlayer())
            .getPosition()
            .equals(new P2d(3, 4)));

        var wall = world.getWalls()
            .stream()
            .filter(w -> w.getPosition().equals(new P2d(1, 4)))
            .toList()
            .get(0);

        world.collision(wall.getPosition(), new P2d(3, 4));

        assertTrue(world
            .getTank(gameState.getFirstPlayer())
            .getPosition()
            .equals(new P2d(4, 4)));

    }

    @org.junit.jupiter.api.Test
    public void removeTest() {
        world.setDirection(Directions.RIGHT, gameState.getFirstPlayer());
        world.shot(gameState.getFirstPlayer());
        world.update();

        assertTrue(world
            .getTank(gameState.getFirstPlayer())
            .getPosition()
            .equals(new P2d(5, 4)));

        var bullet = world.getBullets()
            .stream()
            .toList()
            .get(0);

        int life = world.getTank(gameState.getFirstPlayer())
            .getLifePoints();

        world.collision(new P2d(5, 4), bullet.getPosition());
        world.update();
        assertEquals(0, world.getBullets().size());
        assertEquals(life - bullet.getDamage(), world.getTank(gameState.getFirstPlayer()).getLifePoints());
        }
}

