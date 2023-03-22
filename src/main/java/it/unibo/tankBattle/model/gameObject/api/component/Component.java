package it.unibo.tankBattle.model.gameObject.api.component;

import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public interface Component {

    public void update(double time);

    public GameObject getGameObject();

    public void attachGameObject(final GameObject obj);

}
