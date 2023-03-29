package it.unibo.tankbattle.model.gameobject.api.component;
/**
 * javadoc.
 */
public interface Damageable extends Component {
    /**
     * javadoc.
     * @return return
     */
    int getLifePoints();
    /**
     * javadoc.
     * @param damage param
     */
    void takeDamage(int damage);
}
