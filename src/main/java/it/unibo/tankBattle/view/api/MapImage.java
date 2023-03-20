package it.unibo.tankBattle.view.api;

import javafx.scene.image.Image;

/**
 * Enumeration used for Map images.
 */
public enum MapImage {

    /**
     * BACKGROUND.
     */
    BACKGROUND("background.png"),

    /**
     * MAP1.
     */
    MAP1("map1.png"),

    /**
     * MAP2.
     */
    MAP2("map2.png"),

    /**
     * MAP3.
     */
    MAP3("map3.png");

    private final String FILESEPARATOR = System.getProperty("file.separator");
    private final String PATH = "images" + FILESEPARATOR + "map" + FILESEPARATOR;
    private final Image image;

    /**
     * @param imagename
     *                  name of the image stored in resources
     */
    private MapImage(final String imagename) {
        image = new Image(ClassLoader.getSystemResource(PATH + imagename).toExternalForm());
    }

    /**
     * @return
     *          the person image
     */
    public Image getImage() {
        return this.image;
    }
}
