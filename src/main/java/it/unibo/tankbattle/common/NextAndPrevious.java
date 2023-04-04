package it.unibo.tankbattle.common;
/**
 * This enum represent simple next and previous selection.
 */
public enum NextAndPrevious {

    /**
     * Next (+1).
     */
    NEXT(1),

    /**
     *Previous (-1).
     */
    PREVIOUS(-1),

    /**
     *Nothing to change (0).
     */
    NONE(0);

    private int delta;

    /**
     * @param delta delta.
     */
    NextAndPrevious(final int delta) {
        this.delta = delta;
    }

    /**
     * @return delta changing.
     */
    public int getDelta() {
        return delta;
    }
}
