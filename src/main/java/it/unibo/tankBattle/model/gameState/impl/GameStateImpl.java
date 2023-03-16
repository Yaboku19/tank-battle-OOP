package it.unibo.tankBattle.model.gameState.impl;

import java.util.stream.Stream;

import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.controller.api.WorldEventListener;
import it.unibo.tankBattle.model.gameObject.api.component.Health;
import it.unibo.tankBattle.model.gameObject.api.object.*;
import it.unibo.tankBattle.model.gameObject.impl.component.Bullet;
import it.unibo.tankBattle.model.gameObject.impl.component.Tank;
import it.unibo.tankBattle.model.gameObject.impl.component.Wall;
import it.unibo.tankBattle.model.gameObject.impl.object.FactoryGameObjectImpl;
import it.unibo.tankBattle.model.gameState.api.*;
import it.unibo.tankBattle.model.world.api.*;
import it.unibo.tankBattle.model.world.impl.FactoryWorldImpl;

public class GameStateImpl implements GameState, CommandListener{
    private final FactoryWorld factoryWorld;
    private World world = null;
    private final WorldEventListener listener;
    private final FactoryGameObject factoryGameObject;

    public GameStateImpl(final WorldEventListener listener) {
        factoryWorld = new FactoryWorldImpl();
        this.listener = listener;
        factoryGameObject = new FactoryGameObjectImpl();
    }

    @Override
    public void createWorld(final Player firstPlayer, final Player secondPlayer) {
        world = factoryWorld.simpleWorld(firstPlayer, secondPlayer);
    }

    @Override
    public void update(final Double time) {
        world.getEntities().forEach(g -> {
            g.update(time);
            if(isdead(g)) {
                removeDeadGameObject(g);
            }
        });
    }

    private boolean isdead(final GameObject gameObject) {
        if (gameObject.getComponent(Health.class).isPresent()) {
            return !gameObject.getComponent(Health.class).get().isAlive();
        } else {
            return false;
        }
    }

    private void removeDeadGameObject(final GameObject gameObject) {
        if(getBullets().toList().contains(gameObject) || getWalls().toList().contains(gameObject)) {
            world.removeGameObject(gameObject);
        } else if (getTanks().toList().contains(gameObject)){
            listener.endGame(gameObject.getComponent(Tank.class).get().getPlayer());
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public void shot(final Player player) {
        world.addGameObject(factoryGameObject
            .createSimpleBullet(getTankFromPlayer(player)));
    }

    @Override
    public void setDirection(final Directions direction, final Player player) {
        getTankFromPlayer(player).setDirection(direction);
    }

    private GameObject getTankFromPlayer(final Player player) {
        return getTanks()
            .filter(t -> t.getComponent(Tank.class).get().getPlayer().equals(player))
            .findFirst()
            .get();
    }

    @Override
    public Stream<GameObject> getTanks() {
        return world.getEntities().filter(g -> g.getComponent(Tank.class).isPresent());
    }

    @Override
    public Stream<GameObject> getBullets() {
        return world.getEntities().filter(g -> g.getComponent(Bullet.class).isPresent());
    }

    @Override
    public Stream<GameObject> getWalls() {
        return world.getEntities().filter(g -> g.getComponent(Wall.class).isPresent());
    }
}
