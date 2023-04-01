package it.unibo.tankbattle.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import it.unibo.tankbattle.common.P2d;
import it.unibo.tankbattle.common.input.api.Direction;
import it.unibo.tankbattle.controller.api.ObjectsManager;
import it.unibo.tankbattle.controller.api.Player;
import it.unibo.tankbattle.controller.impl.ObjectsManagerImpl;
import it.unibo.tankbattle.model.gameobject.api.component.Damageable;
import it.unibo.tankbattle.model.gameobject.api.component.Health;
import it.unibo.tankbattle.model.gameobject.api.component.Movable;
import it.unibo.tankbattle.model.gameobject.api.object.FactoryGameObject;
import it.unibo.tankbattle.model.gameobject.api.object.GameObject;
import it.unibo.tankbattle.model.gameobject.impl.component.CollisionComponent;
import it.unibo.tankbattle.model.gameobject.impl.object.FactoryGameObjectImpl;
import it.unibo.tankbattle.model.gamesetup.impl.TankData;
import it.unibo.tankbattle.model.gamesetup.impl.TankDataList;

/**
 * Class to test GameObject.
 */
class GameObjectTest {

    private FactoryGameObject factory;
    private GameObject tank;
    private GameObject bullet;
    private ObjectsManager<TankData, TankDataList> tankFirstManager;
    private static final Logger LOGGER = Logger.getLogger("GameObjectTestLog");

    private static final double STANDARD_TANK_POS = 10;
    private static final double STANDARD_TANK_DIM = 50;
    private static final double STANDARD_TANK_LIFE = 100;
    private static final double STANDARD_BULLET_DAMAGE = 50;
    private static final double UPDATE_TIME = 10;
    private static final double BULLET_SHOT_PLUS = -25;
    private static final double BULLET_SHOT_MINUS = 45;
    private static final double TANK_MOVEMENT_POS = 11.8;


    /**
     * Init factory test.
     */
    @org.junit.jupiter.api.BeforeEach
    void initFactory() {
        try {
            tankFirstManager = new ObjectsManagerImpl<>(
                ClassLoader.getSystemResource("config/tankConfig.xml").toURI(), TankDataList.class);
        } catch (JAXBException | URISyntaxException e) {
            LOGGER.log(Level.WARNING, "error");
        }
        this.factory = new FactoryGameObjectImpl();
        this.tank = this.factory.createSimpleTank(new P2d(STANDARD_TANK_POS, STANDARD_TANK_POS), createPlayer(tankFirstManager));
        this.bullet = this.factory.createSimpleBullet(this.tank);
    }

    private Player createPlayer(final ObjectsManager<TankData, TankDataList> manObj) {
        return new Player() {

            @Override
            public int getScore() {
                return 1;
            }

            @Override
            public void incScore() {
            }

            @Override
            public String getName() {
                return "0";
            }

            @Override
            public TankData getTankData() {
                return manObj.getActual();
            }

        };
    }

    /**
     * Test tank isAlive.
     */
    @org.junit.jupiter.api.Test
    void testIsAlive() {
        tank.getComponent(CollisionComponent.class).get().resolveCollision(bullet);
        bullet.getComponent(CollisionComponent.class).get().resolveCollision(tank);
        assertTrue(tank.getComponent(Health.class).get().isAlive());

        tank.getComponent(CollisionComponent.class).get().resolveCollision(bullet);
        bullet.getComponent(CollisionComponent.class).get().resolveCollision(tank);
        assertFalse(tank.getComponent(Health.class).get().isAlive());
    }

    /**
     * Tank collision test.
     */
    @org.junit.jupiter.api.Test
    void testCollision() {
        /*
         * var tank2 = this.factory.createSimpleTank(new P2d(20,12), player1);
         * var obstacle1 = this.factory.createSimpleWall(new P2d(15, 20));
         * tank.setDirection(Direction.RIGHT);
         * tank.getComponent(CollisionComponent.class).get().resolveCollision(tank2);
         * assertEquals(new P2d(9.9,10), tank.getTransform().getPosition());
         * tank.getComponent(CollisionComponent.class).get().resolveCollision(obstacle1)
         * ;
         * if(obstacle1.getComponent(ActiveCollidable.class).isPresent())
         * obstacle1.getComponent(ActiveCollidable.class).get().resolveCollision(tank);
         * assertEquals(new P2d(9.9,9.9), tank.getTransform().getPosition());
         * assertEquals(new P2d(15,20), obstacle1.getTransform().getPosition());
         */
    }

