package it.unibo.tankBattle.view.api;

import java.util.Set;
import java.util.stream.Stream;

import it.unibo.tankBattle.common.NextAndPrevious;
import it.unibo.tankBattle.common.Transform;
import it.unibo.tankBattle.controller.api.GameEngine;

public interface View {
    
    /*public void drawTank(Transform position);

    public void drawBullet(Transform position);*/

    public void gameOver();

    public void render(Transform firstTank, Transform secondTank, Stream<Transform> wall, Stream<Transform> bullet);

    //public void drawWall(Set<Transform> wall);

    public void setController(GameEngine controller);  

    public void updateTankPlayer1(NextAndPrevious delta);

    public void updateTankPlayer2(NextAndPrevious delta);

    public void updateMap(NextAndPrevious delta);

    public void viewUpdateP1(int speed, int damage, int life, String resource);

    public void viewUpdateP2(int speed, int damage, int life, String resource);

    public void viewUpdateMap(String resource);
}
