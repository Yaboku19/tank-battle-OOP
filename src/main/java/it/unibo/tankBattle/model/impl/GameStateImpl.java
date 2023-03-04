package it.unibo.tankBattle.model.impl;

import it.unibo.tankBattle.model.api.GameState;
import it.unibo.tankBattle.model.world.Api.World;
import it.unibo.tankBattle.model.world.Impl.FactoryWorld;


public class GameStateImpl implements GameState{
    private final World world;
    private final FactoryWorld factory;

    public GameStateImpl() {
        factory = new FactoryWorld();
        this.world = factory.simpleWorld();
    }

    @Override
    public void getScore() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getScore'");
    }

    @Override
    public boolean isOver() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isOver'");
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void increaseScore() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'increaseScore'");
    }
    
}
