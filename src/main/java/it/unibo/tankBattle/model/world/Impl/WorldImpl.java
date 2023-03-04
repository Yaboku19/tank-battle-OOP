package it.unibo.tankBattle.model.world.impl;

import java.util.HashSet;
import java.util.Set;

import it.unibo.tankBattle.model.world.api.World;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.model.api.GameState;
import it.unibo.tankBattle.model.gameObject.api.GameObject;
import it.unibo.tankBattle.model.gameObject.impl.FactoryGameObject;

public class WorldImpl implements World {
    private final Set<GameObject> wallSet;
    private final Set<GameObject> bulletSet;
    private final GameObject tankPlayerOne;
    private final GameObject tankPlayerTwo;
    private final FactoryGameObject factoryGameObject;
    private final GameState gameState;

    protected WorldImpl(final Set<GameObject> wallSet, final GameObject tankOne, final GameObject tankTwo, final GameState gameState) {
        this.wallSet = new HashSet<>(wallSet);
        this.bulletSet = new HashSet<>();
        tankPlayerOne = tankOne;
        tankPlayerTwo = tankTwo;
        factoryGameObject = new FactoryGameObject();
        this.gameState = gameState;
    }

    @Override
    public void update() {
        wallSet.stream().forEach(g -> g.update());
        bulletSet.stream().forEach(g -> g.update());
        tankPlayerOne.update();
        tankPlayerTwo.update();
    }

    @Override
    public void collision(GameObject firsGameObject, GameObject secondGameObject) {
        /*
         * 
         * firstGameOBject.hitted(secondGameObject.damage);
         * firstGameObject.collision(secondGameObject.GetPosition());
         * if (!first.gameobject.isAlive()){
         *      if (bulletSet.contain(firstGameObject)) bulletSet.remove(firstGameObject);
         *      if (bulletSet.contain(firstGameObject)) bulletSet.remove(firstGameObject);
         *      if (tankPlayerOne == firstGameObject || tankPlayerOne == secondGameObject)   gameState.isOver();
         * }
         */
    }
    
    @Override
    public Set<GameObject> getEntities() {
        var entities = new HashSet<>(wallSet);
        entities.addAll(bulletSet);
        entities.add(tankPlayerOne);
        entities.add(tankPlayerTwo);
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
    public GameObject firstTank() {
        return tankPlayerOne;
    }

    @Override
    public GameObject secondTank() {
        return tankPlayerTwo;
    }

    @Override
    public void addBullet(GameObject tank) {
        bulletSet.add(factoryGameObject.simpleBullet(10, tank.getPosition(), tank));
    }

    @Override
    public void changeDirection(Directions direction, int player) {
        if(player == 1) {
            tankPlayerOne.setDirection(direction);
            tankPlayerOne.move();
        } else if (player == 2) {
            tankPlayerTwo.setDirection(direction);
            tankPlayerTwo.move();
        } else {
            throw new IllegalStateException();
        }
    }
}
