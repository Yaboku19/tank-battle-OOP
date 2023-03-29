package it.unibo.tankbattle.model.gameobject.impl.object;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import it.unibo.tankbattle.common.P2d;
import it.unibo.tankbattle.common.Transform;
import it.unibo.tankbattle.common.input.api.Direction;
import it.unibo.tankbattle.model.gameobject.api.component.Component;
import it.unibo.tankbattle.model.gameobject.api.component.Movable;
import it.unibo.tankbattle.model.gameobject.api.object.GameObject;
/**
 * javadoc.
 */
public class BasicGameObject implements GameObject {

    private P2d position;
    private Direction direction;
    private final double length;
    private final double width;
    private List<Component> components = new LinkedList<>();

    /**
     * javadoc.
     * @param transform param
     */
    public BasicGameObject(final Transform transform) {
        this.position = transform.getPosition();
        this.direction = transform.getDirection();
        this.length = transform.getLength();
        this.width = transform.getWidth();
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void update(final double time) {
        /*if(this.getComponent(Movable.class).isPresent()) {
            this.getComponent(Movable.class).get().update(time);
        }
        if(this.getComponent(Tank.class).isPresent()) {
            this.getComponent(Tank.class).get().update(time);
        }*/
        this.getComponents().forEach(comp -> comp.update(time));
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public List<Component> getComponents() {
        return this.components;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public <T extends Component> Optional<T> getComponent(final Class<T> component) {
        return this.components.stream()
                .filter(comp -> component.isInstance(comp))
                .map(comp -> component.cast(comp))
                .findFirst();
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public GameObject addComponent(final Component component) {
        this.components.add(component);
        component.attachGameObject(this);
        return this; 
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public Transform getTransform() {
        return new Transform(position, direction, length, width);
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void setPosition(final P2d pos) {
        this.position = pos;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void setDirection(final Direction dir) {
        if (!dir.equals(Direction.NONE)) {
            this.direction = dir;
        }
        if (this.getComponent(Movable.class).isPresent()) {
            this.getComponent(Movable.class).get().setMovingDirection(dir);
        }
    }
}
