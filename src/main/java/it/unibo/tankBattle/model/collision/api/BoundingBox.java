package it.unibo.tankBattle.model.collision.api;

import it.unibo.tankBattle.common.P2d;

public interface BoundingBox {
    
    boolean isColliding(P2d centerObject1, int lengthObject1, P2d centerObject2, int lengthObject2);

}
