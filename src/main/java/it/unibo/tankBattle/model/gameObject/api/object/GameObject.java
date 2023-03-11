package it.unibo.tankBattle.model.gameObject.api.object;

import java.util.Optional;
import java.util.Set;

import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.model.gameObject.api.component.Component;

interface GameObject {
    
    public void update(double time);

    public Set<Component> getComponents();

    public <T extends Component> Optional<T> getComponent(Class<T> component);

    public GameObject addComponent(final Component component);

    public Transform getTransform();

    public void setTransform(Transform transform);

}
