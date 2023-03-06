package it.unibo.tankBattle;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.stream.Collectors;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.Player;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.model.gameObject.api.GameObject;
import it.unibo.tankBattle.model.gameState.api.GameState;
import it.unibo.tankBattle.model.gameState.impl.GameStateImpl;
import it.unibo.tankBattle.model.world.impl.FactoryWorld;

public class WorldTest {
	private FactoryWorld factoryWorld;
    private GameState gameState;

    @org.junit.jupiter.api.BeforeEach       
	public void initFactory() {
		factoryWorld = new FactoryWorld(new GameStateImpl());

    }

    @org.junit.jupiter.api.Test            
	public void getterTest() {        
		var world = factoryWorld.simpleWorld();
        var entities = world.getBullets();
    
        entities.addAll(world.getWalls());
        entities.addAll(world.getTanks());

		assertEquals(entities.stream().map(g -> g.getPosition()).collect(Collectors.toSet()),
			world.getEntities().stream().map(g -> g.getPosition()).collect(Collectors.toSet()));
	}

    @org.junit.jupiter.api.Test
    public void shotTest() {
        var world = factoryWorld.simpleWorld();

        assertEquals(new HashSet<GameObject>(), world.getBullets());

        world.shot(gameState.getPlayer1());
        assertEquals(1, world.getBullets().size());

    }

    @org.junit.jupiter.api.Test
    public void UpdateTest() {
        var world = factoryWorld.simpleWorld();
        assertTrue(world
            .getTanks()
            .stream()
            .map(t -> t.getPosition())
            .collect(Collectors.toSet())
            .contains(new P2d(4, 4)));

        world.setDirection(Directions.RIGHT, gameState.getPlayer1());
        world.update();

        assertFalse(world
            .getTanks()
            .stream()
            .map(t -> t.getPosition())
            .collect(Collectors.toSet())
            .contains(new P2d(4, 4)));

        assertTrue(world
            .getTanks()
            .stream()
            .map(t -> t.getPosition())
            .collect(Collectors.toSet())
            .contains(new P2d(5, 4)));

        assertTrue(world
            .getTanks()
            .stream()
            .map(t -> t.getPosition())
            .collect(Collectors.toSet())
            .contains(new P2d(13 * 3 + 1, 8 * 3 + 1)));

        world.setDirection(Directions.NONE, gameState.getPlayer1());

        world.update();

        assertTrue(world
            .getTanks()
            .stream()
            .map(t -> t.getPosition())
            .collect(Collectors.toSet())
            .contains(new P2d(5, 4)));

        assertTrue(world
            .getTanks()
            .stream()
            .map(t -> t.getPosition())
            .collect(Collectors.toSet())
            .contains(new P2d(13 * 3 + 1, 8 * 3 + 1)));

    }

    @org.junit.jupiter.api.Test
    public void collisionTest() {
        var world = factoryWorld.simpleWorld();

        world.setDirection(Directions.LEFT, gameState.getPlayer1());

        world.update();

        assertTrue(world
            .getTanks()
            .stream()
            .map(t -> t.getPosition())
            .collect(Collectors.toSet())
            .contains(new P2d(3, 4)));

        var wall = world.getWalls()
            .stream()
            .filter(w -> w.getPosition().equals(new P2d(1, 4)))
            .toList()
            .get(0);

        world.collision(wall.getPosition(), new P2d(3, 4));

        assertTrue(world
            .getTanks()
            .stream()
            .map(t -> t.getPosition())
            .collect(Collectors.toSet())
            .contains(new P2d(4, 4)));

    }

    @org.junit.jupiter.api.Test
    public void removeTest() {
        var world = factoryWorld.simpleWorld();

        world.setDirection(Directions.RIGHT, gameState.getPlayer1());
        world.shot(gameState.getPlayer1());
        world.update();
        assertTrue(world
            .getTanks()
            .stream()
            .map(t -> t.getPosition())
            .collect(Collectors.toSet())
            .contains(new P2d(5, 4)));

        var bullet = world.getBullets()
            .stream()
            .toList()
            .get(0);

        int life = world.getTanks()
            .stream()
            .filter(t -> t.getPosition().equals(new P2d(5, 4)))
            .toList()
            .get(0)
            .getLifePoints();

        var tank = world.getTanks()
            .stream()
            .filter(t -> t.getPosition().equals(new P2d(5, 4)))
            .toList()
            .get(0);
        world.collision(new P2d(5, 4), bullet.getPosition());
        world.update();
        assertEquals(0, world.getBullets().size());
        assertEquals(life - bullet.getDamage(), tank.getLifePoints());
        }
}

