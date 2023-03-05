package it.unibo.tankBattle.model.collision.api;

import it.unibo.tankBattle.common.P2d;

public interface BoundingBox {
    
    boolean isColliding(P2d center, int length);

}
