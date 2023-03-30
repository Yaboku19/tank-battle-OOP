package it.unibo.tankbattle.common.input.impl;

import java.util.List;

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
    public Command startCommand(T command) {
        if(command.equals(moveRight)) {
            return new Movement(Direction.RIGHT, player);
        }
        if(command.equals(moveLeft)) {
            return new Movement(Direction.LEFT, player);
        }
        if(command.equals(moveUp)) {
            return new Movement(Direction.UP, player);
        }
        if(command.equals(moveDown)) {
            return new Movement(Direction.DOWN, player);
        }
        //if(command.equals(shoot)) {
            return new Shoot(player);
        //}
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public Command stopCommand(T command) {
        //if(this.getKeys().contains(command)){//command.equals(moveRight) || command.equals(moveLeft) || command.equals(moveUp) || command.equals(moveDown)) {
            return new Movement(Direction.NONE, player);
        //}
    }
}
/*

final String event = e.getCode().toString() + e.getEventType().toString();
            if (!lastCommandFirstPlayer.equals(event)) {
                if (!lastCommandSecondPlayer.equals(event)) {

                if (e.getEventType().equals(KeyEvent.KEY_RELEASED)) {
                    final String event = e.getCode().toString() + e.getEventType().toString();
                    switch (e.getCode()) {
                        case RIGHT, LEFT, UP, DOWN:
                            System.out.println(e.getCode());
                            controller.notifyCommand(new Movement(Direction.NONE, controller.getFirstPlayer()));
                            lastCommandFirstPlayer = event;
                        break;
                        case D, A, W, S:
                            System.out.println(e.getCode());
                            controller.notifyCommand(new Movement(Direction.NONE, controller.getSecondPlayer()));
                            lastCommandSecondPlayer = event;
                        break;
                        default:
                    }
                }
                */