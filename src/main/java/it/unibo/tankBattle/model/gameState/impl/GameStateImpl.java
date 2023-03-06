package it.unibo.tankBattle.model.gameState.impl;

import java.util.Set;
import java.util.stream.Collectors;
import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.Pair;
import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.model.gameState.api.GameState;
import it.unibo.tankBattle.model.world.api.World;
import it.unibo.tankBattle.model.world.impl.FactoryWorld;



public class GameStateImpl implements GameState {

    private final World world;
    private final FactoryWorld factory;
    private final Player playerOne;
    private final Player playerTwo;
    private final GameEngine controller;

    public GameStateImpl(final GameEngine controller) {
        factory = new FactoryWorld(this);
        playerOne = new Player();
        playerTwo = new Player();
        this.world = factory.simpleWorld(playerOne, playerTwo);
        this.controller = controller;

    }

    @Override
    public Pair<Integer, Integer> getScore() {
        return new Pair<>(playerOne.getScore(), playerTwo.getScore());
    }

    @Override
    public void update() {
        this.world.update();
    }

    @Override
    public void resolveEvents(Set<Pair<P2d, P2d>> events) {
        events.forEach(p -> world.collision(p.getX(), p.getY()));
    }

    @Override
    public void isOver(Player player) {
        player.incScore();
    }

    @Override
    public Set<Pair<P2d, Integer>> getPositionsAndLength() {
        return world
                .getEntities()
                .stream()
                .map(obj -> new Pair<>(obj.getPosition(), obj.getLength()))
                .collect(Collectors.toSet());
    }

    @Override
    public void input() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'input'");
    }

    @Override
    public Player getFirstPlayer() {
        return playerOne;
    }

    @Override
    public Player getSecondPlayer() {
        return playerTwo;
    }
}
