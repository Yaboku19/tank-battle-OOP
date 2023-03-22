package it.unibo.tankBattle.model.gameObject.api.component;

import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public abstract class AbstractComponent implements Component {

    private GameObject attached;

    @Override
    public void attachGameObject(final GameObject obj) {
        this.attached = obj; 
    }

    @Override
    public GameObject getGameObject() {
        return this.attached;
    }
    
}
