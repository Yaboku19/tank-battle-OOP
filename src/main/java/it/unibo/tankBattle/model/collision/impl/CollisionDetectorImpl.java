package it.unibo.tankBattle.model.collision.impl;

import java.util.stream.Stream;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.model.gameObject.api.component.Collidable;

public class CollisionDetectorImpl implements CollisionDetector {

    public boolean detect(Collidable object1, Collidable object2) {
        Transform transform1 = object1.getGameObject().getTransform();
        Transform transform2 = object2.getGameObject().getTransform();
        return containsAnyCorner(transform1, transform2) || containsAnyCorner(transform2, transform1);
    }

    private boolean containsAnyCorner(Transform transform1, Transform transform2) {
        return corners(transform2).anyMatch(corner -> containsCorner(transform1, corner));
    }

    private boolean containsCorner(Transform transform, P2d corner) {
        return corner.getX() >= transform.getPosition().getX() - transform.getLength() / 2
            && corner.getX() <= transform.getPosition().getX() + transform.getLength() / 2
            && corner.getY() >= transform.getPosition().getY() - transform.getWidth() / 2
            && corner.getY() <= transform.getPosition().getY() + transform.getWidth() / 2;
    }

    private Stream<P2d> corners(Transform transform) {
        Stream<P2d> offsets = Stream.of(
            new P2d(transform.getLength() / 2, transform.getWidth() / 2),
            new P2d(-transform.getLength() / 2, transform.getWidth() / 2),
            new P2d(transform.getLength() / 2, -transform.getWidth() / 2),
            new P2d(-transform.getLength() / 2, -transform.getWidth() / 2)
        );
        return offsets.map(transform.getPosition()::sum);
    }
    
}
