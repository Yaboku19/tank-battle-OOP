package it.unibo.tankBattle.common;

/**
 * 2 dimentional vector
 */
public class V2d {
    
    private int x;
    private int y;
    
    public V2d(final int x, final int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public V2d(final P2d to, final P2d from){
        this.x = to.getX() - from.getX();
        this.y = to.getY() - from.getY();
    }

    public V2d sum(final V2d v){
        return new V2d(x + v.x, y + v.y);
    }

    public String toString(){
        return "V2d("+x+","+y+")";
    }
}
