package it.unibo.tankBattle.model.api;

public interface GameObject {

    public void getPosition(); 

    public void update(); // at each frame

    public void getBoundingBox(); // getter of the hitbox

    public boolean colliding(); // when his hitted, true is alive, false if not

    public int getSpeed(); 
    
}
