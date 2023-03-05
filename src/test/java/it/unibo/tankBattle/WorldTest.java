package it.unibo.tankBattle;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.stream.Collectors;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.model.gameObject.api.GameObject;
import it.unibo.tankBattle.model.gameState.impl.GameStateImpl;
import it.unibo.tankBattle.model.world.impl.FactoryWorld;

public class WorldTest {
	private FactoryWorld factoryWorld;

    @org.junit.jupiter.api.BeforeEach       
	public void initFactory() {
		factoryWorld = new FactoryWorld(new GameStateImpl());

    }

    @org.junit.jupiter.api.Test            
	public void getterTest() {        
		var world = factoryWorld.simpleWorld();
        var entities = world.getBullets();
    
        entities.addAll(world.getWalls());
        entities.add(world.getFirstTank());
        entities.add(world.getSecondTank());

		assertEquals(entities.stream().map(g -> g.getPosition()).collect(Collectors.toSet()),
			world.getEntities().stream().map(g -> g.getPosition()).collect(Collectors.toSet()));
	}

    @org.junit.jupiter.api.Test
    public void speedDirectionTest() {
        var world = factoryWorld.simpleWorld();

        assertEquals(0, world.getFirstTank().getCurrentSpeed());
        assertEquals(0, world.getSecondTank().getCurrentSpeed());
        assertEquals(Directions.UP, world.getFirstTank().getDirection());
        assertEquals(Directions.UP, world.getSecondTank().getDirection());

        world.buttonPressed(Directions.DOWN, 1);
        world.buttonPressed(Directions.RIGHT, 2);

        assertEquals(world.getFirstTank().getMaxSpeed(), world.getFirstTank().getCurrentSpeed());
        assertEquals(world.getSecondTank().getMaxSpeed(), world.getSecondTank().getCurrentSpeed());
        assertEquals(Directions.DOWN, world.getFirstTank().getDirection());
        assertEquals(Directions.RIGHT, world.getSecondTank().getDirection());

        assertThrows(IllegalStateException.class, () ->
                world.buttonPressed(Directions.DOWN, 3));

        world.buttonRelased(1);
        world.buttonRelased(2);

        assertEquals(0, world.getFirstTank().getCurrentSpeed());
        assertEquals(0, world.getSecondTank().getCurrentSpeed());
        assertEquals(Directions.DOWN, world.getFirstTank().getDirection());
        assertEquals(Directions.RIGHT, world.getSecondTank().getDirection());

        assertThrows(IllegalStateException.class, () ->
                world.buttonRelased(-1));
    }

    @org.junit.jupiter.api.Test
    public void shotTest() {
        var world = factoryWorld.simpleWorld();

        assertEquals(new HashSet<GameObject>(), world.getBullets());

        world.shot(1);
        assertEquals(1, world.getBullets().size());

        assertThrows(IllegalStateException.class, () ->
                world.shot(3));
    }

    @org.junit.jupiter.api.Test
    public void UpdateTest() {
        var world = factoryWorld.simpleWorld();
        assertEquals(new P2d(4, 4), world.getFirstTank().getPosition());
        world.buttonPressed(Directions.RIGHT, 1);
        world.update();
        assertEquals(new P2d(4 + world.getFirstTank().getMaxSpeed() * Directions.RIGHT.getX(),
        4 + world.getFirstTank().getMaxSpeed() * Directions.RIGHT.getY()), world.getFirstTank().getPosition());

        assertEquals(new P2d(13 * 3 + 1, 8 * 3 + 1), world.getSecondTank().getPosition());

        world.buttonRelased(1);

        world.update();

        assertEquals(new P2d(4 + world.getFirstTank().getMaxSpeed() * Directions.RIGHT.getX(),
        4 + world.getFirstTank().getMaxSpeed() * Directions.RIGHT.getY()), world.getFirstTank().getPosition());

        assertEquals(new P2d(13 * 3 + 1, 8 * 3 + 1), world.getSecondTank().getPosition());

    }

    @org.junit.jupiter.api.Test
    public void collisionTest() {
        var world = factoryWorld.simpleWorld();

        world.buttonPressed(Directions.LEFT, 1);

        world.update();
        assertEquals(new P2d(3, 4), world.getFirstTank().getPosition());
        var wall = world.getWalls()
            .stream()
            .filter(w -> w.getPosition().equals(new P2d(1, 4)))
            .toList()
            .get(0);

        world.collision(wall.getPosition(), world.getFirstTank().getPosition());

        assertEquals(new P2d(4, 4), world.getFirstTank().getPosition());
    }

    @org.junit.jupiter.api.Test
    public void removeTest() {
        var world = factoryWorld.simpleWorld();

        world.buttonPressed(Directions.RIGHT, 1);
        world.shot(2);
        world.update();
        world.update();
        //assertEquals(new P2d(5, 4), world.getFirstTank().getPosition());
        var bullet = world.getBullets()
            .stream()
            .toList()
            .get(0);
        int life = world.getFirstTank().getLifePoints();
        world.collision(world.getFirstTank().getPosition(), bullet.getPosition());
        world.update();
        //assertEquals(0, world.getBullets().size());
        //assertEquals(life - bullet.getDamage(), world.getFirstTank().getLifePoints());
    }
}

