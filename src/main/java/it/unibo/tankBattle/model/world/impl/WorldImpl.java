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

        firstGameObject.resolveCollision(secondGameObject);

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
                for (Player player : tankMap.keySet()) {
                    if (tankMap.get(player) == gameObject) {
                        gameState.isOver(player);
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
        bulletSet.add(factoryGameObject
            .simpleBullet(tankMap.get(player).getSpeed() * MULTIPLIER_SPEED_SIMPLE_TANK, tankMap.get(player)));
    }

    @Override
    public void setDirection(final Directions direction, final Player player) {
        tankMap.get(player).setDirection(direction);
    }
}
