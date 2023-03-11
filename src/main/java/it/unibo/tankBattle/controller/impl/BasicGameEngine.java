package it.unibo.tankBattle.controller.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.model.gameState.api.GameState;
import it.unibo.tankBattle.model.gameState.impl.GameStateImpl;
import it.unibo.tankBattle.model.gameState.api.Player;
import it.unibo.tankBattle.view.api.View;
import it.unibo.tankBattle.view.impl.ViewImpl;
import it.unibo.tankBattle.common.Pair;
import it.unibo.tankBattle.common.input.api.Command;
import it.unibo.tankBattle.common.input.api.InputController;
import it.unibo.tankBattle.common.input.impl.KeyboardInputController;
import it.unibo.tankBattle.common.input.impl.Movement;

public class BasicGameEngine implements GameEngine {
    private final View view;
    private GameState model = null;
    private final Queue<Pair<Player,Command>> commandQueue = new LinkedList<>();
    private HashMap<Player,InputController> controllers;
    private Boolean isOver = false;

    public BasicGameEngine() {
        view = new ViewImpl(this);
        model = new GameStateImpl(this);
    }

    @Override
    public void play() {
        initGame();
        view.setVisible(true);
        view.bugSolve();
    }

    private void initGame(){
        controllers = new HashMap<Player,InputController>();
        controllers.put(model.getFirstPlayer(), view.getInputControllerPlayer1());
        controllers.put(model.getSecondPlayer(), view.getInputControllerPlayer2());
    }

    @Override
    public void startGame() {
        System.out.println("game started");
        model = new GameStateImpl(this);
        initGame();
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
            events();
            render();
            // time at each frame toDo
        }
    }

    private void processInput() {
        var cmd = commandQueue.poll();
        /*cmd.execute(cmd);*/
        /*for(var tank : model.getWorld().getTanks()){
            tank.updateInput();
        }*/
        //throw new UnsupportedOperationException("Unimplemented method 'processInput'");
    }

    private void update() {
        model.update();
    }

    private void events() {
        model.resolveEvents(new HashSet<>());
    }

    private void render() {
        view.repaint();
    }

    @Override
    public void notifyCommand(Player player, Command command) {
        commandQueue.add(new Pair<>(player, command));
    }

    @Override
    public HashMap<Player, InputController> getControllers() {
        //return new HashMap<>(controllers);
        return this.controllers;
    }

    @Override
    public void endgame() {
        this.isOver = true;
    }
    
}
