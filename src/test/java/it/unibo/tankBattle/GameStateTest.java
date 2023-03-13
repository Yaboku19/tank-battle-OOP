package it.unibo.tankBattle;

import static org.junit.jupiter.api.Assertions.*;

import it.unibo.tankBattle.controller.api.GameEngine;
import it.unibo.tankBattle.controller.api.Player;
import it.unibo.tankBattle.controller.impl.BasicGameEngine;
import it.unibo.tankBattle.model.gameObject.api.object.FactoryGameObject;
import it.unibo.tankBattle.model.gameObject.impl.component.Tank;
import it.unibo.tankBattle.model.gameObject.impl.object.FactoryGameObjectImpl;
import it.unibo.tankBattle.model.gameState.api.GameState;
import it.unibo.tankBattle.model.gameState.impl.GameStateImpl;

public class GameStateTest {
 
    private FactoryGameObject factoryGameObject;
    private GameState gameState;
    private GameEngine gameEngine;
    private Player player1;

    @org.junit.jupiter.api.BeforeEach
    public void initFactory() {
        this.factoryGameObject = new FactoryGameObjectImpl();
        gameEngine = new BasicGameEngine();
        gameEngine.startGame();
        this.gameState = new GameStateImpl(null);
        this.gameState.createWorld(player1, player1);
    }

    @org.junit.jupiter.api.Test
    public void testSetDirection() {
        this.gameState.getTanks().forEach(tank -> System.out.println(tank.getComponent(Tank.class).get().getPlayer()));
        //this.gameState.setDirection(Directions.DOWN, player1);
        /*assertEquals(Directions.DOWN, this.gameState.getTanks().filter(tank -> tank.getComponent(Tank.class)
                .get()
                .getPlayer()
                .equals(player1))
                .findFirst()
                .get()
                .getTransform()
                .getDirection());*/
    }


}
