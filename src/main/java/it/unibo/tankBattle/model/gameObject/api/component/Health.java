package it.unibo.tankBattle.model.gameObject.api.component;
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
