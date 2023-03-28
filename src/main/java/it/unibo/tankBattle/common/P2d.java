package it.unibo.tankBattle.common;

/**
 * 2 dimentional point
 */
public class P2d {
    
    private double x;
    private double y;

    public P2d(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public P2d sum(final P2d v) {
        return new P2d(x + v.getX(), y + v.getY());
    }
    
    public P2d multiply(final double multiplier) {
        return new P2d(x * multiplier, y * multiplier);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getMagnitude() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public String toString() {
        return "P2d("+x+","+y+")";
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        P2d other = (P2d) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
}
