package it.unibo.tankbattle.common;

/**
 * This class represents a point 2D.
 */
public class Point2d {

    private final double x;
    private final double y;

    /**
     * @param x x element.
     * @param y y element.
     */
    public Point2d(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param v a point 2D.
     * @return point 2D summed with v.
     */
    public Point2d sum(final Point2d v) {
        return new Point2d(x + v.getX(), y + v.getY());
    }

    /**
     * @param multiplier a scalar number.
     * @return point 2D multiplied by multiplier.
     */
    public Point2d multiply(final double multiplier) {
        return new Point2d(x * multiplier, y * multiplier);
    }

    /**
     * @return x coordinate
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return y coordinate
     */
    public double getY() {
        return this.y;
    }

    /**
     * @return Pythagorean theorem between the coordinates
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
        final Point2d other = (Point2d) obj;
        return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x) 
            && Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
    }
}
