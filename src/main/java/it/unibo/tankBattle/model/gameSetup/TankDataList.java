package it.unibo.tankBattle.model.gameSetup;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@XmlRootElement(name = "tankList")
@XmlAccessorType (XmlAccessType.FIELD)
public class TankDataList {

    @XmlElement(name = "tank")
    private List<TankData> tank = new ArrayList<>();

    /**
     * @return List<TankData> lists
     */
    public List<TankData> getTanks() {
        return this.tank;
    }

    /**
     * @param tank TankData list
     */

    public void setTank(final List<TankData> tank) {
        this.tank = tank;
    }

}
