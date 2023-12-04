package ObjectDetection.image;
import java.awt.Color;

import ObjectDetection.util.Pair;

public class PixelGroup {
    private final Color averageColor;
    private final Pair location;

    /**
     * Creates a new PixelGroup with RGB values and a Pair consisting of 2 points.
     * 
     * @param r The red value for the color.
     * @param g The green value for the color.
     * @param b The blue value for the color.
     * @param location The Pair of points which the PixelGroup exists in a matrix of PixelGroups.
     */
    public PixelGroup(float r, float g, float b, Pair location) {
        this.averageColor = new Color(r, g, b);
        this.location = location;
    }

    /**
     * Creates a new PixelGroup with RGB values, alpha, and a Pair consisting of 2 points.
     * 
     * @param r The red value for this color.
     * @param g The green value for this color.
     * @param b The blue value for this color.
     * @param a The alpha (transparency) for this color.
     * @param location The Pair of points which the PixelGroup exists in a matrix of PixelGroups.
     */
    public PixelGroup(float r, float g, float b, float a, Pair location) {
        this.averageColor = new Color(r, g, b, a);
        this.location = location;
    }

    public PixelGroup(int colorAsBits, Pair location) {
        this.averageColor = new Color(colorAsBits);
        this.location = location;
    }

    public PixelGroup(int colorAsBits, boolean hasAlpha, Pair location) {
        this.averageColor = new Color(colorAsBits, hasAlpha);
        this.location = location;
    }

    public Color getColor() {
        return averageColor;
    }

    public Pair getLocation() {
        return location;
    }

    /**
     * Returns the RGB value representing the color of the pixel group. 
     * According to Java docs, bits 24-31 are alpha, 8-15 are green, 0-7 are blue.
     * @return The color of the PixelGroup as bits.
     */
    public int getColorAsBits() {
        return averageColor.getRGB();
    }
}
