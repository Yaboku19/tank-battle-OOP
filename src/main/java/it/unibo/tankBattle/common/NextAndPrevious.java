package it.unibo.tankBattle.common;
/**
 * javadoc.
 */
public enum NextAndPrevious {
    /**
     * javadoc.
     */
    NEXT(1), PREVIOUS(-1), NONE(0);

    private int delta;

    NextAndPrevious(final int delta) {
        this.delta = delta;
    }
    /**
     * javadoc.
     * @return return
     */
    public int getDelta() {
        return delta;
    }
}
