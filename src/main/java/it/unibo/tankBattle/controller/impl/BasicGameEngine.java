package it.unibo.tankBattle.controller.impl;

import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.view.api.Graphics;
import it.unibo.tankBattle.view.impl.GraphicsImpl;

public class BasicGameEngine implements GameEngine {
    private Graphics view;

    public BasicGameEngine() {
        view = new GraphicsImpl();
    }

    @Override
    public void play() {
        view.setVisible(true);
    }

    private void loop() {
        
    }
    
}
