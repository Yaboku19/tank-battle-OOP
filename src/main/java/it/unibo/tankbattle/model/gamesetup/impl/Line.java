package it.unibo.tankbattle.model.gamesetup.impl;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import it.unibo.tankbattle.common.Point2d;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;

/**
 * Represents the format of a {@link Data} line in xml files.
 */
@XmlRootElement (name = "line")
@XmlAccessorType (XmlAccessType.FIELD)
public class Line {
    @XmlElement(name = "common")
    private double common;
    @XmlElement(name = "notcommon1")
    private double notCommon1;
    @XmlElement(name = "notcommon2")
    private double notCommon2;
    @XmlElement(name = "type")
    private String type;

    /**
     * Gets data line.
     * @return return the line of data
     */
    public Set<Point2d> getLine() {
        final Set<Point2d> line = new HashSet<>();
        for (double i = notCommon1; i <= notCommon2; i++) {
            line.add(generatePosition(i));
        }
        return line;
    }

    private Point2d generatePosition(final double i) {
        if ("column".equals(type)) {
            return new Point2d(common, i);
        } else  if ("row".equals(type)) {
            return new Point2d(i, common);
        } else {
            throw new IllegalStateException();
        }
    }
}
