package it.unibo.tankbattle.common.input.impl;

import java.util.List;

import it.unibo.tankbattle.common.input.api.InputController;
/**
 * javadoc.
 */
public class KeyboardInputController implements InputController {

    private int keyCodeMoveUp;
    private int keyCodeMoveDown;
    private int keyCodeMoveLeft;
    private int keyCodeMoveRight;
    private int keyCodeShoot;
    /**
     * javadoc.
     * @param keyCodeMoveUp param
     * @param keyCodeMoveDown param
     * @param keyCodeMoveLeft param
     * @param keyCodeMoveRight param
     * @param keyCodeShoot param
     */
    public KeyboardInputController(final int keyCodeMoveUp, final int keyCodeMoveDown, final int keyCodeMoveLeft,
        final int keyCodeMoveRight, final int keyCodeShoot) {

                this.keyCodeMoveUp = keyCodeMoveUp;
                this.keyCodeMoveDown = keyCodeMoveDown;
                this.keyCodeMoveLeft = keyCodeMoveLeft;
                this.keyCodeMoveRight = keyCodeMoveRight;
                this.keyCodeShoot = keyCodeShoot;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public List<Integer> getKeyCodes() {
        return List.of(keyCodeMoveUp, keyCodeMoveDown, keyCodeMoveLeft, keyCodeMoveRight, keyCodeShoot);
    }


    /*@Override
    public Queue<Command> getCommands() {
        throw new UnsupportedOperationException("Unimplemented method 'getCommands'");
    }*/

}
