package it.unibo.tankBattle.controller.impl;

import java.util.LinkedList;
import java.util.Queue;

import it.unibo.tankBattle.common.input.api.Command;
import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.controller.api.WorldEventListener;
import it.unibo.tankBattle.model.gameState.api.GameState;
import it.unibo.tankBattle.model.gameState.impl.GameStateImpl;
import it.unibo.tankBattle.view.api.View;

public class BasicGameEngine implements GameEngine, WorldEventListener {
    private long period = 20;
    private final View view;
    private final GameState model;
    private final Queue<Command> commandQueue = new LinkedList<>();
    //private HashMap<Player,InputController> controllers;
    private Boolean isOver = false;
    private Player firstPlayer = null;
    private Player secondPlayer = null;

    public BasicGameEngine(final View view) {
        this.view = view;
        view.setController(this);
        model = new GameStateImpl(this);
    }

    @Override
    public void play() {
        /*initGame();
        view.setVisible(true);
        view.bugSolve();*/
    }

    /*private void initGame(){
        controllers = new HashMap<Player,InputController>();
        controllers.put(model.getFirstPlayer(), view.getInputControllerPlayer1());
        controllers.put(model.getSecondPlayer(), view.getInputControllerPlayer2());
    }*/

    @Override
    public void startGame() {
        firstPlayer = new HumanPlayer(1);
        secondPlayer = new HumanPlayer(2);
        model.createWorld(firstPlayer, secondPlayer);
        System.out.println("start game");
        //initGame();
        /*
         * new instance of model
         */
        //loop();
    }

    private void loop() {
        this.isOver = false;
        long previousCycleStartTime = System.currentTimeMillis();
        while(!isOver) {
            System.out.println("loop");
            /*long currentCycleStartTime = System.currentTimeMillis();
			long elapsed = currentCycleStartTime - previousCycleStartTime;*/
            processInput();
            //update(elapsed);
            //render();
            //waitForNextFrame(currentCycleStartTime);
			//previousCycleStartTime = currentCycleStartTime;
        }
        view.gameOver();
    }

    private void waitForNextFrame(long cycleStartTime){
		long dt = System.currentTimeMillis() - cycleStartTime;
		if (dt < period){
			try {
				Thread.sleep(period - dt);
			} catch (Exception ex){}
		}
	}

    private void processInput() {
        if (commandQueue.size() > 0){
            var cmd = commandQueue.poll();
            cmd.execute(model);
        }
        /*for(var tank : model.getWorld().getTanks()){
            tank.updateInput();
        }*/
        //throw new UnsupportedOperationException("Unimplemented method 'processInput'");
    }

    private void update(double elapsed) {
        model.update(elapsed);
    }

    private void render() {
        view.render();
        /*view.drawBullet(null);
        view.drawTank(null);*/
    }

    @Override
    public void notifyCommand(Command command) {
        commandQueue.add(command);
        System.out.println(commandQueue);
    }
    @Override
    public void endGame(final Player player) {
        player.incScore();
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
    
}
