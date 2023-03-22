package it.unibo.tankBattle.model.gameObject.api.component;

public interface Health extends Component{

    boolean isAlive();

    void die();
    
}
