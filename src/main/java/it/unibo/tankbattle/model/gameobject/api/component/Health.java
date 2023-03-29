package it.unibo.tankbattle.model.gameobject.api.component;
/**
 * javadoc.
 */
public interface Health extends Component {
    /**
     * javadoc.
     * @return return
     */
    boolean isAlive();
    /**
     * javadoc.
     */
    void die();
}
