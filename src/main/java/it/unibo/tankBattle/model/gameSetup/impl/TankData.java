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
@XmlRootElement (name = "tank")
@XmlAccessorType (XmlAccessType.FIELD)
public class TankData implements Data{

    @XmlAttribute
    private String name;
    @XmlElement
    private int code;
    @XmlElement
    private int speed;
    @XmlElement
    private int damage;
    @XmlElement
    private int life;
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
     * @return the maxIncubationPeriod
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Gets the virus' minimum recovery period.
     * @return the minRecoveryPeriod
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Gets the virus' maximum incubation period.
     * @return the maxRecoveryPeriod
     */
    public int getLife() {
        return life;
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
     * Sets the virus' minimum incubation period.
     * @param minIncubationPeriod the minIncubationPeriod to set
     */
    public void setSpeed(final int speed) {
        this.speed = speed;
    }

    /**
     * Sets the virus' maximum incubation period.
     * @param maxIncubationPeriod the maxIncubationPeriod to set
     */
    public void setLife(final int life) {
        this.life = life;
    }

    /**
     * Sets the virus' infectivity rate.
     * @param infectivity the infectivity to set
     */
    public void setDamage(final int damage) {
        this.damage = damage;
    }

    /**
     * Gets the virus' maximum incubation period.
     * @return the maxRecoveryPeriod
     */
    public void setResource(final String resource) {
        this.resource = resource;
    }
}


