package it.unibo.tankBattle.model.gameSetup.impl;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import it.unibo.tankBattle.model.gameSetup.api.DataList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import java.util.ArrayList;
import java.util.List;

/**
 * javadock.
 */
@XmlRootElement(name = "tankList")
@XmlAccessorType (XmlAccessType.FIELD)
public class TankDataList implements DataList<TankData> {

    @XmlElement(name = "tank")
    private List<TankData> tank = new ArrayList<>();

    /**
     * @return List<TankData> list
     */
    public List<TankData> getData() {
        return this.tank;
    }

    /**
     * @param tank TankData list
     */

    public void setData(final List<TankData> tank) {
        this.tank = tank;
    }

}
