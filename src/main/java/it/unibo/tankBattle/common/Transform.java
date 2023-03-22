package it.unibo.tankBattle.common;

import it.unibo.tankBattle.common.input.api.Direction;

public class Transform {

    private P2d position;
    private Direction direction;
    private double length;
    private double width;


    public Transform(P2d position, Direction direction, double length, double width) {
        this.position = position;
        this.direction = direction;
        this.length = length;
        this.width = width;
    }
    
    public P2d getPosition() {
        return this.position;
    }
    public Direction getDirection() {
        return this.direction;
    }
    public double getLength() {
        return this.length;
    }
    public double getWidth() {
        return this.width;
    }
    public P2d getUpperLeftPosition() {
        return new P2d(this.position.getX()-length/2, this.position.getY()-width/2);
    }
    
}
