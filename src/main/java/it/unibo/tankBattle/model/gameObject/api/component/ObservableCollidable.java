package it.unibo.tankBattle.model.gameObject.api.component;

import it.unibo.tankBattle.model.collision.api.CollisionListener;

public interface ObservableCollidable extends Component {
    
    void addListener(CollisionListener listener);

    void removeListener(CollisionListener listener);

}
