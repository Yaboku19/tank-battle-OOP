package it.unibo.tankbattle.model.gamesetup.impl;

import javax.xml.bind.annotation.XmlRootElement;
import it.unibo.tankbattle.model.gamesetup.api.Data;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;

/**
 * An implementation of {@link Data} for the tank in xml file.
 */
@XmlRootElement (name = "tank")
@XmlAccessorType (XmlAccessType.FIELD)
public class TankData implements Data {

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
    * {@inheritDoc}
    */
    @Override
    public String getName() {
        return name;
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
     * Create a copy of the Object.
     * @return the copy
     */
    public TankData copy() {
        final TankData copy = new TankData();
        copy.name = name;
        copy.code = code;
        copy.speed = speed;
        copy.damage = damage;
        copy.life = life;
        copy.resource = resource;
        return copy;
    }
}
