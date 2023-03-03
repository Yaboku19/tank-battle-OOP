package it.unibo.tankBattle.controller.impl;

import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.view.api.View;
import it.unibo.tankBattle.view.impl.ViewImpl;

public class BasicGameEngine implements GameEngine {
    private View view;

    public BasicGameEngine() {
        view = new ViewImpl();
    }

    @Override
    public void play() {
        view.setVisible(true);
        view.bugSolve();
    }

    private void loop() {
        
    }
    
}
