package it.unibo.tankBattle.model.collision.impl;

import it.unibo.tankBattle.model.collision.api.BoundingBox;

public interface CollisionDetector {
    
    boolean detect(BoundingBox boundingBox1, BoundingBox boundingBox2);

}
