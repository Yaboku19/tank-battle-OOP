package it.unibo.tankBattle.model.gameSetup;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;

/**
 *
 */
@XmlRootElement (name = "map")
@XmlAccessorType (XmlAccessType.FIELD)
public class MapData {

    @XmlAttribute
    private String name;
    @XmlElement
    private int code;
    @XmlElement
    private String resource;

    /**
     * Gets the map name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the map code.
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Gets the map resourceImage.
     * @return the resourceImage
     */
    public String getResource() {
        return resource;
    }

    /**
     * sets the map name.
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * sets the map code.
     * @param code the code to set
     */
    public void setCode(final int code) {
        this.code = code;
    }

     /**
     * sets the map resource.
     * @param resource the resource to set
     */
    public void setResource(final String resource) {
        this.resource = resource;
    }

}



