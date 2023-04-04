package it.unibo.tankbattle.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import javax.xml.bind.JAXBException;

import it.unibo.tankbattle.common.NextAndPrevious;
import it.unibo.tankbattle.controller.api.ObjectsManager;
import it.unibo.tankbattle.controller.impl.ObjectsManagerImpl;
import it.unibo.tankbattle.model.gamesetup.impl.TankData;
import it.unibo.tankbattle.model.gamesetup.impl.TankDataList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * rappresent a test for {@link ObjectsManager}.
 */
class ObjectsManagerTest {
    private ObjectsManager<TankData, TankDataList> tankManager;
    private static final int NUMTANK = 3;
    private static final int NUMMAP = 3;
    private ObjectsManager<TankData, TankDataList> mapManager;
    private static final Logger LOGGER = Logger.getLogger("ObjectManagerTestLog");

    @org.junit.jupiter.api.BeforeEach
    void initFactory() {
        try {
            tankManager = new ObjectsManagerImpl<>(
                ClassLoader.getSystemResource("config/tankConfig.xml"), TankDataList.class);
            mapManager = new ObjectsManagerImpl<>(
                    ClassLoader.getSystemResource("config/tankConfig.xml"), TankDataList.class);
        } catch (JAXBException e) {
            LOGGER.log(Level.WARNING, "error");
        }
    }

    /**
     * It tests the tankManager.
     */
    @org.junit.jupiter.api.Test
    void testTankManager() {
        testManager(tankManager, NUMTANK);
    }

    /**
     * It tests the mapManager.
     */
    @org.junit.jupiter.api.Test
    void testMapManager() {
        testManager(mapManager, NUMMAP);
    }

    private <T, C> void testManager(final ObjectsManager<T, C> manager, final int numMax) {
        if (manager == null) {
            throw new IllegalStateException();
        } else {
            final var tank = manager.getActual();
            assertEquals(tank, manager.getActual());
            manager.update(NextAndPrevious.NEXT);
            assertNotEquals(tank, manager.getActual());
            manager.update(NextAndPrevious.PREVIOUS);
            assertEquals(tank, manager.getActual());
            manager.update(NextAndPrevious.NONE);
            assertEquals(tank, manager.getActual());
            for (int i = 0; i < numMax; i++) {
                manager.update(NextAndPrevious.NEXT);
            }
            assertEquals(tank, manager.getActual());
            for (int i = 0; i < numMax; i++) {
                manager.update(NextAndPrevious.PREVIOUS);
            }
            assertEquals(tank, manager.getActual());
        }
    }
}
