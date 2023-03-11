package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.model.gameObject.api.component.MovableComponent;

public class SimpleMovableComponent extends AbstractComponent implements MovableComponent {

    private int speed;
    

    public SimpleMovableComponent(int speed) {
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
