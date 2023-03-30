package it.unibo.tankbattle.common.input.impl;

import java.lang.StackWalker.Option;
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
     * javadoc.
     * @param moveUp param
     * @param moveDown param
     * @param moveLeft param
     * @param moveRight param
     * @param shoot param
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
            if (command.equals(shoot)) {
                return Optional.of(new Shoot(player));
            }
        }
        return Optional.empty();
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public Command stopCommand(T command) {
        lastCommand = Optional.empty();
        return new Movement(Direction.NONE, player);
    }
}