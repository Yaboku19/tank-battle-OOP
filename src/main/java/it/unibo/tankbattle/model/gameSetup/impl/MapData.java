package it.unibo.tankbattle.model.gameSetup.impl;

import javax.xml.bind.annotation.XmlRootElement;

import it.unibo.tankbattle.common.P2d;
import it.unibo.tankbattle.model.gameSetup.api.Data;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlAccessType;

/**
 *
 */
@XmlRootElement (name = "map")
@XmlAccessorType (XmlAccessType.FIELD)
public class MapData implements Data {

    @XmlAttribute
    private String name;
    @XmlElement(name = "position")
    private List<Position> position = new ArrayList<>();
    @XmlElement(name = "row")
    private int row;
    @XmlElement(name = "column")
    private int column;
    @XmlElement(name = "resource")
    private String resource;

    /**
     * Gets the map name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the map resourceImage.
     * @return the resourceImage
     */
    public String getResource() {
        return resource;
    }
    /**
     * javadock.
     * @return return
     */
    public P2d getPositionFirstTank() {
        return position
            .stream()
            .filter(p -> p.getType().equals("tank1"))
            .findFirst()
            .get()
            .getPosition();
    }
    /**
     * javadock.
     * @return return
     */
    public P2d getPositionSecondTank() {
        return position
        .stream()
        .filter(p -> p.getType().equals("tank2"))
        .findFirst()
        .get()
        .getPosition();
    }
    /**
     * javadock.
     * @return return
     */
    public Set<P2d> getWall() {
        return addBorder(position
            .stream()
            .filter(p -> p.getType().equals("wall"))
            .map(p -> p.getPosition())
            .collect(Collectors.toSet()));
    }

    private Set<P2d> addBorder(final Set<P2d> wall) {
        for (int i = 0; i <= row; i++) {
            wall.add(new P2d(0, i));
            wall.add(new P2d(column, i));
        }
        for (int i = 1; i < column; i++) {
            wall.add(new P2d(i, 0));
            wall.add(new P2d(i, row));
        }
        return wall;
    }
}



