package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.model.gameObject.api.component.Collidable;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public class CollidableBullet extends AbstractComponent implements Collidable{

    @Override
    public void update(double time) {
        
    }

    @Override
    public void resolveCollision(Collidable collidingObject) {
        if(this.getGameObject().getComponent(BulletHealth.class).isPresent()) {
            this.getGameObject().getComponent(BulletHealth.class).get().hit();
        }
    }
    
}
