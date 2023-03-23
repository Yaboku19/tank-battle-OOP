package it.unibo.tankBattle.common;

public enum ButtonDirection {
    NEXT(1), PREVIOUS(-1);

    private int delta;

    private ButtonDirection(final int delta) {
        this.delta = delta;
    }

    public int getDelta() {
        return delta;
    }
}
