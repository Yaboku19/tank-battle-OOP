package it.unibo.tankBattle.model.gameObject.api.component;

import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public interface ActiveCollidable extends Component {
    
    public void resolveCollision(final GameObject collidingObject);

}
