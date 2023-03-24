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
     * Gets the tank name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the tank code.
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Gets the tank speed.
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Gets the tank damage.
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Gets the tank life.
     * @return the life
     */
    public int getLife() {
        return life;
    }

    /**
     * Gets the tank resource.
     * @return the resource
     */
    public String getResource() {
        return resource;
    }

    /**
     * sets the tank name.
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * sets the tank code.
     * @param code the code to set
     */
    public void setCode(final int code) {
        this.code = code;
    }

    /**
     * sets the tank speed.
     * @param speed the speed to set
     */
    public void setSpeed(final int speed) {
        this.speed = speed;
    }

    /**
     * sets the tank life.
     * @param life the life to set
     */
    public void setLife(final int life) {
        this.life = life;
    }

    /**
     * sets the tank demage.
     * @param demage the demage to set
     */
    public void setDamage(final int damage) {
        this.damage = damage;
    }

    /**
     * sets the tank resource.
     * @param resource the resource to set
     */
    public void setResource(final String resource) {
        this.resource = resource;
    }
}


