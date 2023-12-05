package ObjectDetection.image;
import java.awt.Color;

import ObjectDetection.util.Pair;

public class PixelGroup {
    private final Color averageColor;
    private final Pair location;

    /**
     * Creates a new PixelGroup with RGB values and a Pair consisting of 2 points.
     * 
     * @param r         The red value for the color.
     * @param g         The green value for the color.
     * @param b         The blue value for the color.
     * @param location  The Pair of points which the PixelGroup exists in a matrix of PixelGroups.
     */
    public PixelGroup(float r, float g, float b, Pair location) {
        this.averageColor = new Color(r, g, b);
        this.location = location;
    }

    /**
     * Creates a new PixelGroup with RGB values, alpha, and a Pair consisting of 2 points.
     * 
     * @param r         The red value for this color.
     * @param g         The green value for this color.
     * @param b         The blue value for this color.
     * @param a         The alpha (transparency) for this color.
     * @param location  The Pair of points which the PixelGroup exists in a matrix of PixelGroups.
     */
    public PixelGroup(float r, float g, float b, float a, Pair location) {
        averageColor = new Color(r, g, b, a);
        this.location = location;
    }

    /**
     * Creates a new PixelGroup with an int containing the bits for RGB and a Pair with 2 points.
     * @param colorAsBits   The bits representing the color of the pixel group.
     * @param location      The Pair of points which the PixelGroup exists in a matrix of PixelGroups
     */
    public PixelGroup(int colorAsBits, Pair location) {
        averageColor = new Color(colorAsBits);
        this.location = location;
    }

    /**
     * Creates a new PixelGroup with an int containing the bits for RGB and a Pair with 2 points.
     * @param colorAsBits   The bits representing the color of the pixel group.
     * @param hasAlpha      Indicates whether or not the previous variable includes transparency.
     * @param location      The Pair of points which the PixelGroup exists in a matrix of PixelGroups
     */
    public PixelGroup(int colorAsBits, boolean hasAlpha, Pair location) {
        averageColor = new Color(colorAsBits, hasAlpha);
        this.location = location;
    }

    /**
     * Creates a new PixelGroup with an java.awt.Color object and a Pair with 2 points.
     * 
     * @param color     The java.awt.Color representing the color of the PixelGroup.
     * @param location  The Pair of points which the PixelGroup exists in a matrix of PixelGroups.
     */
    public PixelGroup(Color color, Pair location) {
        averageColor = color;
        this.location = location;
    }

    /*
    public PixelGroup(float r, float g, float b) {
        averageColor = new Color(r, g, b);
        location = null;
    }
    
    public PixelGroup(float r, float g, float b, float a) {
        averageColor = new Color(r, g, b, a);
        location = null;
    }

    public PixelGroup(int colorAsBits) {
        averageColor = new Color(colorAsBits);
        location = null;
    }

    public PixelGroup(int colorAsBits, boolean hasAlpha) {
        averageColor = new Color(colorAsBits, hasAlpha);
        location = null;
    }
    */

    

    /**
     * Gets the color of the PixelGroup
     * 
     * @return  The color of the PixelGroup as an java.awt.Color object.
     */
    public Color getColor() {
        return averageColor;
    }

    /**
     * Gets the position of the PixelGroup.
     * 
     * @return  The position of the PixelGroup as an ObjectDetection.util.Pair object.
     */
    public Pair getLocation() {
        return location;
    }

    /**
     * Returns the RGB value representing the color of the pixel group. 
     * According to Java docs, bits 24-31 are alpha, 16-23 are red, 8-15 are green, 0-7 are blue.
     * 
     * @return The color of the PixelGroup as bits.
     */
    public int getColorAsBits() {
        return averageColor.getRGB();
    }
}
