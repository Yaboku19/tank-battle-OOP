package it.unibo.tankBattle;

import static org.junit.jupiter.api.Assertions.*;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Direction;
import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.model.gameObject.api.component.Health;
import it.unibo.tankBattle.model.gameObject.api.component.Movable;
import it.unibo.tankBattle.model.gameObject.api.object.FactoryGameObject;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;
import it.unibo.tankBattle.model.gameObject.impl.component.CollisionComponent;
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
		tank.getComponent(CollisionComponent.class).get().resolveCollision(bullet);
		bullet.getComponent(CollisionComponent.class).get().resolveCollision(tank);
		assertTrue(tank.getComponent(Health.class).get().isAlive());

		tank.getComponent(CollisionComponent.class).get().resolveCollision(bullet);
		bullet.getComponent(CollisionComponent.class).get().resolveCollision(tank);
		assertFalse(tank.getComponent(Health.class).get().isAlive());
	}

	@org.junit.jupiter.api.Test
	public void testCollision() {
		/*var tank2 = this.factory.createSimpleTank(new P2d(20,12), player1);
		var obstacle1 = this.factory.createSimpleWall(new P2d(15, 20));
		tank.setDirection(Direction.RIGHT);
		tank.getComponent(CollisionComponent.class).get().resolveCollision(tank2);
		assertEquals(new P2d(9.9,10), tank.getTransform().getPosition());
		tank.getComponent(CollisionComponent.class).get().resolveCollision(obstacle1);
		if(obstacle1.getComponent(ActiveCollidable.class).isPresent())
			obstacle1.getComponent(ActiveCollidable.class).get().resolveCollision(tank);
		assertEquals(new P2d(9.9,9.9), tank.getTransform().getPosition());
		assertEquals(new P2d(15,20), obstacle1.getTransform().getPosition());*/
	}

	@org.junit.jupiter.api.Test
	public void testUpdate() {
		assertEquals(new P2d(10,10), tank.getTransform().getPosition());
		tank.setDirection(Direction.RIGHT);
		tank.update(10);
		assertEquals(new P2d(11,10), tank.getTransform().getPosition());
		tank.setDirection(Direction.NONE);
		tank.update(1);
		assertEquals(new P2d(11,10), tank.getTransform().getPosition());
		assertEquals(Direction.RIGHT, tank.getTransform().getDirection());
	}

	@org.junit.jupiter.api.Test
	public void testBulletCreation() {
		assertEquals(Direction.UP, bullet.getTransform().getDirection());
		tank.setDirection(Direction.RIGHT);
		assertEquals(new P2d(10, 10), tank.getTransform().getPosition());
		assertEquals(50, tank.getTransform().getLength());
		assertEquals(50, tank.getTransform().getWidth());
		var bullet1 = factory.createSimpleBullet(tank);
		assertEquals(new P2d(45, 10), bullet1.getTransform().getPosition());
		assertEquals(Direction.RIGHT, bullet1.getTransform().getDirection());
		
		tank.setDirection(Direction.LEFT);
		var bullet2 = factory.createSimpleBullet(tank);
		assertEquals(new P2d(-25, 10), bullet2.getTransform().getPosition());
		assertEquals(Direction.LEFT, bullet2.getTransform().getDirection());

		tank.setDirection(Direction.UP);
		var bullet3 = factory.createSimpleBullet(tank);
		assertEquals(new P2d(10, -25), bullet3.getTransform().getPosition());
		assertEquals(Direction.UP, bullet3.getTransform().getDirection());

		tank.setDirection(Direction.DOWN);
		var bullet4 = factory.createSimpleBullet(tank);
		assertEquals(new P2d(10, 45), bullet4.getTransform().getPosition());
		assertEquals(Direction.DOWN, bullet4.getTransform().getDirection());

		tank.setDirection(Direction.NONE);
		var bullet5 = factory.createSimpleBullet(tank);
		assertEquals(new P2d(10, 45), bullet5.getTransform().getPosition());
		assertEquals(Direction.DOWN, bullet5.getTransform().getDirection());

	}

	@org.junit.jupiter.api.Test
	public void testAll() {
		/*tank.setDirection(Direction.RIGHT);
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
		assertEquals(50, tank.getComponent(TankHealth.class).get().getLifePoints());*/
	}

	@org.junit.jupiter.api.Test
	public void testDirection() {
		assertEquals(Direction.UP, tank.getTransform().getDirection());

		tank.setDirection(Direction.DOWN);
		assertEquals(Direction.DOWN, tank.getTransform().getDirection());
		assertEquals(Direction.DOWN ,tank.getComponent(Movable.class).get().getMovingDirection());

		tank.setDirection(Direction.NONE);
		assertEquals(Direction.DOWN, tank.getTransform().getDirection());

		assertEquals(Direction.NONE ,tank.getComponent(Movable.class).get().getMovingDirection());
	}

}
