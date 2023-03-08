package it.unibo.tankBattle.controller.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import static java.awt.event.KeyEvent.*;
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
    private View view;
    private GameState model;
    private Queue<Pair<Player,Command>> commandQueue = new LinkedList<>();
    private HashMap<Player,InputController> controllers;
    private Boolean isOver = false;

    public BasicGameEngine() {
        view = new ViewImpl(this);
    }

    @Override
    public void play() {
        view.setVisible(true);
        view.bugSolve();
    }

    private void initGame(){
        controllers = new HashMap<Player,InputController>();

        KeyboardInputController contr1 = new KeyboardInputController(VK_UP,VK_DOWN,VK_LEFT,VK_RIGHT, VK_SPACE);
        KeyboardInputController contr2 = new KeyboardInputController(VK_W,VK_Z,VK_A,VK_S, VK_CONTROL);
        controllers.put(model.getFirstPlayer(), contr1);
        controllers.put(model.getSecondPlayer(), contr2);
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
    public void notifyCommand(Player player, int keyCode) {
        commandQueue.add(new Pair<>(player, new Movement(keyCode)));
        //throw new UnsupportedOperationException("Unimplemented method 'notifyCommand'");
    }

    @Override
    public HashMap<Player, InputController> getControllers() {
        return new HashMap<>(controllers);
    }

    @Override
    public void endgame() {
        this.isOver = true;
    }
    
}
