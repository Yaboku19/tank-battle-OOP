package it.unibo.tankBattle;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.Player;
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
        entities.addAll(world.getTanks());

		assertEquals(entities.stream().map(g -> g.getPosition()).collect(Collectors.toSet()),
			world.getEntities().stream().map(g -> g.getPosition()).collect(Collectors.toSet()));
	}

    @org.junit.jupiter.api.Test
    public void speedDirectionTest() {
        var world = factoryWorld.simpleWorld();

        assertEquals(Set.of(Directions.UP), 
            world.getTanks().stream().map(t -> t.getDirection()).collect(Collectors.toSet()));

        world.setDirection(Directions.DOWN, Player.PLAYER_UNO);
        world.setDirection(Directions.RIGHT, Player.PLAYER_DUE);

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

    }

    @org.junit.jupiter.api.Test
    public void shotTest() {
        var world = factoryWorld.simpleWorld();

        assertEquals(new HashSet<GameObject>(), world.getBullets());

        world.shot(Player.PLAYER_UNO);
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
        /*world.buttonPressed(Directions.RIGHT, 1);
        world.update();
        assertEquals(new P2d(4 + world.getFirstTank().getMaxSpeed() * Directions.RIGHT.getX(),
        4 + world.getFirstTank().getMaxSpeed() * Directions.RIGHT.getY()), world.getFirstTank().getPosition());

        assertEquals(new P2d(13 * 3 + 1, 8 * 3 + 1), world.getSecondTank().getPosition());

        world.buttonRelased(1);

        world.update();

        assertEquals(new P2d(4 + world.getFirstTank().getMaxSpeed() * Directions.RIGHT.getX(),
        4 + world.getFirstTank().getMaxSpeed() * Directions.RIGHT.getY()), world.getFirstTank().getPosition());

        assertEquals(new P2d(13 * 3 + 1, 8 * 3 + 1), world.getSecondTank().getPosition()); */

    }

    /*@org.junit.jupiter.api.Test
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
        assertEquals(new P2d(5, 4), world.getFirstTank().getPosition());
        var bullet = world.getBullets()
            .stream()
            .toList()
            .get(0);
        int life = world.getFirstTank().getLifePoints();
        world.collision(world.getFirstTank().getPosition(), bullet.getPosition());
        world.update();
        assertEquals(0, world.getBullets().size());
        assertEquals(life - bullet.getDamage(), world.getFirstTank().getLifePoints());
    }*/
}

