package it.unibo.tankBattle.model.gameObject.impl.object;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.model.gameObject.api.component.Component;
import it.unibo.tankBattle.model.gameObject.api.component.Movable;
import it.unibo.tankBattle.model.gameObject.api.component.Tank;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;
import it.unibo.tankBattle.model.gameObject.impl.component.AbstractComponent;

public class BasicGameObject implements GameObject{

    private P2d position;
    private Directions direction;
    private final double length;
    private final double width;
    private Set<Component> components = new HashSet<>();


    public BasicGameObject(final Transform transform) {
        this.position = transform.getPosition();
        this.direction = transform.getDirection();
        this.length = transform.getLength();
        this.width = transform.getWidth();
    }

    @Override
    public void update(double time) {
        if(this.getComponent(Movable.class).isPresent()) {
            this.getComponent(Movable.class).get().update(time);
        }
        if(this.getComponent(Tank.class).isPresent()) {
            this.getComponent(Tank.class).get().update(time);
        }
    }

    @Override
    public Set<Component> getComponents() {
        return this.components;    
    }

    @Override
    public <T extends Component> Optional<T> getComponent(final Class<T> component) {
        return this.components.stream()
                .filter(comp -> component.isInstance(comp))
                .map(comp -> component.cast(comp))
                .findFirst();    
    }

    @Override
    public GameObject addComponent(final Component component) {
        this.components.add(component);
        if(component instanceof AbstractComponent)
            ((AbstractComponent) component).attachGameObject(this);
        return this;     
    }

    @Override
    public Transform getTransform() {
        return new Transform(position, direction, length, width);
    }
    
    @Override
    public void setPosition(final P2d pos) {
        this.position = pos;
    }

    @Override
    public void setDirection(final Directions dir) {
        if(!dir.equals(Directions.NONE)) {
            this.direction = dir;
        }
        if(this.getComponent(Movable.class).isPresent()) {
            this.getComponent(Movable.class).get().setMovingDirection(dir);
        }
    }
}
