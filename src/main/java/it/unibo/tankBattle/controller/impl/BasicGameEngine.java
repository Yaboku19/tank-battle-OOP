package it.unibo.tankBattle.controller.impl;

import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.model.api.GameState;
import it.unibo.tankBattle.model.impl.GameStateImpl;
import it.unibo.tankBattle.view.api.View;
import it.unibo.tankBattle.view.impl.ViewImpl;

public class BasicGameEngine implements GameEngine {
    private View view;
    private GameState model;

    public BasicGameEngine() {
        view = new ViewImpl(this);
    }

    @Override
    public void play() {
        view.setVisible(true);
        view.bugSolve();
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
