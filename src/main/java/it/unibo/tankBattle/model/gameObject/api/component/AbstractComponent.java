package it.unibo.tankBattle.model.gameObject.api.component;

import java.util.Optional;

import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public abstract class AbstractComponent implements Component {

    private GameObject attached;

    @Override
    public final void attachGameObject(final GameObject object) {
        this.attached = object;
        gameObjectAttached(object);
    }

    protected void gameObjectAttached(final GameObject object) {
    }

    @Override
    public GameObject getGameObject() {
        return this.attached;
    }

    protected <T extends Component> Optional<T> getSiblingComponent(final Class<T> component) {
        return getGameObject().getComponent(component);
    }

    protected <T extends Component> T requireSiblingComponent(final Class<T> component) {
        return getSiblingComponent(component)
            .orElseThrow(() -> new IllegalArgumentException("The required Component " + component.getSimpleName() + " is not present"));
    }
    
}
