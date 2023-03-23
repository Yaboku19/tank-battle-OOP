package it.unibo.tankBattle.view.api;

import javafx.scene.image.Image;

/**
 * Enumeration used for Tank images.
 */
public enum TankImage {

    /**
     * SIMPLETANK.
     */
    SIMPLETANK("simpleTank.gif"),

    /**
     * RAPIDTANK.
     */
    RAPIDTANK("rapidTank.png"),

    /**
     * SUPERPOWERTANK.
     */
    SUPERPOWERTANK("superPower.png");

    private final String FILESEPARATOR = System.getProperty("file.separator");
    private final String PATH = "images" + "/" + "tank" + "/";
    private final Image image;

    /**
     * @param imagename
     *                  name of the image stored in resources
     */
    private TankImage(final String imagename) {
        //System.out.println("path "+ PATH + imagename);
        image = new Image(ClassLoader.getSystemResource(PATH + imagename).toExternalForm());
    }

    /**
     * @return
     *          the person image
     */
    public Image getImage() {
        return this.image;
    }

    public TankImage next(){
		return TankImage.values()[(this.ordinal()+1) % TankImage.values().length];
	}

    public TankImage prev(){
		return TankImage.values()[(this.ordinal()-1 + TankImage.values().length) % TankImage.values().length];
	}
}
