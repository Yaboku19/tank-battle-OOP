package it.unibo.tankBattle;

import static org.junit.jupiter.api.Assertions.*;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.model.gameObject.api.component.Collidable;
import it.unibo.tankBattle.model.gameObject.api.component.Health;
import it.unibo.tankBattle.model.gameObject.api.object.FactoryGameObject;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;
import it.unibo.tankBattle.model.gameObject.impl.object.FactoryGameObjectImpl;

public class GameObjectTest {
    
    private FactoryGameObject factory;
	GameObject tank;
	GameObject bullet;
	GameObject obstacle;

    @org.junit.jupiter.api.BeforeEach
	public void initFactory() {
	this.factory = new FactoryGameObjectImpl();
	tank = this.factory.createSimpleTank(new P2d(10,10));
	bullet = this.factory.createSimpleBullet(tank);
	obstacle = this.factory.createSimpleWall(new P2d(10, 20));
	}

	@org.junit.jupiter.api.Test
	public void testIsAlive() {
		tank.getComponent(Collidable.class).get().resolveCollision(bullet);
		assertTrue(tank.getComponent(Health.class).get().isAlive());
		tank.getComponent(Collidable.class).get().resolveCollision(bullet);
		assertFalse(tank.getComponent(Health.class).get().isAlive());
	}

	@org.junit.jupiter.api.Test
	public void testCollision() {
		var tank2 = this.factory.createSimpleTank(new P2d(20,12));
		var obstacle1 = this.factory.createSimpleWall(new P2d(15, 20));
		tank.getComponent(Collidable.class).get().resolveCollision(tank2);
		assertEquals(new P2d(9,10), tank.getTransform().getPosition());
		tank.getComponent(Collidable.class).get().resolveCollision(obstacle1);
		if(obstacle1.getComponent(Collidable.class).isPresent())
			obstacle1.getComponent(Collidable.class).get().resolveCollision(tank);
		assertEquals(new P2d(9,9), tank.getTransform().getPosition());
		assertEquals(new P2d(15,20), obstacle1.getTransform().getPosition());
	}

	@org.junit.jupiter.api.Test
	public void testUpdate() {
		/*assertEquals(new P2d(10,10), tank.getTransform().getPosition());
		tank.setDirection(Directions.RIGHT);
		tank.update();
		assertEquals(new P2d(11,10), tank.getTransform().getPosition());
		tank.setDirection(Directions.NONE);
		tank.update();
		assertEquals(new P2d(11,10), tank.getTransform().getPosition());
		assertEquals(Directions.RIGHT, tank.getTransform().getDirection());*/
	}

	@org.junit.jupiter.api.Test
	public void testBulletCreation() {
		tank.setDirection(Directions.RIGHT);
		assertEquals(new P2d(10, 10), tank.getTransform().getPosition());
		assertEquals(10, tank.getTransform().getLength());
		assertEquals(10, tank.getTransform().getWidth());
		var bullet1 = factory.createSimpleBullet(tank);
		assertEquals(new P2d(20, 10), bullet1.getTransform().getPosition());
		tank.setDirection(Directions.LEFT);
		var bullet2 = factory.createSimpleBullet(tank);
		assertEquals(new P2d(0, 10), bullet2.getTransform().getPosition());
		tank.setDirection(Directions.UP);
		var bullet3 = factory.createSimpleBullet(tank);
		assertEquals(new P2d(10, 0), bullet3.getTransform().getPosition());
		tank.setDirection(Directions.DOWN);
		var bullet4 = factory.createSimpleBullet(tank);
		assertEquals(new P2d(10, 20), bullet4.getTransform().getPosition());
		tank.setDirection(Directions.NONE);
		var bullet5 = factory.createSimpleBullet(tank);
		assertEquals(new P2d(10, 20), bullet5.getTransform().getPosition());
	}

	@org.junit.jupiter.api.Test
	public void testAll() {
		/*tank.setDirection(Directions.RIGHT);
		var tank2 = this.factory.createSimpleTank(new P2d(20,12));
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
		assertTrue(obstacle.isAlive());*/
	}

	@org.junit.jupiter.api.Test
	public void testDirection() {
		assertEquals(Directions.UP, tank.getTransform().getDirection());

		tank.setDirection(Directions.DOWN);
		assertEquals(Directions.DOWN, tank.getTransform().getDirection());


		tank.setDirection(Directions.NONE);
		assertEquals(Directions.DOWN, tank.getTransform().getDirection());
	}

}
