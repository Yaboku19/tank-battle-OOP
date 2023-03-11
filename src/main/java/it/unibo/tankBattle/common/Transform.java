package it.unibo.tankBattle.common;

import it.unibo.tankBattle.common.input.api.Directions;

public class Transform {

    private P2d position;
    private Directions direction;
    private double length;
    private double width;


    public Transform(P2d position, Directions direction, double length, double width) {
        this.position = position;
        this.direction = direction;
        this.length = length;
        this.width = width;
    }
    
    public P2d getPosition() {
        return this.position;
    }
    public Directions getDirection() {
        return this.direction;
    }
    public double getLength() {
        return this.length;
    }
    public double getWidth() {
        return this.width;
    }
    
}
