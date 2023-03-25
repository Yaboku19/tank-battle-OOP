package it.unibo.tankBattle;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.common.input.api.Direction;
import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.model.gameSetup.impl.MapData;
import it.unibo.tankBattle.model.gameSetup.impl.TankData;
import it.unibo.tankBattle.model.gameState.impl.GameStateImpl;
import it.unibo.tankBattle.model.world.api.FactoryWorld;
import it.unibo.tankBattle.model.world.impl.FactoryWorldImpl;

public class ModelTest {
    private GameStateImpl model;
    private Player firstPlayer;
    private Player secondPlayer;
    private FactoryWorld factoryWorld;

    @org.junit.jupiter.api.BeforeEach       
	public void initFactory() {
        model = new GameStateImpl(null);
        firstPlayer = createPlayer();
        secondPlayer = createPlayer();
        model.createWorld(firstPlayer, secondPlayer, new MapData());
        factoryWorld = new FactoryWorldImpl();
    }

    private Player createPlayer() {
        return new Player() {

            @Override
            public int getScore() {
                return 1;
            }

            @Override
            public void incScore() {
            }

            @Override
            public int getCode() {
                return 0;
            }

            @Override
            public TankData getTankData() {
                return null;
            }

        };
    }

    @org.junit.jupiter.api.Test            
	public void getTest() {
        var allEntities = new ArrayList<Transform>();
        allEntities.addAll(model.getBulletsTrasform().toList());
        allEntities.addAll(model.getWallsTrasform().toList());     
        allEntities.add(model.getTankTrasform(firstPlayer));
        allEntities.add(model.getTankTrasform(secondPlayer));
        assertEquals(factoryWorld.simpleWorld(firstPlayer, secondPlayer, new MapData()).getEntities().toList().size(), allEntities.size());
	}

    @org.junit.jupiter.api.Test
    public void shotTest() {
        assertEquals(0, model.getBulletsTrasform().count());
        model.shot(firstPlayer);
        assertEquals(1, model.getBulletsTrasform().count());
        model.shot(secondPlayer);
        assertEquals(2, model.getBulletsTrasform().count());
    }

    @org.junit.jupiter.api.Test
    public void ChangeDirectionTest() {
        //assertEquals(Directions.NONE, tank.getTransform().getDirection());
        model.setDirection(Direction.DOWN, firstPlayer);
        assertEquals(Direction.DOWN, model.getTankTrasform(firstPlayer).getDirection());
    }

   /* @org.junit.jupiter.api.Test
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

