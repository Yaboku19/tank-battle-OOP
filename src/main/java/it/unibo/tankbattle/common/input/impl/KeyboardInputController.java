package it.unibo.tankbattle.common.input.impl;

import java.util.List;
import java.util.Optional;

import it.unibo.tankbattle.common.input.api.Command;
import it.unibo.tankbattle.common.input.api.Direction;
import it.unibo.tankbattle.common.input.api.InputController;
import it.unibo.tankbattle.controller.api.Player;
/**
 * javadoc.
 */
public class KeyboardInputController<T> implements InputController<T> {

    private final T moveUp;
    private final T moveDown;
    private final T moveLeft;
    private final T moveRight;
    private final T shoot;
    private final Player player;
    private Optional<T> lastCommand = Optional.empty();
    /**
     * @param moveUp param move up key.
     * @param moveDown param move down key.
     * @param moveLeft param move left key.
     * @param moveRight param move right key.
     * @param shoot param shoot key.
     */
    public KeyboardInputController(final T moveUp, final T moveDown, final T moveLeft,
        final T moveRight, final T shoot, final Player player) {

                this.moveUp = moveUp;
                this.moveDown = moveDown;
                this.moveLeft = moveLeft;
                this.moveRight = moveRight;
                this.shoot = shoot;
                this.player = player;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public List<T> getKeys() {
        return List.of(moveUp, moveDown, moveLeft, moveRight, shoot);
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public Optional<Command> startCommand(T command) {
        if (!lastCommand.equals(Optional.of(command))) {
            if (command.equals(shoot)) {
                return Optional.of(new Shoot(player));
            }
            lastCommand = Optional.of(command);
            if (command.equals(moveRight)) {
                return Optional.of(new Movement(Direction.RIGHT, player));
            }
            if (command.equals(moveLeft)) {
                return Optional.of(new Movement(Direction.LEFT, player));
            }
            if (command.equals(moveUp)) {
                return Optional.of(new Movement(Direction.UP, player));
            }
            if (command.equals(moveDown)) {
                return Optional.of(new Movement(Direction.DOWN, player));
            }
        }
        return Optional.empty();
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public Optional<Command> stopCommand(T command) {
        if (!lastCommand.equals(Optional.of(command)) || command.equals(shoot)) {
            return Optional.empty();
        }
        lastCommand = Optional.empty();
        return Optional.of(new Movement(Direction.NONE, player));
    }
}