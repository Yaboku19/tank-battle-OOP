package it.unibo.tankbattle.controller.impl;

import it.unibo.tankbattle.controller.api.Player;
import it.unibo.tankbattle.model.gamesetup.impl.TankData;

/**
 * an implementation of Player {@link Player}.
 */
public class HumanPlayer implements Player {
    private final String name;
    private final TankData tankData;

    /**
     * the constructor of HumanPLayer with two arguments.
     * @param name the name of the player
     * @param tankData the data of the tank
     */
    HumanPlayer(final String name, final TankData tankData) {
        this.name = name;
        this.tankData = tankData;
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
       return tankData.copy();
    }
}
