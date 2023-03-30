package it.unibo.tankbattle.model.gamesetup.impl;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import it.unibo.tankbattle.common.P2d;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
/**
 * javadock.
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
     * javadoc.
     * @return return
     */
    public Set<P2d> getLine() {
        final Set<P2d> line = new HashSet<>();
        for (double i = notCommon1; i <= notCommon2; i++) {
            System.out.println(i);
            line.add(generatePosition(i));
        }
        return line;
    }

    private P2d generatePosition(final double i) {
        if ("column".equals(type)) {
            return new P2d(common, i);
        } else  if ("row".equals(type)) {
            return new P2d(i, common);
        } else {
            throw new IllegalStateException();
        }
    }
}
