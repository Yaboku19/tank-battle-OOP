package it.unibo.tankBattle.model.gameState.impl;

import java.util.stream.Stream;

import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.common.input.api.Direction;
import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.controller.api.WorldEventListener;
import it.unibo.tankBattle.model.collision.api.CollisionManager;
import it.unibo.tankBattle.model.collision.impl.CollisionDetectorImpl;
import it.unibo.tankBattle.model.collision.impl.CollisionManagerImpl;
import it.unibo.tankBattle.model.gameObject.api.component.Damageable;
import it.unibo.tankBattle.model.gameObject.api.component.Health;
import it.unibo.tankBattle.model.gameObject.api.component.Tank;
import it.unibo.tankBattle.model.gameObject.api.object.*;
import it.unibo.tankBattle.model.gameObject.impl.component.Bullet;
import it.unibo.tankBattle.model.gameObject.impl.component.Wall;
import it.unibo.tankBattle.model.gameObject.impl.object.FactoryGameObjectImpl;
import it.unibo.tankBattle.model.gameSetup.impl.MapData;
import it.unibo.tankBattle.model.gameState.api.*;
import it.unibo.tankBattle.model.world.api.*;
import it.unibo.tankBattle.model.world.impl.FactoryWorldImpl;

public class GameStateImpl implements GameState {
    
    private final FactoryWorld factoryWorld;
    private World world = null;
    private final WorldEventListener listener;
    private final FactoryGameObject factoryGameObject;
    private final CollisionManager collisionManager;

    public GameStateImpl(final WorldEventListener listener) {
        factoryWorld = new FactoryWorldImpl();
        this.listener = listener;
        factoryGameObject = new FactoryGameObjectImpl();
        collisionManager = new CollisionManagerImpl(new CollisionDetectorImpl());
    }

    @Override
    public void createWorld(final Player firstPlayer, final Player secondPlayer, final MapData DataList) {
        world = factoryWorld.simpleWorld(firstPlayer, secondPlayer, DataList);
    }

    @Override
    public void update(final Double time) {
        world.getEntities().forEach(g -> g.update(time));
        world.getEntities().filter(this::isDead).toList().forEach(this::removeDeadGameObject);
        collisionManager.manageCollisions(world.getEntities());
    }

    private boolean isDead(final GameObject gameObject) {
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

    private Stream<GameObject> getBullets() {
        return world.getEntities()
            .filter(g -> g.getComponent(Bullet.class).isPresent());
    }

    private Stream<GameObject> getWalls() {
        return world.getEntities()
            .filter(g -> g.getComponent(Wall.class).isPresent());
    }

    @Override
    public void shot(final Player player) {
        if(getTankFromPlayer(player).getComponent(Tank.class).get().canShot()) {
            world.addGameObject(factoryGameObject
                .createSimpleBullet(getTankFromPlayer(player)));
        }
    }

    @Override
    public void setDirection(final Direction direction, final Player player) {
        getTankFromPlayer(player).setDirection(direction);
    }

    private GameObject getTankFromPlayer(final Player player) {
        return getTanks()
            .filter(t -> t.getComponent(Tank.class).get().getPlayer().equals(player))
            .findFirst()
            .get();
    }

    private Stream<GameObject> getTanks() {
        return world.getEntities().filter(g -> g.getComponent(Tank.class).isPresent());
    }

    @Override
    public Stream<Transform> getBulletsTrasform() {
        return getBullets().map(b -> b.getTransform());
    }

    @Override
    public Stream<Transform> getWallsTrasform() {
        /*return world.getEntities().filter(g -> g.getComponent(Wall.class).isPresent());*/
        return getWalls()
                .map(w -> w.getTransform());
    }

    @Override
    public Transform getTankTrasform(Player player) {
        return getTankFromPlayer(player).getTransform();
    }

    @Override
    public int getTankLife(Player player) {
        return this.getTankFromPlayer(player)
                .getComponent(Damageable.class)
                .get()
                .getLifePoints();
    }
}
