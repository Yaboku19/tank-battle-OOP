package it.unibo.tankBattle;

import static org.junit.jupiter.api.Assertions.*;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.model.gameObject.api.component.ActiveCollidable;
import it.unibo.tankBattle.model.gameObject.api.component.Health;
import it.unibo.tankBattle.model.gameObject.api.component.Movable;
import it.unibo.tankBattle.model.gameObject.api.object.FactoryGameObject;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;
import it.unibo.tankBattle.model.gameObject.impl.component.TankHealth;
import it.unibo.tankBattle.model.gameObject.impl.object.FactoryGameObjectImpl;

public class GameObjectTest {
    
    private FactoryGameObject factory;
	private GameObject tank;
	private GameObject bullet;
	private GameObject obstacle;
	private Player player1;

    @org.junit.jupiter.api.BeforeEach
	public void initFactory() {
	this.factory = new FactoryGameObjectImpl();
	this.tank = this.factory.createSimpleTank(new P2d(10,10), player1);
	this.bullet = this.factory.createSimpleBullet(this.tank);
	this.obstacle = this.factory.createSimpleWall(new P2d(20, 20));
	}

	@org.junit.jupiter.api.Test
	public void testIsAlive() {
		tank.getComponent(ActiveCollidable.class).get().resolveCollision(bullet);
		assertTrue(tank.getComponent(Health.class).get().isAlive());
		tank.getComponent(ActiveCollidable.class).get().resolveCollision(bullet);
		assertFalse(tank.getComponent(Health.class).get().isAlive());
	}

	@org.junit.jupiter.api.Test
	public void testCollision() {
		var tank2 = this.factory.createSimpleTank(new P2d(20,12), player1);
		var obstacle1 = this.factory.createSimpleWall(new P2d(15, 20));
		tank.getComponent(ActiveCollidable.class).get().resolveCollision(tank2);
		assertEquals(new P2d(9.9,10), tank.getTransform().getPosition());
		tank.getComponent(ActiveCollidable.class).get().resolveCollision(obstacle1);
		if(obstacle1.getComponent(ActiveCollidable.class).isPresent())
			obstacle1.getComponent(ActiveCollidable.class).get().resolveCollision(tank);
		assertEquals(new P2d(9.9,9.9), tank.getTransform().getPosition());
		assertEquals(new P2d(15,20), obstacle1.getTransform().getPosition());
	}

	@org.junit.jupiter.api.Test
	public void testUpdate() {
		assertEquals(new P2d(10,10), tank.getTransform().getPosition());
		tank.setDirection(Directions.RIGHT);
		tank.update(10);
		assertEquals(new P2d(11,10), tank.getTransform().getPosition());
		tank.setDirection(Directions.NONE);
		tank.update(1);
		assertEquals(new P2d(11,10), tank.getTransform().getPosition());
		assertEquals(Directions.RIGHT, tank.getTransform().getDirection());
	}

	@org.junit.jupiter.api.Test
	public void testBulletCreation() {
		assertEquals(Directions.UP, bullet.getTransform().getDirection());
		tank.setDirection(Directions.RIGHT);
		assertEquals(new P2d(10, 10), tank.getTransform().getPosition());
		assertEquals(50, tank.getTransform().getLength());
		assertEquals(50, tank.getTransform().getWidth());
		var bullet1 = factory.createSimpleBullet(tank);
		assertEquals(new P2d(45, 10), bullet1.getTransform().getPosition());
		assertEquals(Directions.RIGHT, bullet1.getTransform().getDirection());
		
		tank.setDirection(Directions.LEFT);
		var bullet2 = factory.createSimpleBullet(tank);
		assertEquals(new P2d(-25, 10), bullet2.getTransform().getPosition());
		assertEquals(Directions.LEFT, bullet2.getTransform().getDirection());

		tank.setDirection(Directions.UP);
		var bullet3 = factory.createSimpleBullet(tank);
		assertEquals(new P2d(10, -25), bullet3.getTransform().getPosition());
		assertEquals(Directions.UP, bullet3.getTransform().getDirection());

		tank.setDirection(Directions.DOWN);
		var bullet4 = factory.createSimpleBullet(tank);
		assertEquals(new P2d(10, 45), bullet4.getTransform().getPosition());
		assertEquals(Directions.DOWN, bullet4.getTransform().getDirection());

		tank.setDirection(Directions.NONE);
		var bullet5 = factory.createSimpleBullet(tank);
		assertEquals(new P2d(10, 45), bullet5.getTransform().getPosition());
		assertEquals(Directions.DOWN, bullet5.getTransform().getDirection());

	}

	@org.junit.jupiter.api.Test
	public void testAll() {
		tank.setDirection(Directions.RIGHT);
		var tank2 = this.factory.createSimpleTank(new P2d(20,12), player1);
		tank.getComponent(ActiveCollidable.class).get().resolveCollision(tank2);
		tank2.getComponent(ActiveCollidable.class).get().resolveCollision(tank);
		assertEquals(100, tank.getComponent(TankHealth.class).get().getLifePoints());
		assertEquals(100, tank2.getComponent(TankHealth.class).get().getLifePoints());
		
		var bullet2 = this.factory.createSimpleBullet(tank2);
		tank.getComponent(ActiveCollidable.class).get().resolveCollision(bullet2);
		bullet2.getComponent(ActiveCollidable.class).get().resolveCollision(tank);
		assertTrue(tank.getComponent(Health.class).get().isAlive());
		assertFalse(bullet2.getComponent(Health.class).get().isAlive());
		assertEquals(50, tank.getComponent(TankHealth.class).get().getLifePoints());

		tank.getComponent(ActiveCollidable.class).get().resolveCollision(obstacle);
		assertEquals(50, tank.getComponent(TankHealth.class).get().getLifePoints());
	}

	@org.junit.jupiter.api.Test
	public void testDirection() {
		assertEquals(Directions.UP, tank.getTransform().getDirection());

		tank.setDirection(Directions.DOWN);
		assertEquals(Directions.DOWN, tank.getTransform().getDirection());
		assertEquals(Directions.DOWN ,tank.getComponent(Movable.class).get().getMovingDirection());

		tank.setDirection(Directions.NONE);
		assertEquals(Directions.DOWN, tank.getTransform().getDirection());

		assertEquals(Directions.NONE ,tank.getComponent(Movable.class).get().getMovingDirection());
	}

}
