package it.unibo.tankbattle.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBException;

import it.unibo.tankbattle.common.input.api.InputController;
import it.unibo.tankbattle.common.input.impl.KeyboardInputController;
import it.unibo.tankbattle.common.input.impl.Movement;
import it.unibo.tankbattle.common.input.impl.Shoot;
import it.unibo.tankbattle.controller.api.ObjectsManager;
import it.unibo.tankbattle.controller.api.Player;
import it.unibo.tankbattle.controller.impl.ObjectsManagerImpl;
import it.unibo.tankbattle.model.gamesetup.impl.TankData;
import it.unibo.tankbattle.model.gamesetup.impl.TankDataList;
import javafx.scene.input.KeyCode;
/**
 * Class to test Command.
 */
class CommandTest {

    private InputController<KeyCode> inputController;
    private static final Logger LOGGER = Logger.getLogger("GameObjectTestLog");

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
     * Initialize objects.
     */
    @org.junit.jupiter.api.BeforeEach
    void initFactory() {
        ObjectsManager<TankData, TankDataList> firstTankManager;
        Player player;
        try {
            firstTankManager = new ObjectsManagerImpl<>(
                ClassLoader.getSystemResource("config/tankConfig.xml"), TankDataList.class);
            player = createPlayer(firstTankManager);
            inputController = new KeyboardInputController<>(KeyCode.UP, KeyCode.DOWN, KeyCode.LEFT,
                KeyCode.RIGHT, KeyCode.SPACE, player);
        } catch (JAXBException e) {
            LOGGER.log(Level.WARNING, "error");
        }
    }

    /**
     * Start command test.
     */
    @org.junit.jupiter.api.Test
    void testStartCommand() {
        if (inputController == null) {
            throw new IllegalStateException();
        } else {
            final var moveUp = inputController.startCommand(KeyCode.UP);
            assertEquals(Movement.class, moveUp.get().getClass());
            assertEquals(Optional.empty(), inputController.startCommand(KeyCode.UP));
            assertEquals(Optional.empty(), inputController.startCommand(KeyCode.A));
            final var shoot = inputController.startCommand(KeyCode.SPACE);
            assertEquals(Shoot.class, shoot.get().getClass());
        }
    }

    /**
     * Stop command test.
     */
    @org.junit.jupiter.api.Test
    void testStopCommand() {
        if (inputController == null) {
            throw new IllegalStateException();
        } else {
            inputController.startCommand(KeyCode.UP);
            assertEquals(Optional.empty(), inputController.stopCommand(KeyCode.DOWN));
            final var moveUp = inputController.stopCommand(KeyCode.UP);
            assertEquals(Movement.class, moveUp.get().getClass());
            assertEquals(Optional.empty(), inputController.startCommand(KeyCode.A));
            inputController.startCommand(KeyCode.SPACE);
            final var shoot = inputController.stopCommand(KeyCode.SPACE);
            assertEquals(Optional.empty(), shoot);
        }
    }

}
