package it.unibo.tankbattle.model.gameobject.impl.component;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;

import it.unibo.tankbattle.common.P2d;
import it.unibo.tankbattle.common.Transform;
import it.unibo.tankbattle.common.input.api.Direction;
import it.unibo.tankbattle.model.collision.api.CollisionListener;
import it.unibo.tankbattle.model.gameobject.api.component.Movable;
import it.unibo.tankbattle.model.gameobject.api.component.ObservableCollidable;
import it.unibo.tankbattle.model.gameobject.api.object.GameObject;

/**
 * Represents a particular {@link it.unibo.tankbattle.model.gameobject.api.component.Component}
 * that enables the attached {@link GameObject} to be knocked back after a collision.
 */
public class KnockBack extends AbstractComponent implements CollisionListener {

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double time) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void gameObjectAttached(final GameObject object) {
        requireSiblingComponent(ObservableCollidable.class).addListener(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleCollision(final GameObject self, final GameObject collidingObject) {
        final P2d offset = computeOffset(collidingObject);
        if (shouldBeKnockedBack(collidingObject) && this.shouldBeKnockedBack(self)) {
            final P2d doubleKnockBackOffset = offset.multiply(0.5);
            setNewPosition(self, doubleKnockBackOffset);
            setNewPosition(collidingObject, doubleKnockBackOffset.multiply(-1));
        } else if (requireSiblingComponent(Movable.class).getMovingDirection() != Direction.NONE) {
            setNewPosition(self, offset);
        }
    }

    private void setNewPosition(final GameObject object, final P2d offset) {
        final P2d newPosition = object.getTransform().getPosition().sum(offset);
        object.setPosition(newPosition);
    }

    private boolean shouldBeKnockedBack(final GameObject object) {
        return object.getComponent(KnockBack.class).isPresent()
                && object
                        .getComponent(Movable.class)
                        .map(x -> x.getMovingDirection())
                        .filter(direction -> direction != Direction.NONE)
                        .isPresent();
    }

    private P2d computeOffset(final GameObject collidingObject) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction != Direction.NONE)
                .map(x -> this.getOffset(collidingObject, x))
                .min(Comparator.comparing(x -> x.getMagnitude()))
                .get();
    }

    private P2d getOffset(final GameObject collidingObject, final Direction direction) {
        final Transform self = this.getGameObject().getTransform();
        final Transform other = collidingObject.getTransform();
        final Function<P2d, Double> get = switch (direction) {
            case UP, DOWN -> P2d::getY;
            case LEFT, RIGHT -> P2d::getX;
            default -> x -> 0.0;
        };
        final BiFunction<P2d, Double, P2d> set = switch (direction) {
            case UP, DOWN -> (p, v) -> new P2d(p.getX(), v);
            case LEFT, RIGHT -> (p, v) -> new P2d(v, p.getY());
            default -> (x, y) -> new P2d(0.0, 0.0);
        };
        return offset(
                self.getPosition(),
                other.getPosition(),
                new P2d(self.getLength(), self.getWidth()),
                new P2d(other.getLength(), other.getWidth()),
                direction.getVector(),
                get,
                set);
    }

    private P2d offset(final P2d center1, final P2d center2,
            final P2d side1, final P2d side2, final P2d dir,
            final Function<P2d, Double> get, final BiFunction<P2d, Double, P2d> set) {
        final var lengthSide1 = get.apply(side1);
        final var lengthSide2 = get.apply(side2);
        final var zero = new P2d(0.0, 0.0);
        final var distance1 = set.apply(zero, get.apply(center1));
        final var distance2 = set.apply(zero, get.apply(center2));
        return distance2.sum(distance1.multiply(-1)).sum(dir.multiply(lengthSide1 / 2 + lengthSide2 / 2));
    }
}
