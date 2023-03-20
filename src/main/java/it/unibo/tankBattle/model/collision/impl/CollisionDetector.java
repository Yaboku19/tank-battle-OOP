package it.unibo.tankBattle.model.collision.impl;

import it.unibo.tankBattle.model.gameObject.impl.component.PassiveCollidable;

public interface CollisionDetector {

    boolean detect(PassiveCollidable object1, PassiveCollidable object2);
    
}
