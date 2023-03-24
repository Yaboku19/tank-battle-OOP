package it.unibo.tankBattle.model.gameSetup.impl;

import javax.xml.bind.annotation.XmlRootElement;

import it.unibo.tankBattle.model.gameSetup.api.Data;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;

/**
 *
 */
@XmlRootElement (name = "map")
@XmlAccessorType (XmlAccessType.FIELD)
public class MapData implements Data{

    @XmlAttribute
    private String name;
    @XmlElement
    private int code;
    @XmlElement
    private String resource;

    /**
     * Gets the virus' name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the virus' minimum incubation period.
     * @return the minIncubationPeriod
     */
    public int getCode() {
        return code;
    }

    /**
     * Gets the virus' maximum incubation period.
     * @return the maxRecoveryPeriod
     */
    public String getResource() {
        return resource;
    }

    /**
     * sets the virus' name.
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Sets the virus' minimum incubation period.
     * @param minIncubationPeriod the minIncubationPeriod to set
     */
    public void setCode(final int code) {
        this.code = code;
    }

     /**
     * Gets the virus' maximum incubation period.
     * @return the maxRecoveryPeriod
     */
    public void setResource(final String resource) {
        this.resource = resource;
    }

}



