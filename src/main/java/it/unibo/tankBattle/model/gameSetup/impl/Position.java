package it.unibo.tankBattle.model.gameSetup.impl;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import it.unibo.tankBattle.common.P2d;
import javax.xml.bind.annotation.XmlAccessType;
/**
 * javadock.
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
     * javadock.
     * @return return
     */
    public String getType() {
        return type;
    }
    /**
     * javadock.
     * @return return
     */
    public P2d getPosition() {
        return new P2d(x, y);
    }
}
