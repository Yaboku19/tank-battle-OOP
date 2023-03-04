package it.unibo.tankBattle;

import static org.junit.jupiter.api.Assertions.*;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.model.gameObject.api.GameObject;
import it.unibo.tankBattle.model.gameObject.impl.FactoryGameObject;

public class GameObjectTest {
    
    private FactoryGameObject factory;
	GameObject tank;
	GameObject bullet;
	GameObject obstacle;

	
	//private GameObject bullet = this.factory.simpleBullet(20,new P2d(1, 1), tank);
	//private GameObject obstacle = this.factory.simpleWall(new P2d(10, 20));
	private String str = "nice";

    @org.junit.jupiter.api.BeforeEach
	public void initFactory() {
	this.factory = new FactoryGameObject();
	tank = this.factory.simpleTank(1, new P2d(1,1), 100, 10);
	bullet = this.factory.simpleBullet(20, tank);
	obstacle = this.factory.simpleWall(new P2d(10, 20));
	}

	@org.junit.jupiter.api.Test
	public void testIsAlive() {
		tank.hit(90);
		assertTrue(tank.isAlive(), str);
		tank.hit(90);
		assertFalse(tank.isAlive(), str);

	}

}
