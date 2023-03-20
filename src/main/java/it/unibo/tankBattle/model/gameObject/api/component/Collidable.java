package it.unibo.tankBattle.model.gameObject.api.component;

public interface Collidable extends Component {
    
    void resolveCollision(Collidable collidingObject);

}
