package it.unibo.tankbattle.model.gamesetup.impl;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import it.unibo.tankbattle.model.gamesetup.api.DataList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.ArrayList;
import java.util.List;

/**
 * An Implementation of {@link DataList} for the map.
 */
@XmlRootElement(name = "mapList")
@XmlAccessorType (XmlAccessType.FIELD)
public class MapDataList implements DataList<MapData> {

    @XmlElement(name = "map")
    private final List<MapData> map = new ArrayList<>();

    /**
    * {@inheritDoc}
    */
    @Override
    public List<MapData> getData() {
        return new ArrayList<>(map);
    }
}
