package it.unibo.tankBattle.model.gameObject.api.component;

import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public interface Component {

    void update(double time);

    GameObject getGameObject();

}
