package it.unibo.tankBattle.model.api;

public interface GameState {
    public void getScore(); //0-0 1-0

    public boolean isOver(); // a tank with 0 health

    public void update();

    public void increaseScore();
}
