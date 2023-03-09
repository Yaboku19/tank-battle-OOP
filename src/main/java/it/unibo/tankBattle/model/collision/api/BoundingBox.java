package it.unibo.tankBattle.model.collision.api;

import it.unibo.tankBattle.common.P2d;

public class BoundingBox {

    private final P2d center;
    private final int length;
    
    public BoundingBox(P2d center, int length) {
        this.center = center;
        this.length = length;
    }

    public P2d getCenter() {
        return this.center;
    }

    public int getLength() {
        return this.length;
    }

}