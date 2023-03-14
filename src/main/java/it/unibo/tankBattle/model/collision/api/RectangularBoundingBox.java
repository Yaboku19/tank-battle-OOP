package it.unibo.tankBattle.model.collision.api;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.Transform;

public class RectangularBoundingBox implements BoundingBox {

    private final P2d center;
    private final double length;
    private final double width;
    
    public RectangularBoundingBox(Transform transform) {
        this.center = transform.getPosition();
        this.length = transform.getLength();
        this.width = transform.getWidth();
    }

    @Override
    public P2d getCenter() {
        return this.center;
    }

    @Override
    public double getLength() {
        return this.length;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

}