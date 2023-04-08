package it.unibo.tankbattle.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Optional;

import it.unibo.tankbattle.common.Point2d;
import it.unibo.tankbattle.common.Transform;
import it.unibo.tankbattle.common.input.api.Direction;
import it.unibo.tankbattle.model.collision.api.CollisionListener;
import it.unibo.tankbattle.model.gameobject.api.component.Component;
import it.unibo.tankbattle.model.gameobject.api.object.GameObject;
import it.unibo.tankbattle.model.gameobject.impl.component.CollisionComponent;

final class CollisionComponentTest {

    private GameObject self;
    private CollisionComponent component;
    private GameObject other;
    private boolean called;

    @org.junit.jupiter.api.BeforeEach
    void init() {
        this.self = createMockGameObject();
        this.component = new CollisionComponent();
        this.component.attachGameObject(this.self);
        this.other = createMockGameObject();
    }

    private GameObject createMockGameObject() {
        return new GameObject() {

            @Override
            public void update(final double time) {
            }

            @Override
            public List<Component> getComponents() {
                return List.of();
            }

            @Override
            public <T extends Component> Optional<T> getComponent(final Class<T> component) {
                return Optional.empty();
            }

            @Override
            public GameObject addComponent(final Component component) {
                return this;
            }

            @Override
            public Transform getTransform() {
                return null;
            }

            @Override
            public void setPosition(final Point2d pos) {
            }

            @Override
            public void setDirection(final Direction pos) {
            }
        };
    }

    @org.junit.jupiter.api.Test
    void testAddListener() {
        component.addListener((s, o) -> {
            this.called = true;
        });
        component.resolveCollision(this.other);
        assertTrue(this.called);
    }

    @org.junit.jupiter.api.Test
    void testListenerArguments() {
        component.addListener((s, o) -> {
            assertEquals(this.self, s);
            assertEquals(this.other, o);
        });
        component.resolveCollision(this.other);
    }

    @org.junit.jupiter.api.Test
    void testRemoveListener() {
        final CollisionListener listener = (s, o) -> fail();
        component.addListener(listener);
        component.removeListener(listener);
        component.resolveCollision(this.other);
    }

    @org.junit.jupiter.api.Test
    void testNoListeners() {
        component.resolveCollision(this.other);
    }

    @org.junit.jupiter.api.Test
    void testMoreListeners() {
        component.addListener((s, o) -> {
            assertEquals(this.self, s);
            assertEquals(this.other, o);
        });
        component.addListener((s, o) -> {
            assertEquals(this.self, s);
            assertEquals(this.other, o);
        });
        component.resolveCollision(this.other);
    }
}
