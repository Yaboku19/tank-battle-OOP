package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.model.gameObject.api.component.Movable;

public class SimpleMovable extends AbstractComponent implements Movable {

    private int speed;
    

    public SimpleMovable(int speed) {
        this.speed = speed;
    }

    @Override
    public void update(double time) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }
    
}
