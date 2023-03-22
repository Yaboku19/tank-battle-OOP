package it.unibo.tankBattle.model.gameObject.api.component;

public interface ObservableCollidable extends Component {
    
    void addListener(CollisionListener listener);

    void removeListener(CollisionListener listener);

}
