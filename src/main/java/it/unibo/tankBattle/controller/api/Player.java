package it.unibo.tankBattle.controller.api;

import it.unibo.tankBattle.model.gameSetup.impl.TankData;

public interface Player {

    public int getScore();

    public void incScore();

    public String getCode();

    public TankData getTankData();
}
