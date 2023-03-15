package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.model.collision.api.BoundingBox;

public class BoundingBoxComp extends AbstractComponent{

    private final BoundingBox boundingBox;

    public BoundingBoxComp(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    @Override
    public void update(double time) {
        
    }

    public BoundingBox getBoundingBox() {
        return this.boundingBox;
    }
    
}
