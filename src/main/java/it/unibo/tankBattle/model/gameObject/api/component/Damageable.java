package it.unibo.tankBattle.model.gameObject.api.component;

public interface Damageable extends Component {
    
    int getLifePoints();

    void takeDamage(int damage);
}
