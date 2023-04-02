package it.unibo.tankbattle.model.gameobject.impl.component;

import java.util.Optional;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.tankbattle.model.gameobject.api.component.Component;
import it.unibo.tankbattle.model.gameobject.api.object.GameObject;

/**
 * Implements the common behaviours for every {@link Component}.
 */
public abstract class AbstractComponent implements Component {

    private GameObject attached;

    /**
    * {@inheritDoc}
    */
    @SuppressFBWarnings(
        value = {"EI_EXPOSE_REP2"}, 
        justification = "It is needed the object not its copy"
    )
    @Override
    public final void attachGameObject(final GameObject object) {
        this.attached = object;
        gameObjectAttached(object);
    }

    /**
     * Gets called when {@link #attachGameObject(GameObject) attachGameObject} is called.
     * @param object the {@link GameObject}
     */
    protected void gameObjectAttached(final GameObject object) {
    }

    /**
    * {@inheritDoc}
    */
    @SuppressFBWarnings(
        value = {"EI_EXPOSE_REP"}, 
        justification = "It is needed the object not its copy"
    )
    @Override
    public GameObject getGameObject() {
        return this.attached;
    }

    /**
     * Finds the {@link Component} of the given {@link Class} in the {@link GameObject}
     * to which this {@link Component} is attached, if present.
     * @param <T> any type of behaviour extending {@link Component}
     * @param component the {@link Class} of {@link T}
     * @return the {@link Component}, if present
     */
    protected <T extends Component> Optional<T> getSiblingComponent(final Class<T> component) {
        return getGameObject().getComponent(component);
    }

    /**
     * Finds the {@link Component} of the given {@link Class} in the {@link GameObject}
     * to which this {@link Component} is attached, if present.
     * Otherwise, throws an {@link IllegalArgumentException}.
     * @param <T> any type of behaviour extending {@link Component}
     * @param component the {@link Class} of {@link T}
     * @return the {@link Component}, if present
     * @exception IllegalArgumentException
     */
    protected <T extends Component> T requireSiblingComponent(final Class<T> component) {
        return getSiblingComponent(component)
            .orElseThrow(() -> new IllegalArgumentException("The required Component " 
            + component.getSimpleName() + " is not present"));
    }
}
