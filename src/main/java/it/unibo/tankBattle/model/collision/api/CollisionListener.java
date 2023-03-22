package it.unibo.tankBattle.model.collision.api;

import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public interface CollisionListener {
    
    void handleCollision(GameObject self, GameObject collidingObject);

}
