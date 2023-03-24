package it.unibo.tankBattle.model.gameSetup.impl;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import it.unibo.tankBattle.model.gameSetup.api.DataList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@XmlRootElement(name = "mapList")
@XmlAccessorType (XmlAccessType.FIELD)
public class MapDataList implements DataList<MapData>{

    @XmlElement(name = "map")
    private List<MapData> map = new ArrayList<>();

    /**
     * @return List<MapData> list
     */
    public List<MapData> getData() {
        return this.map;
    }

    /**
     * @param map MapData list
     */
    public void setData(final List<MapData> map) {
        this.map = map;
    }

}
