package it.unibo.tankbattle.model.gamesetup.impl;

import javax.xml.bind.annotation.XmlRootElement;
import it.unibo.tankbattle.common.P2d;
import it.unibo.tankbattle.model.gamesetup.api.Data;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.xml.bind.annotation.XmlAccessType;

/**
 * an implementation of {@link Data} for the map.
 */
@XmlRootElement (name = "map")
@XmlAccessorType (XmlAccessType.FIELD)
public class MapData implements Data {

    @XmlAttribute
    private String name;
    @XmlElement(name = "position")
    private final Set<Position> positions = new HashSet<>();
    @XmlElement(name = "line")
    private final Set<Line> lines = new HashSet<>();
    @XmlElement(name = "row")
    private int row;
    @XmlElement(name = "column")
    private int column;
    @XmlElement(name = "resource")
    private String resource;

    /**
    * {@inheritDoc}
    */
    @Override
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
     * 
     * @return get the position  {@link P2d} of the first tank
     */
    public P2d getPositionFirstTank() {
        return positions
            .stream()
            .filter(p -> "tank1".equals(p.getType()))
            .findFirst()
            .get()
            .getPosition();
    }

    /**
     * 
     * @return get the position {@link P2d} of the second tank
     */
    public P2d getPositionSecondTank() {
        return positions
        .stream()
        .filter(p -> "tank2".equals(p.getType()))
        .findFirst()
        .get()
        .getPosition();
    }

    /**
     * 
     * @return get a Set of position {@link P2d} of all the wall
     */
    public Set<P2d> getWall() {
        return addBorder(addLine(positions
            .stream()
            .filter(p -> "wall".equals(p.getType()))
            .map(p -> p.getPosition())
            .collect(Collectors.toSet())));
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

    private Set<P2d> addLine(final Set<P2d> wall) {
        for (final var line : lines) {
            wall.addAll(line.getLine());
        }
        return wall;
    }
}
