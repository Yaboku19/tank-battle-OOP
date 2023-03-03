package it.unibo.tankBattle.common;

/**
 * 2 dimentional point
 */
public class P2d {
    
    private int x;
    private int y;

    public P2d(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public P2d sum(final P2d v) {
        return new P2d(x + v.getX(), y + v.getY());
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public V2d sub(final P2d v) {
        return new V2d(x - v.x, y - v.y);
    }

    public String toString() {
        return "P2d("+x+","+y+")";
    }

}
