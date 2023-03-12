package it.unibo.tankBattle.model.gameState.impl;

import java.util.stream.Stream;

import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.controller.api.WorldEventListener;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;
import it.unibo.tankBattle.model.gameState.api.GameState;
import it.unibo.tankBattle.model.gameState.api.Player;
import it.unibo.tankBattle.model.world.api.FactoryWorld;
import it.unibo.tankBattle.model.world.api.World;
import it.unibo.tankBattle.model.world.impl.FactoryWorldImpl;

public class GameStateImpl implements GameState {
    private final FactoryWorld factoryWorld;
    private World world = null;
    private final WorldEventListener listener;
    private Player firstPlayer = null;
    private Player secondPlayer = null;

    public GameStateImpl(final WorldEventListener listener) {
        factoryWorld = new FactoryWorldImpl();
        this.listener = listener;
    }

    @Override
    public void createWorld() {
        firstPlayer = new PlayerImpl();
        secondPlayer = new PlayerImpl();
        world = factoryWorld.simpleWorld(firstPlayer, secondPlayer);
    }

    @Override
    public void update(final Double time) {
        world.getEntities().forEach(g -> g.update(time));
    }

    @Override
    public void shot(Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'shot'");
    }

    @Override
    public void setDirection(Directions direction, Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDirection'");
    }

    @Override
    public Stream<GameObject> getTanks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTanks'");
    }

    @Override
    public Stream<GameObject> getBullets() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBullets'");
    }

    @Override
    public Stream<GameObject> getWalls() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWalls'");
    }

    @Override
    public Player getFirstPlayer() {
        return firstPlayer;
    }

    @Override
    public Player getSecondPlayer() {
        return secondPlayer;
    } 
}
