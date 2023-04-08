package it.unibo.tankbattle.model.gamesetup.impl;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import it.unibo.tankbattle.model.gamesetup.api.DataList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.ArrayList;
import java.util.List;

/**
 * An Implementation of {@link DataList} for the tank.
 */
@XmlRootElement(name = "tankList")
@XmlAccessorType (XmlAccessType.FIELD)
public class TankDataList implements DataList<TankData> {

    @XmlElement(name = "tank")
    private final List<TankData> tank = new ArrayList<>();

    /**
    * {@inheritDoc}
    */
    @Override
    public List<TankData> getData() {
        return new ArrayList<>(tank);
    }
}
