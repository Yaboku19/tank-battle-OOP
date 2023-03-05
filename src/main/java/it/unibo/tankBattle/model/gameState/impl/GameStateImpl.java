package it.unibo.tankBattle.model.gameState.impl;

import java.util.Set;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.Pair;
import it.unibo.tankBattle.model.gameState.api.GameState;
import it.unibo.tankBattle.model.world.api.World;
import it.unibo.tankBattle.model.world.impl.FactoryWorld;



public class GameStateImpl implements GameState{
    private final World world;
    private final FactoryWorld factory;

    public GameStateImpl() {
        factory = new FactoryWorld(this);
        this.world = factory.simpleWorld();

    }

    @Override
    public Pair<Integer, Integer> getScore() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getScore'");
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void resolveEvents(Set<Pair<P2d, P2d>> events) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resolveEvents'");
    }

    @Override
    public void isOver() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isOver'");
    }

    @Override
    public Set<Pair<P2d, Integer>> getPositionsAndLenght() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPositionsAndLenght'");
    }

    @Override
    public void input() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'input'");
    }


    
}
