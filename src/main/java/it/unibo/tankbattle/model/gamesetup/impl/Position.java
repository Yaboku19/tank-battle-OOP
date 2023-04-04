package it.unibo.tankbattle.model.gamesetup.impl;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import it.unibo.tankbattle.common.Point2d;
import javax.xml.bind.annotation.XmlAccessType;

/**
 * Represents the format for the position {@link Point2d} inside the xml files.
 */
@XmlRootElement (name = "position")
@XmlAccessorType (XmlAccessType.FIELD)
public class Position {
    @XmlElement
    private double x;
    @XmlElement
    private double y;
    @XmlElement
    private String type;

    /**
     * Gets the type.
     * @return return the type of the position
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the position.
     * @return return the position
     */
    public Point2d getPosition() {
        return new Point2d(x, y);
    }
}
