package it.unibo.tankbattle.model.gameObject.api.object;

import java.util.List;
import java.util.Optional;

import it.unibo.tankbattle.common.P2d;
import it.unibo.tankbattle.common.Transform;
import it.unibo.tankbattle.common.input.api.Direction;
import it.unibo.tankbattle.model.gameObject.api.component.Component;
/**
 * javadoc.
 */
public interface GameObject {
    /**
     * javadoc.
     * @param time param
     */
    void update(double time);
    /**
     * javadoc.
     * @return return
     */
    List<Component> getComponents();
    /**
     * javadoc.
     * @param <T> param
     * @param component param
     * @return return
     */
    <T extends Component> Optional<T> getComponent(Class<T> component);
    /**
     * javadoc.
     * @param component param
     * @return return
     */
    GameObject addComponent(Component component);
    /**
     * javadoc.
     * @return return
     */
    Transform getTransform();




    //public void setTransform(Transform transform);
    /**
     * javadoc.
     * @param pos param
     */
    void setPosition(P2d pos);
    /**
     * javadoc.
     * @param pos param
     */
    void setDirection(Direction pos);
}
