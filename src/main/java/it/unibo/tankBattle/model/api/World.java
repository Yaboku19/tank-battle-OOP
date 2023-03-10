package it.unibo.tankBattle.model.api;

public interface World {
    // getter tank, obstacles and bullet

    public void update();

    public void addBullet(/*Position position, Direction direction*/);

    public void collision(/*Tank tank */); // wall-tank, tank-tank

    public void bulletHitTank(/*Tank tank, Bullet bullet */); // wall-bullet

    public void bulletHitOther(/*Bullet bullet */); // bullet-bullet, bullet-wall
}
