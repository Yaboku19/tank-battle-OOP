package it.unibo.tankbattle.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
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
import it.unibo.tankbattle.model.world.api.WorldFactory;
import it.unibo.tankbattle.model.world.impl.WorldFactoryImpl;

/**
 * rappresent a test for the model {@link GameStateImpl}.
 */
class GameStateTest {
    private GameStateImpl model;
    private Player firstPlayer;
    private Player secondPlayer;
    private WorldFactory factoryWorld;
    private ObjectsManager<MapData, MapDataList> mapManager;
    private static final Logger LOGGER = Logger.getLogger("ModelTestLog");

    @org.junit.jupiter.api.BeforeEach
    void initFactory() {
        ObjectsManager<TankData, TankDataList> tankFirstManager = null;
        ObjectsManager<TankData, TankDataList> tankSecondManager = null;
        mapManager = null;
        model = new GameStateImpl(null);
        try {
            tankFirstManager = new ObjectsManagerImpl<>(
            ClassLoader.getSystemResource("config/tankConfig.xml"), TankDataList.class);
            tankSecondManager = new ObjectsManagerImpl<>(
            ClassLoader.getSystemResource("config/tankConfig.xml"), TankDataList.class);
            mapManager = new ObjectsManagerImpl<>(
            ClassLoader.getSystemResource("config/mapConfig.xml"), MapDataList.class);
        } catch (JAXBException e) {
            LOGGER.log(Level.WARNING, "error");
        }
        firstPlayer = createPlayer(tankFirstManager);
        secondPlayer = createPlayer(tankSecondManager);
        model.createWorld(firstPlayer, secondPlayer, mapManager.getActual());
        factoryWorld = new WorldFactoryImpl();
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
     * it tests the getter of GameStateImpl.
     */
    @org.junit.jupiter.api.Test
    void getterTest() {
        if (mapManager == null || factoryWorld == null || model == null) {
            throw new IllegalStateException();
        } else {
            final var allEntities = new ArrayList<Transform>();
            allEntities.addAll(model.getBulletsTrasform().toList());
            allEntities.addAll(model.getWallsTrasform().toList());
            allEntities.add(model.getTankTrasform(firstPlayer));
            allEntities.add(model.getTankTrasform(secondPlayer));
            assertEquals(factoryWorld.simpleWorld(firstPlayer, secondPlayer, mapManager.getActual())
                .getEntities()
                .toList().size(),
                allEntities.size());
        }
    }

    /**
     * It tests how the bullets are created.
     */
    @org.junit.jupiter.api.Test
    void shotTest() {
        if (model == null) {
            throw new IllegalStateException();
        } else {
            assertEquals(0, model.getBulletsTrasform().count());
            model.shoot(firstPlayer);
            assertEquals(1, model.getBulletsTrasform().count());
            model.shoot(secondPlayer);
            assertEquals(2, model.getBulletsTrasform().count());
        }
    }

    /**
     * it tests how the direction of the object is setted.
     */
    @org.junit.jupiter.api.Test
    void changeDirectionTest() {
        if (model == null) {
            throw new IllegalStateException();
        } else {
            model.setDirection(Direction.DOWN, firstPlayer);
            assertEquals(Direction.DOWN, model.getTankTrasform(firstPlayer).getDirection());
        }
    }
}
