package it.unibo.tankBattle.model.collision.api;

import it.unibo.tankBattle.common.P2d;

public interface BoundingBox {
    
    public P2d getCenter();

    public double getLength();

    public double getWidth();

}
