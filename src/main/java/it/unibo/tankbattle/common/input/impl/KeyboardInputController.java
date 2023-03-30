package it.unibo.tankbattle.common.input.impl;

import java.util.List;

import it.unibo.tankbattle.common.input.api.InputController;
/**
 * javadoc.
 */
public class KeyboardInputController<T> implements InputController<T> {

    private final T moveUp;
    private final T moveDown;
    private final T moveLeft;
    private final T moveRight;
    private final T shoot;
    /**
     * javadoc.
     * @param moveUp param
     * @param moveDown param
     * @param moveLeft param
     * @param moveRight param
     * @param shoot param
     */
    public KeyboardInputController(final T moveUp, final T moveDown, final T moveLeft,
        final T moveRight, final T shoot) {

                this.moveUp = moveUp;
                this.moveDown = moveDown;
                this.moveLeft = moveLeft;
                this.moveRight = moveRight;
                this.shoot = shoot;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public List<T> getKeys() {
        return List.of(moveUp, moveDown, moveLeft, moveRight, shoot);
    }


    /*@Override
    public Queue<Command> getCommands() {
        throw new UnsupportedOperationException("Unimplemented method 'getCommands'");
    }*/

}
