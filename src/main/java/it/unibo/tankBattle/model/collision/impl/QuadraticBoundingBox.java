package it.unibo.tankBattle.model.collision.impl;

import java.util.stream.Stream;

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

    private Stream<P2d> objectArea() {
        return Stream.concat(
            Stream.concat(
                Stream
                    .iterate(getUpLeftCorner(), x -> new P2d(getUpLeftCorner().getX() + 1, getUpLeftCorner().getY()))
                    .limit(this.length)
                ,
                Stream
                    .iterate(getBottomRightCorner(), x -> new P2d(getBottomRightCorner().getX() - 1, getUpLeftCorner().getY()))
                    .limit(this.length)
                ),
            Stream.concat(
                Stream
                    .iterate(getUpLeftCorner(), x -> new P2d(getUpLeftCorner().getX(), getUpLeftCorner().getY() + 1))
                    .limit(this.length)
                ,
                Stream
                    .iterate(getBottomRightCorner(), x -> new P2d(getBottomRightCorner().getX(), getBottomRightCorner().getY() - 1))
                    .limit(this.length)
                )
        );
    }
    
    @Override
    public boolean isColliding(P2d center, int length) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isColliding'");
    }

}