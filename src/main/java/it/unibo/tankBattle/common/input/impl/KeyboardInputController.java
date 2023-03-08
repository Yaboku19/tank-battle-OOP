package it.unibo.tankBattle.common.input.impl;

import java.util.List;
import java.util.Queue;

import it.unibo.tankBattle.common.input.api.Command;
import it.unibo.tankBattle.common.input.api.InputController;

public class KeyboardInputController implements InputController{

    private int keyCodeMoveUp;
    private int keyCodeMoveDown;
    private int keyCodeMoveLeft;
    private int keyCodeMoveRight;
    private int keyCodeShoot;

    public KeyboardInputController(final int keyCodeMoveUp, final int keyCodeMoveDown, final int keyCodeMoveLeft,
        final int keyCodeMoveRight, final int keyCodeShoot){

                this.keyCodeMoveUp = keyCodeMoveUp;
                this.keyCodeMoveDown = keyCodeMoveDown;
                this.keyCodeMoveLeft = keyCodeMoveLeft;
                this.keyCodeMoveRight = keyCodeMoveRight;
                this.keyCodeShoot = keyCodeShoot;
            }

    @Override
    public List<Integer> getKeyCodes() {
        return List.of(keyCodeMoveUp,keyCodeMoveDown, keyCodeMoveLeft, keyCodeMoveRight, keyCodeShoot);
    }


    /*@Override
    public Queue<Command> getCommands() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCommands'");
    }*/
    
}