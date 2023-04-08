package it.unibo.tankbattle.model.collision.impl;

import java.util.stream.Stream;

import it.unibo.tankbattle.common.Point2d;
import it.unibo.tankbattle.common.Transform;

/**
 * Implements {@link CollisionDetector} interface using {@link Transform} to see if a collision is happening.
 */
public class CollisionDetectorImpl implements CollisionDetector {

    /**
    * {@inheritDoc}
    */
    @Override
    public boolean detect(final Transform object1, final Transform object2) {
        return containsAnyCorner(object1, object2) || containsAnyCorner(object2, object1);
    }

    private boolean containsAnyCorner(final Transform transform1, final Transform transform2) {
        return corners(transform2).anyMatch(corner -> containsCorner(transform1, corner));
    }

    private boolean containsCorner(final Transform transform, final Point2d corner) {
        return corner.getX() >= transform.getPosition().getX() - transform.getLength() / 2
            && corner.getX() <= transform.getPosition().getX() + transform.getLength() / 2
            && corner.getY() >= transform.getPosition().getY() - transform.getWidth() / 2
            && corner.getY() <= transform.getPosition().getY() + transform.getWidth() / 2;
    }

    private Stream<Point2d> corners(final Transform transform) {
        final Stream<Point2d> offsets = Stream.of(
            new Point2d(transform.getLength() / 2, transform.getWidth() / 2),
            new Point2d(-transform.getLength() / 2, transform.getWidth() / 2),
            new Point2d(transform.getLength() / 2, -transform.getWidth() / 2),
            new Point2d(-transform.getLength() / 2, -transform.getWidth() / 2)
        );
        return offsets.map(transform.getPosition()::sum);
    }
}
