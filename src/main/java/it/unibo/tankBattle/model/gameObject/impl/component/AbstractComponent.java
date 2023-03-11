package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.model.gameObject.api.component.Component;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public abstract class AbstractComponent implements Component{

    private GameObject attached;

    public void attachGameObject(GameObject obj) {
        this.attached = obj; 
    }

    protected GameObject getGameObject() {
        return this.attached;
    }
    
}