    /**
     * test update.
     */
    @org.junit.jupiter.api.Test
    void testUpdate() {
        assertEquals(new P2d(GameObjectTest.STANDARD_TANK_POS, 
                GameObjectTest.STANDARD_TANK_POS), tank.getTransform().getPosition());
        tank.setDirection(Direction.RIGHT);
        tank.update(GameObjectTest.UPDATE_TIME);
        assertEquals(new P2d(GameObjectTest.TANK_MOVEMENT_POS, GameObjectTest.STANDARD_TANK_POS),
        tank.getTransform().getPosition());
        tank.setDirection(Direction.NONE);
        tank.update(UPDATE_TIME);
        assertEquals(new P2d(GameObjectTest.TANK_MOVEMENT_POS, GameObjectTest.STANDARD_TANK_POS),
        tank.getTransform().getPosition());
        assertEquals(Direction.RIGHT, tank.getTransform().getDirection());
    }

    /**
     * 
     */
    @org.junit.jupiter.api.Test
    void testBulletCreation() {
        assertEquals(Direction.UP, bullet.getTransform().getDirection());
        tank.setDirection(Direction.RIGHT);
        assertEquals(new P2d(GameObjectTest.STANDARD_TANK_POS, GameObjectTest.STANDARD_TANK_POS),
            tank.getTransform().getPosition());
        assertEquals(GameObjectTest.STANDARD_TANK_DIM, tank.getTransform().getLength());
        assertEquals(GameObjectTest.STANDARD_TANK_DIM, tank.getTransform().getWidth());
        final var bullet1 = factory.createSimpleBullet(tank);
        assertEquals(new P2d(GameObjectTest.BULLET_SHOT_MINUS, GameObjectTest.STANDARD_TANK_POS),
            bullet1.getTransform().getPosition());
        assertEquals(Direction.RIGHT, bullet1.getTransform().getDirection());

        tank.setDirection(Direction.LEFT);
        final var bullet2 = factory.createSimpleBullet(tank);
        assertEquals(new P2d(GameObjectTest.BULLET_SHOT_PLUS, GameObjectTest.STANDARD_TANK_POS),
            bullet2.getTransform().getPosition());
        assertEquals(Direction.LEFT, bullet2.getTransform().getDirection());

        tank.setDirection(Direction.UP);
        final var bullet3 = factory.createSimpleBullet(tank);
        assertEquals(new P2d(GameObjectTest.STANDARD_TANK_POS, GameObjectTest.BULLET_SHOT_PLUS),
            bullet3.getTransform().getPosition());
        assertEquals(Direction.UP, bullet3.getTransform().getDirection());

        tank.setDirection(Direction.DOWN);
        final var bullet4 = factory.createSimpleBullet(tank);
        assertEquals(new P2d(GameObjectTest.STANDARD_TANK_POS, GameObjectTest.BULLET_SHOT_MINUS),
            bullet4.getTransform().getPosition());
        assertEquals(Direction.DOWN, bullet4.getTransform().getDirection());

        tank.setDirection(Direction.NONE);
        final var bullet5 = factory.createSimpleBullet(tank);
        assertEquals(new P2d(GameObjectTest.STANDARD_TANK_POS, GameObjectTest.BULLET_SHOT_MINUS),
            bullet5.getTransform().getPosition());
        assertEquals(Direction.DOWN, bullet5.getTransform().getDirection());

    }

    /**
     * 
     */
    @org.junit.jupiter.api.Test
    void testAll() {
        tank.setDirection(Direction.RIGHT);
        final var tank2 = this.factory.createSimpleTank(
                new P2d(GameObjectTest.STANDARD_TANK_POS, GameObjectTest.STANDARD_TANK_POS), 
                createPlayer(tankFirstManager));
        tank.getComponent(CollisionComponent.class).get().resolveCollision(tank2);
        tank2.getComponent(CollisionComponent.class).get().resolveCollision(tank);
        assertEquals(GameObjectTest.STANDARD_TANK_LIFE, tank.getComponent(Damageable.class).get().getLifePoints());
        assertEquals(GameObjectTest.STANDARD_TANK_LIFE,
                tank2.getComponent(Damageable.class).get().getLifePoints());

        final var bullet2 = this.factory.createSimpleBullet(tank2);
        tank.getComponent(CollisionComponent.class).get().resolveCollision(bullet2);
        bullet2.getComponent(CollisionComponent.class).get().resolveCollision(tank);
        assertTrue(tank.getComponent(Health.class).get().isAlive());
        assertFalse(bullet2.getComponent(Health.class).get().isAlive());
        assertEquals(GameObjectTest.STANDARD_BULLET_DAMAGE,
        tank.getComponent(Damageable.class).get().getLifePoints());
    }

    /**
     * 
     */
    @org.junit.jupiter.api.Test
    void testDirection() {
        assertEquals(Direction.UP, tank.getTransform().getDirection());

        tank.setDirection(Direction.DOWN);
        assertEquals(Direction.DOWN, tank.getTransform().getDirection());
        assertEquals(Direction.DOWN, tank.getComponent(Movable.class).get().getMovingDirection());

        tank.setDirection(Direction.NONE);
        assertEquals(Direction.DOWN, tank.getTransform().getDirection());

        assertEquals(Direction.NONE, tank.getComponent(Movable.class).get().getMovingDirection());
    }

}
