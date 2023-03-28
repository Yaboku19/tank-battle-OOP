package it.unibo.tankBattle.model.gameSetup.impl;

import javax.xml.bind.annotation.XmlRootElement;

import it.unibo.tankBattle.common.P2d;
import it.unibo.tankBattle.model.gameSetup.api.Data;

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
public class MapData implements Data{

    private static final int ROW = 9;
    private static final int COLUMN = 14;

    @XmlAttribute
    private String name;
    @XmlElement(name = "position")
    private List<Position> position = new ArrayList<>();
    @XmlElement
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

    public P2d getPositionFirstTank() {
        return position
            .stream()
            .filter(p -> p.getType().equals("tank1"))
            .findFirst()
            .get()
            .getPosition();
    }

    public P2d getPositionSecondTank() {
        return position
        .stream()
        .filter(p -> p.getType().equals("tank2"))
        .findFirst()
        .get()
        .getPosition();
    }

    public Set<P2d> getWall() {
        return addBorder(position
            .stream()
            .filter(p -> p.getType().equals("wall"))
            .map(p -> p.getPosition())
            .collect(Collectors.toSet()));
    }

    private Set<P2d> addBorder(final Set<P2d> wall) {
        for(int i = 0; i <= ROW; i++) {
            wall.add(new P2d(0, i));
            wall.add(new P2d(COLUMN, i));
        }
        for(int i = 1; i < COLUMN; i++) {
            wall.add(new P2d(i, 0));
            wall.add(new P2d(i, ROW));
        }
        return wall;
    }
}


