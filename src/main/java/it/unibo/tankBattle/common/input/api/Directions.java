package it.unibo.tankBattle.common.input.api;

import it.unibo.tankBattle.common.P2d;

/**
 * Directions that can be used by the player
 */
public enum Directions {
    UP(new P2d(-1, 0)), 
    RIGHT(new P2d(0, 1)), 
    DOWN(new P2d(1, 0)), 
    LEFT(new P2d(0, -1));

    P2d pos;

    Directions(P2d pos) {
        this.pos = pos;
        
    }
}
