package it.unibo.tankBattle.common;

public enum NextAndPrevious {
    NEXT(1), PREVIOUS(-1), NONE(0);

    private int delta;

    private NextAndPrevious(final int delta) {
        this.delta = delta;
    }

    public int getDelta() {
        return delta;
    }
}
