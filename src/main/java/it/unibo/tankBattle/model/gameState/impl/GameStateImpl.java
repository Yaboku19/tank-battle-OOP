package it.unibo.tankBattle.model.gameState.impl;

import java.util.Set;
import java.util.stream.Collectors;
import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.Pair;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.model.gameState.api.GameState;
import it.unibo.tankBattle.model.gameState.api.Player;
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
        playerOne = new PlayerImpl();
        playerTwo = new PlayerImpl();
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
    public void resolveEvents(final Set<Pair<P2d, P2d>> events) {
        events.forEach(p -> world.collision(p.getX(), p.getY()));
    }

    @Override
    public void endGame(final Player player) {
        player.incScore();
        controller.endgame();
    }

    @Override
    public void input() {
        // TODO Auto-generated method stub
    }

    @Override
    public Player getFirstPlayer() {
        return playerOne;
    }

    @Override
    public Player getSecondPlayer() {
        return playerTwo;
        
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
    public Set<P2d> getWallPositions() {
        return world
            .getWalls()
            .stream()
            .map(wall -> wall.getPosition())
            .collect(Collectors.toSet());
    }

    @Override
    public Set<Pair<P2d, Directions>> getBulletPositionsAndDirection() {
        return world
            .getBullets()
            .stream()
            .map(bullet -> new Pair<>(bullet.getPosition(), bullet.getDirection()))
            .collect(Collectors.toSet());
    }

    @Override
    public Pair<P2d, Directions> getTankPositionAndDirection(final Player player) {
        return new Pair<>(world.getTank(player).getPosition(), world.getTank(player).getDirection());
    }
}
