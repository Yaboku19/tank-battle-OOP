package it.unibo.tankBattle.controller.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import static java.awt.event.KeyEvent.*;
import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.model.gameState.api.GameState;
import it.unibo.tankBattle.model.gameState.impl.GameStateImpl;
import it.unibo.tankBattle.view.api.View;
import it.unibo.tankBattle.view.impl.ViewImpl;
import it.unibo.tankBattle.common.Pair;
import it.unibo.tankBattle.common.Player;
import it.unibo.tankBattle.common.input.api.*;
import it.unibo.tankBattle.common.input.impl.KeyboardInputController;
import it.unibo.tankBattle.common.input.impl.Movement;

public class BasicGameEngine implements GameEngine {
    private View view;
    private GameState model;
    private Queue<Pair<Player,Command>> commandQueue = new LinkedList<>();
    private HashMap<Player,InputController> controllers;

    public BasicGameEngine() {
        view = new ViewImpl(this);
    }

    @Override
    public void play() {
        view.setVisible(true);
        view.bugSolve();
    }

    @Override
    public void processInput() {
        var cmd = commandQueue.poll();
        /*cmd.execute(cmd);*/
        /*for(var tank : model.getWorld().getTanks()){
            tank.updateInput();
        }*/
        //throw new UnsupportedOperationException("Unimplemented method 'processInput'");
    }

    private void loop() {
        
    }

    @Override
    public void initGame(){
        controllers = new HashMap<Player,InputController>();

        KeyboardInputController contr1 = new KeyboardInputController(VK_UP,VK_DOWN,VK_LEFT,VK_RIGHT, VK_SPACE);
        KeyboardInputController contr2 = new KeyboardInputController(VK_W,VK_Z,VK_A,VK_S, VK_CONTROL);
        controllers.put(model.getPlayer1(), contr1);
        controllers.put(model.getPlayer2(), contr2);
    }

    @Override
    public void startGame() {
        System.out.println("game started");
        model = new GameStateImpl();
        /*
         * new instance of model
         */
        loop();
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
    
}
