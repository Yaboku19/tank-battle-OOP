package it.unibo.tankBattle;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;
import it.unibo.tankBattle.model.gameObject.impl.component.Tank;
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
        model.createWorld(firstPlayer, secondPlayer);
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

        };
    }

    @org.junit.jupiter.api.Test            
	public void getTest() {        
        var allEntities = model.getTanks().collect(Collectors.toSet());
        allEntities.addAll(model.getWalls().collect(Collectors.toSet()));
        allEntities.addAll(model.getBullets().collect(Collectors.toSet()));
        var entitiesSorted = sortEntities(allEntities.stream());
        var worldSortedEntities = sortEntities(factoryWorld.simpleWorld(firstPlayer, secondPlayer)
                                    .getEntities());
        assertEquals(worldSortedEntities, entitiesSorted);
	}

    private List<P2d> sortEntities(Stream<GameObject> entities) {
        return entities
            .map(g -> g.getTransform().getPosition())
            .sorted((a, b) -> {
                if(a.getX() == b.getX()) {
                    return (int)(a.getY() - b.getY());
                } else {
                    return (int)(a.getX() - b.getX());
                }
            })
            .toList();
    }

    @org.junit.jupiter.api.Test
    public void shotTest() {
        assertEquals(0, model.getBullets().count());
        model.shot(firstPlayer);
        assertEquals(1, model.getBullets().count());
        model.shot(secondPlayer);
        assertEquals(2, model.getBullets().count());
    }

    @org.junit.jupiter.api.Test
    public void ChangeDirectionTest() {
        var tank = model.getTanks()
            .filter(g -> g.getComponent(Tank.class).get().getPlayer().equals(firstPlayer))
            .findFirst()
            .get();
        //assertEquals(Directions.NONE, tank.getTransform().getDirection());
        model.setDirection(Directions.DOWN, firstPlayer);
        assertEquals(Directions.DOWN, tank.getTransform().getDirection());
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

