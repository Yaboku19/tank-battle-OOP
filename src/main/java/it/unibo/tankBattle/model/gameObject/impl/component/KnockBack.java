package it.unibo.tankBattle.model.gameObject.impl.component;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.input.api.Direction;
import it.unibo.tankBattle.model.collision.api.CollisionListener;
import it.unibo.tankBattle.model.gameObject.api.component.AbstractComponent;
import it.unibo.tankBattle.model.gameObject.api.component.Movable;
import it.unibo.tankBattle.model.gameObject.api.component.ObservableCollidable;
import it.unibo.tankBattle.model.gameObject.api.object.GameObject;

public class KnockBack extends AbstractComponent implements CollisionListener {

    @Override
    public void update(double time) {
    }

    @Override
    public void gameObjectAttached(GameObject object) {
        requireSiblingComponent(ObservableCollidable.class).addListener(this);
    }

    @Override
    public void handleCollision(GameObject self, GameObject collidingObject) {
        final P2d newPosition = this.getGameObject().getTransform().getPosition().sum(getOffset(collidingObject));
        this.getGameObject().setPosition(newPosition);
        System.out.println("colliding");
    }

    private P2d getOffset(final GameObject collidingObject) {
        final Direction objectDirection = movingDirection();
        final double offset = switch (objectDirection) {
            case UP, DOWN ->
                offset(
                    this.getGameObject().getTransform().getPosition().getY(),
                    collidingObject.getTransform().getPosition().getY(),
                    this.getGameObject().getTransform().getWidth(),
                    collidingObject.getTransform().getWidth()
                );
            case LEFT, RIGHT ->
                offset(
                    this.getGameObject().getTransform().getPosition().getX(),
                    collidingObject.getTransform().getPosition().getX(),
                    this.getGameObject().getTransform().getLength(),
                    collidingObject.getTransform().getLength()
                );
            default -> 0;
        };
        System.out.println(offset);
        return objectDirection.getVector().multiply(-offset);
    }

    private double offset(final double center1, final double center2, final double side1, final double side2) {
        return (side1 / 2 + side2 / 2 - Math.abs(center1 - center2)) + 1.5;              
    }

    private Direction movingDirection() {
        return requireSiblingComponent(Movable.class)
            .getMovingDirection();
    }
}
