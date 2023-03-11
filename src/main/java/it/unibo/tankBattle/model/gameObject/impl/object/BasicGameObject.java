package it.unibo.tankBattle.model.gameObject.impl.object;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.model.gameObject.api.component.Component;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;
import it.unibo.tankBattle.model.gameObject.impl.component.AbstractComponent;

public class BasicGameObject implements GameObject{

    private Transform transform;
    private Set<Component> components = new HashSet<>();


    public BasicGameObject(Transform transform) {
        this.transform = transform;
    }

    @Override
    public void update(double time) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Set<Component> getComponents() {
        return this.components;    
    }

    @Override
    public <T extends Component> Optional<T> getComponent(Class<T> component) {
        return this.components.stream()
                .filter(comp -> component.isInstance(comp))
                .map(comp -> component.cast(comp))
                .findFirst();    
    }

    @Override
    public GameObject addComponent(Component component) {
        this.components.add(component);
        if(component instanceof AbstractComponent)
            ((AbstractComponent) component).attachGameObject(this);
        return this;     
    }

    @Override
    public Transform getTransform() {
        return this.transform;
    }
    
    @Override
    public void setPosition(P2d pos) {
        this.transform = new Transform(pos,transform.getDirection(), transform.getLength(), transform.getLength());    }

    @Override
    public void setDirection(Directions dir) {
        this.transform = new Transform(transform.getPosition(),dir, transform.getLength(), transform.getLength());
    }
}
