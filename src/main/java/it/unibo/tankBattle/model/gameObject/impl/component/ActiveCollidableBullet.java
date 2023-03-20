package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.model.gameObject.api.component.AbstractComponent;
import it.unibo.tankBattle.model.gameObject.api.component.ActiveCollidable;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public class ActiveCollidableBullet extends AbstractComponent implements ActiveCollidable{

    @Override
    public void update(double time) {
        
    }

    @Override
    public void resolveCollision(GameObject collidingObject) {
        if(this.getGameObject().getComponent(BulletHealth.class).isPresent()) {
            this.getGameObject().getComponent(BulletHealth.class).get().hit();
        }
    }
    
}
