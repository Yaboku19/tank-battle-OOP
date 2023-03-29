package it.unibo.tankbattle.model.gameObject.api.component;

import java.util.Optional;

import it.unibo.tankbattle.model.gameObject.api.object.GameObject;
/**
 * javadoc.
 */
public abstract class AbstractComponent implements Component {

    private GameObject attached;
    /**
    * {@inheritDoc}
    */
    @Override
    public final void attachGameObject(final GameObject object) {
        this.attached = object;
        gameObjectAttached(object);
    }
    /**
     * javadoc.
     * @param object param
     */
    protected void gameObjectAttached(final GameObject object) {
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public GameObject getGameObject() {
        return this.attached;
    }
    /**
     * javadoc.
     * @param <T> param
     * @param component param
     * @return param
     */
    protected <T extends Component> Optional<T> getSiblingComponent(final Class<T> component) {
        return getGameObject().getComponent(component);
    }
    /**
     * javadoc.
     * @param <T> param
     * @param component param
     * @return return
     */
    protected <T extends Component> T requireSiblingComponent(final Class<T> component) {
        return getSiblingComponent(component)
            .orElseThrow(() -> new IllegalArgumentException("The required Component " 
            + component.getSimpleName() + " is not present"));
    }
}
