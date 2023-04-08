package it.unibo.tankbattle.model;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import it.unibo.tankbattle.common.Point2d;
import it.unibo.tankbattle.common.Transform;
import it.unibo.tankbattle.common.input.api.Direction;
import it.unibo.tankbattle.model.collision.impl.CollisionDetectorImpl;

final class CollisionDetectorImplTest {

    private CollisionDetectorImpl detector;

    @org.junit.jupiter.api.BeforeEach
    void initDetector() {
        this.detector = new CollisionDetectorImpl();
    }

    private Transform createTransform(final double x, final double y, final double length, final double width) {
        return new Transform(new Point2d(x, y), Direction.NONE, length, width);
    }

    @org.junit.jupiter.api.Test
    void testNotColliding() {
        final Transform transform1 = createTransform(5, 10, 200, 100);
        final Transform transform2 = createTransform(60, 500, 200, 100);
        assertFalse(this.detector.detect(transform1, transform2));
    }

    @org.junit.jupiter.api.Test
    void testDownColliding() {
        final Transform transform1 = createTransform(5, 10, 200, 100);
        final Transform transform2 = createTransform(5, 100, 200, 100);
        assertTrue(this.detector.detect(transform1, transform2));
    }

    @org.junit.jupiter.api.Test
    void testUpColliding() {
        final Transform transform1 = createTransform(5, 60, 200, 100);
        final Transform transform2 = createTransform(5, 10, 200, 100);
        assertTrue(this.detector.detect(transform1, transform2));
    }

    @org.junit.jupiter.api.Test
    void testLeftColliding() {
        final Transform transform1 = createTransform(5, 10, 200, 100);
        final Transform transform2 = createTransform(180, 10, 200, 100);
        assertTrue(this.detector.detect(transform1, transform2));
    }

    @org.junit.jupiter.api.Test
    void testRightColliding() {
        final Transform transform1 = createTransform(60, 10, 200, 100);
        final Transform transform2 = createTransform(20, 10, 200, 100);
        assertTrue(this.detector.detect(transform1, transform2));
    }

    @org.junit.jupiter.api.Test
    void testOverlappingEdgeColliding() {
        final Transform transform1 = createTransform(60, 10, 200, 100);
        final Transform transform2 = createTransform(260, 10, 200, 100);
        assertTrue(this.detector.detect(transform1, transform2));
    }

    @org.junit.jupiter.api.Test
    void testInsideColliding() {
        final Transform transform1 = createTransform(60, 10, 200, 100);
        final Transform transform2 = createTransform(60, 10, 100, 50);
        assertTrue(this.detector.detect(transform1, transform2));
    }
}
