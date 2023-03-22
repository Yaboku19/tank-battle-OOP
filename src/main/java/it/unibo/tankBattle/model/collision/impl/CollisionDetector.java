package it.unibo.tankBattle.model.collision.impl;

import it.unibo.tankBattle.model.gameObject.api.component.Collidable;

public interface CollisionDetector {

    boolean detect(Collidable object1, Collidable object2);
    
}
