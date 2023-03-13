package it.unibo.tankBattle.controller.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.model.gameState.api.GameState;
import it.unibo.tankBattle.model.gameState.impl.GameStateImpl;
import it.unibo.tankBattle.model.gameState.api.Player;
import it.unibo.tankBattle.view.api.View;
import it.unibo.tankBattle.view.impl.ViewImpl;
import it.unibo.tankBattle.common.Pair;
import it.unibo.tankBattle.common.input.api.*;


public class BasicGameEngine implements GameEngine {
    private View view;
    private GameState model;
    private Queue<Pair<Player,Command>> commandQueue = new LinkedList<>();
    private HashMap<Player,InputController> controllers;

    public BasicGameEngine() {
        view = new ViewImpl(this);
        model = new GameStateImpl(this);
    }

    @Override
    public void play() {
        initGame();
        /*view.setVisible(true);
        view.bugSolve();*/
    }

    private void processInput() {
        var cmd = commandQueue.poll();
        if(cmd.getX() == model.getFirstPlayer()){
            cmd.getY().execute(model.getFirstPlayer());
        }else{
            cmd.getY().execute(model.getSecondPlayer());
        }
        /*cmd.execute(cmd);*/
        /*for(var tank : model.getWorld().getTanks()){
            tank.updateInput();
        }*/
        //throw new UnsupportedOperationException("Unimplemented method 'processInput'");
    }

    private void loop() {
        processInput();
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
        /*
         * new instance of model
         */
        loop();
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'endgame'");
    }
    
}
