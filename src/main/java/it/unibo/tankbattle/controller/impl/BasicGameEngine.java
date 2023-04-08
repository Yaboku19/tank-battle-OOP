package it.unibo.tankbattle.controller.impl;

import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
import javax.xml.bind.JAXBException;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.tankbattle.common.NextAndPrevious;
import it.unibo.tankbattle.common.input.api.Command;
import it.unibo.tankbattle.controller.api.GameEngine;
import it.unibo.tankbattle.controller.api.ObjectsManager;
import it.unibo.tankbattle.controller.api.Player;
import it.unibo.tankbattle.controller.api.WorldEventListener;
import it.unibo.tankbattle.model.gamesetup.api.Data;
import it.unibo.tankbattle.model.gamesetup.api.DataList;
import it.unibo.tankbattle.model.gamesetup.impl.MapData;
import it.unibo.tankbattle.model.gamesetup.impl.MapDataList;
import it.unibo.tankbattle.model.gamesetup.impl.TankData;
import it.unibo.tankbattle.model.gamesetup.impl.TankDataList;
import it.unibo.tankbattle.model.gamestate.api.GameState;
import it.unibo.tankbattle.model.gamestate.impl.GameStateImpl;
import it.unibo.tankbattle.view.api.View;

/**
 * An implementation of {@link GameEngine} and {@link WorldEventListener}.
 */
public class BasicGameEngine implements GameEngine, WorldEventListener {

    private static final long PERIOD = 20;
    private final View view;
    private final GameState model;
    private final Queue<Command> commandQueue = new LinkedList<>();
    private Thread thread;
    private Boolean isOver = false;
    private Player firstPlayer;
    private Player secondPlayer;
    private ObjectsManager<TankData, TankDataList> tankFirstManager;
    private ObjectsManager<TankData, TankDataList> tankSecondManager;
    private ObjectsManager<MapData, MapDataList> mapManager;
    private static final Logger LOGGER = Logger.getLogger("ControllerLog");

    /**
     * Costructor with one argument.
     * @param view the view of the game
     */
    @SuppressFBWarnings(
        value = {"EI_EXPOSE_REP2"}, 
        justification = "It is needed the object not its copy"
    )
    public BasicGameEngine(final View view) {
        thread = new Thread(this);
        this.view = view;
        model = new GameStateImpl(this);
        try {
            tankFirstManager = generateObjectManager(
                ClassLoader.getSystemResource("config/tankConfig.xml"), 
                TankDataList.class);
            tankSecondManager = generateObjectManager(
                ClassLoader.getSystemResource("config/tankConfig.xml"), 
                TankDataList.class);
            mapManager = generateObjectManager(
                ClassLoader.getSystemResource("config/mapConfig.xml"),
                MapDataList.class);
        } catch (JAXBException e) {
            LOGGER.log(Level.SEVERE, "read for xml gone wrong");
        }
    }

    private <T extends Data, C extends DataList<T>> ObjectsManager<T, C> generateObjectManager(
            final URL url, 
            final Class<C> clas) throws JAXBException {
        return new ObjectsManagerImpl<T, C>(url, clas);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startGame() {
        firstPlayer = new HumanPlayer(view.getFirstPlayerName(), tankFirstManager.getActual());
        secondPlayer = new HumanPlayer(view.getSecondPlayerName(), tankSecondManager.getActual());
        model.createWorld(firstPlayer, secondPlayer, mapManager.getActual());
        thread.start();
    }

    private void loop() {
        this.isOver = false;
        long previousCycleStartTime = System.currentTimeMillis();
        commandQueue.clear();
        while (!isOver) {
            final long currentCycleStartTime = System.currentTimeMillis();
            final long elapsed = currentCycleStartTime - previousCycleStartTime;
            processInput();
            update(elapsed);
            render();
            waitForNextFrame(currentCycleStartTime);
            previousCycleStartTime = currentCycleStartTime;
        }
        view.gameOver();
    }

    private void waitForNextFrame(final long cycleStartTime) {
        final long dt = System.currentTimeMillis() - cycleStartTime;
        if (dt < PERIOD) {
            try {
                Thread.sleep(PERIOD - dt);
            } catch (InterruptedException e) {
                LOGGER.log(Level.SEVERE, "sleep gone wrong");
            }
        }
    }

    private void processInput() {
        if (commandQueue.size() > 0) {
            commandQueue.poll().execute(model);
        }
    }

    private void update(final double elapsed) {
        model.update(elapsed);
    }

    private void render() {
        view.render(model.getTankTrasform(firstPlayer), model.getTankTrasform(secondPlayer), 
                model.getWallsTrasform(), model.getBulletsTrasform(), 
                model.getTankLife(firstPlayer), model.getTankLife(secondPlayer),
                firstPlayer.getScore(), secondPlayer.getScore());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyCommand(final Command command) {
        commandQueue.add(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void endGame(final Player player) {
        final Player winner = findWinner(player);
        winner.incScore();
        view.setWinner(winner.getName());
        this.isOver = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Player getFirstPlayer() {
        return firstPlayer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Player getSecondPlayer() {
        return secondPlayer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        loop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateTankPlayer1(final NextAndPrevious delta) {
        tankFirstManager.update(delta);
        final var toReturn = tankFirstManager.getActual();
        view.updateFirstPlayerSettingsView(toReturn.getSpeed(), toReturn.getDamage(), toReturn.getLife(), toReturn.getResource());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateTankPlayer2(final NextAndPrevious delta) {
        tankSecondManager.update(delta);
        final var toReturn = tankSecondManager.getActual();
        view.updateSecondPlayerSettingsView(toReturn.getSpeed(), toReturn.getDamage(),
            toReturn.getLife(), toReturn.getResource());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateMap(final NextAndPrevious delta) {
        mapManager.update(delta);
        final var toReturn = mapManager.getActual();
        view.updateMapSettings(toReturn.getResource(), toReturn.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setViewResources() {
        view.setResource(tankFirstManager.getActual().getResource(),
                tankSecondManager.getActual().getResource(),
                mapManager.getActual().getResource());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void restartGame() {
        thread = new Thread(this);
        model.createWorld(firstPlayer, secondPlayer, mapManager.getActual());
        thread.start();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void restartApplication() {
        thread = new Thread(this);
    }

    private Player findWinner(final Player deadPlayer) {
        if (deadPlayer.equals(firstPlayer)) {
            return secondPlayer;
        } else {
            return firstPlayer;
        }
    }
}
