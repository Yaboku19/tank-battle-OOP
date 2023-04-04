package it.unibo.tankbattle.model.gameobject.api.object;

import java.util.List;
import java.util.Optional;

import it.unibo.tankbattle.common.Point2d;
import it.unibo.tankbattle.common.Transform;
import it.unibo.tankbattle.common.input.api.Direction;
import it.unibo.tankbattle.model.gameobject.api.component.Component;
/**
 * Represent a standard GameObject.
 */
public interface GameObject {

    /**
     * Update each {@link Component} of the {@link GameObject}.
     * @param time time passed after last update
     */
    void update(double time);

    /**
     * Gets all the {@link Component} attached to the {@link GameObject}.
     * @return the List of {@link Component}
     */
    List<Component> getComponents();
    /**
     * Gets the specified {@link Component}, if present.
     * @param <T> any type of behaviour extending {@link Component}
     * @param component the {@link Class} of {@link T}
     * @return an Optional of the Component 
     */
    <T extends Component> Optional<T> getComponent(Class<T> component);
    /**
     * Add the {@link Component} to this {@link GameObject}.
     * @param component the component that will be add
     * @return this {@link GameObject}, if present
     */
    GameObject addComponent(Component component);
    /**
     * Gets the {@link Transform} associated to this {@link GameObject}.
     * @return the {@link Transform} assciated
     */
    Transform getTransform();

    /**
     * Change the position of this {@link GameObject}.
     * @param pos the new {@link Point2d}
     */
    void setPosition(Point2d pos);
    /**
     * Change the direction of this {@link GameObject}.
     * @param pos the new {@link Direction}
     */
    void setDirection(Direction pos);
}
