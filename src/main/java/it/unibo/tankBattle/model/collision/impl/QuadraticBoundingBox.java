package it.unibo.tankBattle.model.collision.impl;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.model.collision.api.BoundingBox;

public class QuadraticBoundingBox implements BoundingBox {

    private P2d center;
    private int length;

    public QuadraticBoundingBox(P2d center, int length) {
        this.center = center;
        this.length = length;
    }

    public P2d getUpLeftCorner() {
        return new P2d(this.center.getX() - (this.length / 2), this.center.getY() - (this.length / 2));
    }

    public P2d getBottomRightCorner() {
        return new P2d(this.center.getX() + (this.length / 2), this.center.getY() + (this.length / 2));
    }

    @Override
    public boolean isColliding(P2d center, int length) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isColliding'");

    }

}