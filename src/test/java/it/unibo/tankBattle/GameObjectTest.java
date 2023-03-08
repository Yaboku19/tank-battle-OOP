package it.unibo.tankBattle;

import static org.junit.jupiter.api.Assertions.*;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.model.gameObject.api.GameObject;
import it.unibo.tankBattle.model.gameObject.impl.FactoryGameObject;

public class GameObjectTest {
    
    private FactoryGameObject factory;
	GameObject tank;
	GameObject bullet;
	GameObject obstacle;

    @org.junit.jupiter.api.BeforeEach
	public void initFactory() {
	this.factory = new FactoryGameObject();
	tank = this.factory.standardTank(new P2d(10,10));
	bullet = this.factory.simpleBullet(tank);
	obstacle = this.factory.simpleWall(new P2d(10, 20));
	}

	@org.junit.jupiter.api.Test
	public void testIsAlive() {
		tank.resolveCollision(bullet);
		assertTrue(tank.isAlive());
		tank.resolveCollision(bullet);
		assertFalse(tank.isAlive());
	}

	@org.junit.jupiter.api.Test
	public void testCollision() {
		var tank2 = this.factory.standardTank(new P2d(20,12));
		var obstacle1 = this.factory.simpleWall(new P2d(15, 20));
		tank.resolveCollision(tank2);
		assertEquals(new P2d(9,10), tank.getPosition());
		tank.resolveCollision(obstacle1);
		obstacle1.resolveCollision(tank);
		assertEquals(new P2d(9,9), tank.getPosition());
		assertEquals(new P2d(15,20), obstacle1.getPosition());
	}

	@org.junit.jupiter.api.Test
	public void testUpdate() {
		assertEquals(new P2d(10,10), tank.getPosition());
		tank.setDirection(Directions.RIGHT);
		tank.update();
		assertEquals(new P2d(11,10), tank.getPosition());
		tank.setDirection(Directions.NONE);
		tank.update();
		assertEquals(new P2d(11,10), tank.getPosition());
		assertEquals(Directions.RIGHT, tank.getDirection());
	}

	@org.junit.jupiter.api.Test
	public void testBulletCreation() {
		tank.setDirection(Directions.RIGHT);
		var bullet1 = factory.simpleBullet(tank);
		assertEquals(new P2d(20, 10), bullet1.getPosition());
		tank.setDirection(Directions.LEFT);
		var bullet2 = factory.simpleBullet(tank);
		assertEquals(new P2d(0, 10), bullet2.getPosition());
		tank.setDirection(Directions.UP);
		var bullet3 = factory.simpleBullet(tank);
		assertEquals(new P2d(10, 0), bullet3.getPosition());
		tank.setDirection(Directions.DOWN);
		var bullet4 = factory.simpleBullet(tank);
		assertEquals(new P2d(10, 20), bullet4.getPosition());
	}

	@org.junit.jupiter.api.Test
	public void testAll() {
		tank.setDirection(Directions.RIGHT);
		var tank2 = this.factory.standardTank(new P2d(20,12));
		tank.resolveCollision(tank2);
		tank2.resolveCollision(tank);
		assertEquals(95, tank.getLifePoints());
		assertEquals(95, tank2.getLifePoints());
		
		var bullet2 = this.factory.simpleBullet(tank2);
		tank.resolveCollision(bullet2);
		bullet2.resolveCollision(tank);
		assertTrue(tank.isAlive());
		assertFalse(bullet2.isAlive());
		assertEquals(45, tank.getLifePoints());

		tank.resolveCollision(obstacle);
		assertEquals(45, tank.getLifePoints());
		assertTrue(obstacle.isAlive());
	}

	@org.junit.jupiter.api.Test
	public void testDirection() {
		assertEquals(Directions.UP, tank.getDirection());

		tank.setDirection(Directions.DOWN);
		assertEquals(Directions.DOWN, tank.getDirection());


		tank.setDirection(Directions.NONE);
		assertEquals(Directions.DOWN, tank.getDirection());
	}

}
