package it.unibo.tankBattle;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.model.api.GameObject;
import it.unibo.tankBattle.model.impl.FactoryGameObject;
import it.unibo.tankBattle.model.world.FactoryWorld;

public class WorldTest {
	private FactoryWorld factory;
	private FactoryGameObject factory2;
	private final static int ROW = 9;
    private final static int COLUMN = 14;
    private final static int SIZE = 3;
    private final static int STDSPEED = 10;
    private final static int STDHEALTH = 1000;
    private final static int STDDAMAGE = 1;

    @org.junit.jupiter.api.BeforeEach       
	public void initFactory() {
		factory = new FactoryWorld();
		factory2 = new FactoryGameObject();
    }

    @org.junit.jupiter.api.Test            
	public void getEntities() {        
		var world = factory.simpleWorld();
		Set<GameObject> entities = new HashSet<>();
        for (int i = 0; i < ROW ; i++) {
            entities.add(factory2.simpleWall(new P2d(0, i * SIZE + 1)));
            entities.add(factory2.simpleWall(new P2d(COLUMN * SIZE + 1, i * SIZE + 1)));
        }
        for (int i = 0; i < COLUMN ; i++) {
            entities.add(factory2.simpleWall(new P2d(i * SIZE + 1, 0)));
            entities.add(factory2.simpleWall(new P2d(i * SIZE + 1, ROW * SIZE + 1)));
        }
		entities.add(factory2
		.simpleTank(STDSPEED, new P2d(4, 4), STDHEALTH, STDDAMAGE));
		entities.add(factory2
		.simpleTank(STDSPEED, new P2d((ROW - 1)* 3 + 1,(COLUMN - 1)*3 + 1), STDHEALTH, STDDAMAGE));
		assertEquals(entities.stream().map(g -> g.getPosition()).collect(Collectors.toSet()),
			world.getEntities().stream().map(g -> g.getPosition()).collect(Collectors.toSet()));
	}
}
