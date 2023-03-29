package it.unibo.tankbattle.common;

/**
 * javadoc.
 */
public class P2d {

    private double x;
    private double y;
    /**
     * javadoc.
     * @param x param
     * @param y param
     */
    public P2d(final double x, final double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * javadoc.
     * @param v param
     * @return return
     */
    public P2d sum(final P2d v) {
        return new P2d(x + v.getX(), y + v.getY());
    }
    /**
     * javadoc.
     * @param multiplier param
     * @return return
     */
    public P2d multiply(final double multiplier) {
        return new P2d(x * multiplier, y * multiplier);
    }
    /**
     * javadoc.
     * @return return
     */
    public double getX() {
        return this.x;
    }
    /**
     * javadoc.
     * @return return
     */
    public double getY() {
        return this.y;
    }
    /**
     * javadoc.
     * @return return
     */
    public double getMagnitude() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public String toString() {
        return "P2d(" + x + "," + y + ")";
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        P2d other = (P2d) obj;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return true;
    }
}
