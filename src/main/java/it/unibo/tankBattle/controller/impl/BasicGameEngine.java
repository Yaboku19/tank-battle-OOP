package it.unibo.tankBattle.controller.impl;

import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.controller.api.WorldEventListener;
import it.unibo.tankBattle.model.gameState.api.GameState;
import it.unibo.tankBattle.model.gameState.impl.GameStateImpl;
import it.unibo.tankBattle.view.api.View;
import it.unibo.tankBattle.view.impl.ViewImpl;

public class BasicGameEngine implements GameEngine, WorldEventListener {
    private final View view;
    private final GameState model;
    //private final Queue<Pair<Player,Command>> commandQueue = new LinkedList<>();
    //private HashMap<Player,InputController> controllers;
    private Boolean isOver = false;
    private Player firstPlayer = null;
    private Player secondPlayer = null;

    public BasicGameEngine(ViewImpl view) {
        this.view = view;
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
        firstPlayer = new HumanPlayer();
        secondPlayer = new HumanPlayer();
        model.createWorld(firstPlayer, secondPlayer);
        //initGame();
        /*
         * new instance of model
         */
        loop();
    }

    private void loop() {
        this.isOver = false;
        while(!isOver) {
            processInput();
            update();
            render();
            // time at each frame toDo
        }
    }

    private void processInput() {
        //var cmd = commandQueue.poll();
        /*cmd.execute(cmd);*/
        /*for(var tank : model.getWorld().getTanks()){
            tank.updateInput();
        }*/
        //throw new UnsupportedOperationException("Unimplemented method 'processInput'");
    }

    private void update() {
        model.update(null);
    }

    private void render() {
        //view.repaint();
    }

    /*@Override
    public void notifyCommand(Player player, Command command) {
        commandQueue.add(new Pair<>(player, command));
    }*/

    /*@Override
    public HashMap<Player, InputController> getControllers() {
        //return new HashMap<>(controllers);
        return this.controllers;
    }*/

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
