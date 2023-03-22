package it.unibo.tankBattle.model.gameObject.api.component;

import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public interface Collidable extends Component {

    void resolveCollision(GameObject collidingObject);

}
