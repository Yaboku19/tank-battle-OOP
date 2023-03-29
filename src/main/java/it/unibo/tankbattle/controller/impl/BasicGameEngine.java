package it.unibo.tankbattle.controller.impl;

import java.net.URI;
import java.util.LinkedList;
import java.util.Queue;

import javax.xml.bind.JAXBException;

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

public class BasicGameEngine implements GameEngine, WorldEventListener {
    private long period = 20;
    private final View view;
    private final GameState model;
    private final Queue<Command> commandQueue = new LinkedList<>();
    private Thread thread;
    private Boolean isOver = false;
    private Player firstPlayer = null;
    private Player secondPlayer = null;
    private ObjectsManager<TankData, TankDataList> tankFirstManager;
    private ObjectsManager<TankData, TankDataList> tankSecondManager;
    private ObjectsManager<MapData, MapDataList> mapManager;

    public BasicGameEngine(final View view) {
        thread = new Thread(this);
        this.view = view;
        view.setController(this);
        model = new GameStateImpl(this);
        try {
            tankFirstManager = generateObjectManager(
                ClassLoader.getSystemResource("config/tankConfig.xml").toURI()
                , TankDataList.class);
            tankSecondManager = generateObjectManager(
                ClassLoader.getSystemResource("config/tankConfig.xml").toURI()
                , TankDataList.class);
            mapManager = generateObjectManager(
                ClassLoader.getSystemResource("config/mapConfig.xml").toURI()
                , MapDataList.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private <T extends Data, C extends DataList<T>> ObjectsManager<T, C> generateObjectManager(
            URI path
            , Class<C> clas) throws JAXBException {
        return new ObjectsManagerImpl<T, C>(path, clas);
    }

    @Override
    public void startGame() {
        firstPlayer = new HumanPlayer(view.getFirstPlayerName(), tankFirstManager.getActual());
        secondPlayer = new HumanPlayer(view.getSecondPlayerName(), tankSecondManager.getActual());
        model.createWorld(firstPlayer, secondPlayer
            , mapManager.getActual());
        System.out.println("start game");
        thread.start();
        //initGame();
        /*
         * new instance of model
         */
    }

    private void loop() {
        this.isOver = false;
        long previousCycleStartTime = System.currentTimeMillis();
        while(!isOver) {
            long currentCycleStartTime = System.currentTimeMillis();
			long elapsed = currentCycleStartTime - previousCycleStartTime;
            processInput();
            update(elapsed);
            render();
            waitForNextFrame(currentCycleStartTime);
			previousCycleStartTime = currentCycleStartTime;
        }
        view.gameOver();
    }

    private void waitForNextFrame(long cycleStartTime){
		long dt = System.currentTimeMillis() - cycleStartTime;
		if (dt < period){
			try {
				Thread.sleep(period - dt);
			} catch (Exception ex){
                System.out.println(ex.toString());
            }
		}
	}

    private void processInput() {
        if (commandQueue.size() > 0){
            var cmd = commandQueue.poll();
            cmd.execute(model);
        }
    }

    private void update(double elapsed) {
        model.update(elapsed);
    }

    private void render() {
        view.render(model.getTankTrasform(firstPlayer), model.getTankTrasform(secondPlayer), 
                model.getWallsTrasform(), model.getBulletsTrasform(), model.getTankLife(firstPlayer) , model.getTankLife(secondPlayer));
    }

    @Override
    public void notifyCommand(Command command) {
        commandQueue.add(command);
    }

    @Override
    public void endGame(final Player player) {
        player.incScore();
        view.setWinner(player.getCode());
        this.isOver = true;
    }

    @Override
    public Player getFirstPlayer() {
        return firstPlayer;
    }

    @Override
    public Player getSecondPlayer() {
        return secondPlayer;
    }

    @Override
    public void run() {
        loop();
    }

    /*public void setSettingsViewController(SettingsController settingsViewController){
        this.settingsViewController = settingsViewController;
    }*/

    @Override
    public void updateTankPlayer1(NextAndPrevious delta) {
        tankFirstManager.update(delta);
        var toReturn = tankFirstManager.getActual();
        view.viewUpdateP1(toReturn.getSpeed(), toReturn.getDamage(), toReturn.getLife(), toReturn.getResource());
    }

    @Override
    public void updateTankPlayer2(NextAndPrevious delta) {
        tankSecondManager.update(delta);
        var toReturn = tankSecondManager.getActual();
        view.viewUpdateP2(toReturn.getSpeed(), toReturn.getDamage(), toReturn.getLife(), toReturn.getResource());
    }

    @Override
    public void updateMap(NextAndPrevious delta) {
        mapManager.update(delta);
        var toReturn = mapManager.getActual();
        view.viewUpdateMap(toReturn.getResource());
    }

    @Override
    public void setViewResources() {
        view.setResource(tankFirstManager.getActual().getResource(),
                tankSecondManager.getActual().getResource(),
                mapManager.getActual().getResource());
    }

    @Override
    public void restart() {
        thread.interrupt();
        thread = new Thread(this);
        model.createWorld(firstPlayer, secondPlayer, mapManager.getActual());
        thread.start();
    }

    @Override
    public void newStart() {
        thread.interrupt();
        thread = new Thread(this);
    }

}
