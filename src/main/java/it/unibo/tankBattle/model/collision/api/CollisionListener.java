package it.unibo.tankBattle.model.gameObject.api.component;

import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public interface CollisionListener {
    
    void handleCollision(GameObject self, GameObject collidingObject);

}
