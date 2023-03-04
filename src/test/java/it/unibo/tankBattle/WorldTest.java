package it.unibo.tankBattle;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Collectors;
import it.unibo.tankBattle.model.impl.GameStateImpl;
import it.unibo.tankBattle.model.world.impl.FactoryWorld;

public class WorldTest {
	private FactoryWorld factoryWorld;

    @org.junit.jupiter.api.BeforeEach       
	public void initFactory() {
		factoryWorld = new FactoryWorld(new GameStateImpl());

    }

    @org.junit.jupiter.api.Test            
	public void getter() {        
		var world = factoryWorld.simpleWorld();
        var entities = world.getBullets();
    
        entities.addAll(world.getWalls());
        entities.add(world.getFirstTank());
        entities.add(world.getSecondTank());

		assertEquals(entities.stream().map(g -> g.getPosition()).collect(Collectors.toSet()),
			world.getEntities().stream().map(g -> g.getPosition()).collect(Collectors.toSet()));
	}
}
