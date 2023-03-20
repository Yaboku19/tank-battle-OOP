package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Directions;
import it.unibo.tankBattle.model.gameObject.api.component.AbstractComponent;
import it.unibo.tankBattle.model.gameObject.api.component.ActiveCollidable;
import it.unibo.tankBattle.model.gameObject.api.component.DamageDealer;
import it.unibo.tankBattle.model.gameObject.api.component.Movable;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public class ActiveCollidableTank extends AbstractComponent implements ActiveCollidable {

    private double timer;

    public ActiveCollidableTank() {
        this.timer = 1;
    }

    @Override
    public void update(double time) {
        this.timer = time;
    }

    @Override
    public void resolveCollision(final GameObject collidingObject) {
        knockBack(getKnockBackDirection(collidingObject.getTransform().getPosition()));
        reduceLp(collidingObject);
    }
    
    private Directions getKnockBackDirection(final P2d collidingObjPos) {
        final Double differenceX = collidingObjPos.getX() - this.getGameObject().getTransform().getPosition().getX();
        final Double differenceY = collidingObjPos.getY() - this.getGameObject().getTransform().getPosition().getY();
        return Math.abs(differenceX) >= Math.abs(differenceY)
            ? differenceX >= 0 
                ? Directions.LEFT
                : Directions.RIGHT
            : differenceY >=0
                ? Directions.UP
                : Directions.DOWN;
    }

    private void knockBack(final Directions knockBackDir) {
        if(this.getGameObject().getComponent(Movable.class).isPresent()) {
            double speed = this.getGameObject().getComponent(Movable.class).get().getSpeed();
            P2d actualPos = this.getGameObject().getTransform().getPosition();
            this.getGameObject().setPosition(new P2d(actualPos.getX() + knockBackDir.getX()*speed*timer,
                actualPos.getY() + knockBackDir.getY()*speed*timer));
        }
    }

    private void reduceLp(final GameObject collidingObject) {
        if(this.getGameObject().getComponent(TankHealth.class).isPresent() &&
                    collidingObject.getComponent(DamageDealer.class).isPresent()) {
            int damage = collidingObject.getComponent(DamageDealer.class).get().getDamage();
            this.getGameObject().getComponent(TankHealth.class).get().decreaseLifePoints(damage);
        }
    }
}
