package it.unibo.tankBattle;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.controller.impl.HumanPlayer;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;
import it.unibo.tankBattle.model.gameState.api.GameState;
import it.unibo.tankBattle.model.gameState.impl.GameStateImpl;





public class ModelTest {
    private GameState model;
    private Player firstPlayer;
    private Player secondPlayer;

    @org.junit.jupiter.api.BeforeEach       
	public void initFactory() {
        model = new GameStateImpl(null);
        firstPlayer = new HumanPlayer();
        secondPlayer = new HumanPlayer();
        model.createWorld(firstPlayer, secondPlayer);
    }

    @org.junit.jupiter.api.Test            
	public void getTest() {        
        System.out.println(model.getWalls().sorted((g,h) -> {
            var pos1 = g.getTransform().getPosition();
            var pos2 = h.getTransform().getPosition();
            if (pos1.getX() == pos2.getX()) {
                return (int)(pos1.getY() - pos2.getY());
            }
            return (int)(pos1.getX() - pos2.getX());
        }).map(g -> g.getTransform().getPosition()).toList());
        System.out.println(model.getWalls().count());
	}

    /*@org.junit.jupiter.api.Test
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

