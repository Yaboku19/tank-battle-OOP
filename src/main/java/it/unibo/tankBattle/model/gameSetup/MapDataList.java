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
@XmlRootElement(name = "mapList")
@XmlAccessorType (XmlAccessType.FIELD)
public class MapDataList {

    @XmlElement(name = "map")
    private List<MapData> map = new ArrayList<>();

    /**
     * @return List<MapData> lists
     */
    public List<MapData> getMaps() {
        return this.map;
    }

    /**
     * @param map MapData list
     */

    public void setMap(final List<MapData> map) {
        this.map = map;
    }

}
