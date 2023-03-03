package it.unibo.tankBattle.controller.impl;

import java.util.LinkedList;
import java.util.Queue;

import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.model.api.GameState;
import it.unibo.tankBattle.model.impl.GameStateImpl;
import it.unibo.tankBattle.model.api.GameState;
import it.unibo.tankBattle.view.api.View;
import it.unibo.tankBattle.view.impl.ViewImpl;
import it.unibo.tankBattle.common.input.api.*;

public class BasicGameEngine implements GameEngine {
    private View view;
    private GameState model;
    private Queue<Command> commandQueue = new LinkedList<>();

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
        Command cmd = commandQueue.poll();
        cmd.execute();
        for(var tank : model.getWorld().getTanks()){
            tank.updateInput();
        }
        throw new UnsupportedOperationException("Unimplemented method 'processInput'");
    }

    private void loop() {
        
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
    
}
