package it.unibo.tankbattle.model.gamesetup.impl;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import it.unibo.tankbattle.common.P2d;
import javax.xml.bind.annotation.XmlAccessType;

/**
 * rappresent the format for the position {@link P2d} inside the xml files.
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
     * 
     * @return return the type of the position
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @return return the position
     */
    public P2d getPosition() {
        return new P2d(x, y);
    }
}
