package it.unibo.tankBattle.model.world.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.tankBattle.model.world.api.World;
import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.model.gameObject.api.GameObject;
import it.unibo.tankBattle.model.gameObject.impl.FactoryGameObject;
import it.unibo.tankBattle.model.gameState.api.GameState;
import it.unibo.tankBattle.model.gameState.impl.Player;

public class WorldImpl implements World {
    private final Set<GameObject> wallSet;
    private final Set<GameObject> bulletSet;
    private final Map<Player, GameObject> tankMap;
    private final FactoryGameObject factoryGameObject;
    private final GameState gameState;
    private static final int MULTIPLIER_SPEED_SIMPLE_TANK = 2;

    protected WorldImpl(final Set<GameObject> wallSet, final GameState gameState, 
            Map<Player, GameObject> tankMap) {

        this.wallSet = new HashSet<>(wallSet);
        this.bulletSet = new HashSet<>();
        this.tankMap = new HashMap<>(tankMap);

        factoryGameObject = new FactoryGameObject();
        this.gameState = gameState;
    }

    @Override
    public void update() {
        getEntities().stream().forEach(g -> {
            g.update();
            removeDeadGameObject(g);
        });
    }

    @Override
    public void collision(final P2d firstPosition, final P2d secondPosition) {

        final GameObject firstGameObject = getGameObjectFromPosition(firstPosition);
        final GameObject secondGameObject = getGameObjectFromPosition(secondPosition);

        firstGameObject.hit(secondGameObject.getDamage());
        firstGameObject.resolveCollision(secondGameObject);

        secondGameObject.hit(firstGameObject.getDamage());
        secondGameObject.resolveCollision(firstGameObject);
    }

    private GameObject getGameObjectFromPosition (final P2d position) {
        return getEntities()
            .stream()
            .filter(g -> g.getPosition().equals(position))
            .toList()
            .get(0);
    }

    private void removeDeadGameObject(GameObject gameObject) {

        if (!gameObject.isAlive()) {
            if (bulletSet.contains(gameObject)){
                bulletSet.remove(gameObject);
            } else if (bulletSet.contains(gameObject)) {
                bulletSet.remove(gameObject);
            } else {
                for (var tank : tankMap.values()) {
                    if (tank == gameObject) {
                        gameState.isOver();
                    }
                }
            }
        }
    }
    
    @Override
    public Set<GameObject> getEntities() {
        final var entities = new HashSet<GameObject>();
        entities.addAll(wallSet);
        entities.addAll(bulletSet);
        entities.addAll(getTanks());
        return entities;
    }

    @Override
    public Set<GameObject> getWalls() {
        return wallSet;
    }

    @Override
    public Set<GameObject> getBullets() {
        return bulletSet;
    }

    @Override
    public Set<GameObject> getTanks() {
        return tankMap.values().stream().collect(Collectors.toSet());
    }

    @Override
    public void shot(final Player player) {
        /*switch(player.getCode()) {
            case PLAYER_UNO:
                addBullet(tankPlayerOne);
                break;
            case PLAYER_DUE:
                addBullet(tankPlayerTwo);
                break;
            default:
                throw new IllegalStateException();
        }*/
        if(player.getCode() == gameState.getPlayer1().getCode()){
            addBullet(tankPlayerOne);
        }else if(player.getCode() == gameState.getPlayer2().getCode()){
            addBullet(tankPlayerTwo);
        }else{
            throw new IllegalStateException();
        }
    }

    private void addBullet(GameObject tank) {
        bulletSet.add(factoryGameObject.simpleBullet(tank.getSpeed() * MULTIPLIER_SPEED_SIMPLE_TANK, tank));
    }

    @Override
    public void setDirection(final Directions direction, final Player player) {
        /*switch(player) {
            case PLAYER_UNO:
                changeDirection(tankPlayerOne, direction);
                break;
            case PLAYER_DUE:
                changeDirection(tankPlayerTwo, direction);
                break;
            default:
                throw new IllegalStateException();
        }*/
        if(player.getCode() == gameState.getPlayer1().getCode()){
            changeDirection(tankPlayerOne, direction);
        }else if(player.getCode() == gameState.getPlayer2().getCode()){
            changeDirection(tankPlayerTwo, direction);
        }else{
            throw new IllegalStateException();
        }
    }

    private void changeDirection(final GameObject gameObject, final Directions direction) {
        gameObject.setDirection(direction);
    }
}
