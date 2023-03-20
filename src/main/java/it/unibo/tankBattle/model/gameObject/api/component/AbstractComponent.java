package it.unibo.tankBattle.model.gameObject.api.component;

import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public abstract class AbstractComponent implements Component {

    private GameObject attached;

    public void attachGameObject(final GameObject obj) {
        this.attached = obj; 
    }

    protected GameObject getGameObject() {
        return this.attached;
    }
    
}
