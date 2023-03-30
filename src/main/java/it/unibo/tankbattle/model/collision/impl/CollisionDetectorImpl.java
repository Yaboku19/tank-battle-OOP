package it.unibo.tankbattle.model.collision.impl;

import java.util.stream.Stream;

import it.unibo.tankbattle.common.P2d;
import it.unibo.tankbattle.common.Transform;
import it.unibo.tankbattle.model.gameobject.api.component.Collidable;

/**
 * Implements {@link CollisionDetector} interface using {@link Transform} to see if a collision is happening.
 */
public class CollisionDetectorImpl implements CollisionDetector {

    /**
    * {@inheritDoc}
    */
    @Override
    public boolean detect(final Collidable object1, final Collidable object2) {
        final Transform transform1 = object1.getGameObject().getTransform();
        final Transform transform2 = object2.getGameObject().getTransform();
        return containsAnyCorner(transform1, transform2) || containsAnyCorner(transform2, transform1);
    }

    private boolean containsAnyCorner(final Transform transform1, final Transform transform2) {
        return corners(transform2).anyMatch(corner -> containsCorner(transform1, corner));
    }

    private boolean containsCorner(final Transform transform, final P2d corner) {
        return corner.getX() >= transform.getPosition().getX() - transform.getLength() / 2
            && corner.getX() <= transform.getPosition().getX() + transform.getLength() / 2
            && corner.getY() >= transform.getPosition().getY() - transform.getWidth() / 2
            && corner.getY() <= transform.getPosition().getY() + transform.getWidth() / 2;
    }

    private Stream<P2d> corners(final Transform transform) {
        final Stream<P2d> offsets = Stream.of(
            new P2d(transform.getLength() / 2, transform.getWidth() / 2),
            new P2d(-transform.getLength() / 2, transform.getWidth() / 2),
            new P2d(transform.getLength() / 2, -transform.getWidth() / 2),
            new P2d(-transform.getLength() / 2, -transform.getWidth() / 2)
        );
        return offsets.map(transform.getPosition()::sum);
    }
}
