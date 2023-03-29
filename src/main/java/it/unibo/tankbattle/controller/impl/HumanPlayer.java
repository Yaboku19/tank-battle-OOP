package it.unibo.tankbattle.controller.impl;

import it.unibo.tankbattle.controller.api.Player;
import it.unibo.tankbattle.model.gamesetup.impl.TankData;
/**
 * javadoc.
 */
public class HumanPlayer implements Player {
    private int score;
    private final String name;
    private final TankData tankData;
    /**
     * javadoc.
     * @param name param
     * @param tankData param
     */
    HumanPlayer(final String name, final TankData tankData) {
        this.score = 0;
        this.name = name;
        this.tankData = tankData;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public int getScore() {
        return score;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public void incScore() {
        score++;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public String getName() {
        return name;
    }
    /**
    * {@inheritDoc}
    */
    @Override
    public TankData getTankData() {
       return tankData;
    }
}
