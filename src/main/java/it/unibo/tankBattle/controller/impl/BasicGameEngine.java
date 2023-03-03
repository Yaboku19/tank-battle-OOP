package it.unibo.tankBattle.controller.impl;

import java.util.LinkedList;
import java.util.Queue;

import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.model.api.GameState;
import it.unibo.tankBattle.view.api.Graphics;
import it.unibo.tankBattle.view.impl.GraphicsImpl;
import it.unibo.tankBattle.common.input.api.*;

public class BasicGameEngine implements GameEngine {
    private Graphics view;
    private GameState gameState;
    private Queue<Command> commandQueue = new LinkedList<>();

    public BasicGameEngine() {
        view = new GraphicsImpl();
    }

    @Override
    public void play() {
        view.setVisible(true);
    }

    @Override
    public void processInput() {
        Command cmd = commandQueue.poll();
        cmd.execute();
        for(var tank : gameState.getWorld().getTanks()){
            tank.updateInput();
        }
        throw new UnsupportedOperationException("Unimplemented method 'processInput'");
    }

    private void loop() {
        
    }
    
}
