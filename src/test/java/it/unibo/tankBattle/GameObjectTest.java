package it.unibo.tankBattle;

import static org.junit.jupiter.api.Assertions.*;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.model.gameObject.api.GameObject;
import it.unibo.tankBattle.model.gameObject.impl.FactoryGameObject;
import it.unibo.tankBattle.model.gameObject.impl.GameObjectImpl;

public class GameObjectTest {
    
    private FactoryGameObject factory;
	private GameObject tank = this.factory.simpleTank(1, new P2d(1,1), 100, 10);
	private GameObject bullet = this.factory.simpleBullet(20,new P2d(1, 1), tank);
	private GameObject obstacle = this.factory.simpleWall(new P2d(10, 20));

    @org.junit.jupiter.api.BeforeEach
	public void initFactory() {
	this.factory = new FactoryGameObject();
	}

	@org.junit.jupiter.api.Test
	public void testEvenNumbers() {        
	
	}
}
