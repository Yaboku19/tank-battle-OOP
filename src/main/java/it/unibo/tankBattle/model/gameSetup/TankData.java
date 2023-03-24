package it.unibo.tankBattle.model.gameSetup;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;

/**
 *
 */
@XmlRootElement (name = "tank")
@XmlAccessorType (XmlAccessType.FIELD)
public class TankData {

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
     * Gets the Player's name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the code
     * @return player code
     */
    public int getCode() {
        return code;
    }

    /**
     * Gets the Tank speed.
     * @return the tank's speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Gets the bullet damage of the tank.
     * @return the Tank's damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Gets the Tank's life points.
     * @return the the life points
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

   
    public void setName(final String name) {
        this.name = name;
    }

    
    public void setCode(final int code) {
        this.code = code;
    }

    
    public void setSpeed(final int speed) {
        this.speed = speed;
    }

    
    public void setLife(final int life) {
        this.life = life;
    }

    
    public void setDamage(final int damage) {
        this.damage = damage;
    }

    
    public void setResource(final String resource) {
        this.resource = resource;
    }
}


