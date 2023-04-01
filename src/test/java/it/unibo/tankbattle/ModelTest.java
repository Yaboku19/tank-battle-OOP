package it.unibo.tankbattle;


import static org.junit.jupiter.api.Assertions.assertEquals;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBException;
import it.unibo.tankbattle.common.Transform;
import it.unibo.tankbattle.common.input.api.Direction;
import it.unibo.tankbattle.controller.api.ObjectsManager;
import it.unibo.tankbattle.controller.api.Player;
import it.unibo.tankbattle.controller.impl.ObjectsManagerImpl;
import it.unibo.tankbattle.model.gamesetup.impl.MapData;
import it.unibo.tankbattle.model.gamesetup.impl.MapDataList;
import it.unibo.tankbattle.model.gamesetup.impl.TankData;
import it.unibo.tankbattle.model.gamesetup.impl.TankDataList;
import it.unibo.tankbattle.model.gamestate.impl.GameStateImpl;
import it.unibo.tankbattle.model.world.api.FactoryWorld;
import it.unibo.tankbattle.model.world.impl.FactoryWorldImpl;
/**
 * javadoc.
 */
class ModelTest {
    private GameStateImpl model;
    private Player firstPlayer;
    private Player secondPlayer;
    private FactoryWorld factoryWorld;
    private ObjectsManager<MapData, MapDataList> mapManager;
    private static Logger logger = Logger.getLogger("ModelTestLog");
    /**
     * javadoc.
     */
    @org.junit.jupiter.api.BeforeEach
    void initFactory() {
        ObjectsManager<TankData, TankDataList> tankFirstManager = null;
        ObjectsManager<TankData, TankDataList> tankSecondManager = null;
        model = new GameStateImpl(null);
        try {
            tankFirstManager = new ObjectsManagerImpl<>(
            ClassLoader.getSystemResource("config/tankConfig.xml").toURI(), TankDataList.class);
            tankSecondManager = new ObjectsManagerImpl<>(
            ClassLoader.getSystemResource("config/tankConfig.xml").toURI(), TankDataList.class);
            mapManager = new ObjectsManagerImpl<>(
            ClassLoader.getSystemResource("config/mapConfig.xml").toURI(), MapDataList.class);
        } catch (JAXBException | URISyntaxException e) {
            logger.log(Level.WARNING, "error");
        }
        firstPlayer = createPlayer(tankFirstManager);
        secondPlayer = createPlayer(tankSecondManager);
        model.createWorld(firstPlayer, secondPlayer, mapManager.getActual());
        factoryWorld = new FactoryWorldImpl();
    }

    private Player createPlayer(final ObjectsManager<TankData, TankDataList> manObj) {
        return new Player() {

            @Override
            public int getScore() {
                return 1;
            }

            @Override
            public void incScore() {
            }

            @Override
            public String getName() {
                return "0";
            }

            @Override
            public TankData getTankData() {
                return manObj.getActual();
            }

        };
    }
    /**
     * javadoc.
     */
    @org.junit.jupiter.api.Test
    void getterTest() {
        final var allEntities = new ArrayList<Transform>();
        allEntities.addAll(model.getBulletsTrasform().toList());
        allEntities.addAll(model.getWallsTrasform().toList());
        allEntities.add(model.getTankTrasform(firstPlayer));
        allEntities.add(model.getTankTrasform(secondPlayer));
        assertEquals(factoryWorld.simpleWorld(firstPlayer, secondPlayer, mapManager.getActual()).getEntities().toList().size(),
            allEntities.size());
    }
    /**
     * javadoc.
     */
    @org.junit.jupiter.api.Test
    void shotTest() {
        assertEquals(0, model.getBulletsTrasform().count());
        model.shot(firstPlayer);
        assertEquals(1, model.getBulletsTrasform().count());
        model.shot(secondPlayer);
        assertEquals(2, model.getBulletsTrasform().count());
    }
    /**
     * javadoc.
     */
    @org.junit.jupiter.api.Test
    void changeDirectionTest() {
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

