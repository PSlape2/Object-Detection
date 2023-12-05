package ObjectDetection.image;

import ObjectDetection.camera.*;
import ObjectDetection.util.Pair;
import ObjectDetection.util.UnevenMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Processor {
    private Camera camera;
    private BufferedImage image;
    private int pixelsPerGroup;
    private UnevenMatrix pixelGroups;

    /**
     * Creates a new image Processor
     * 
     * @param camera    The Camera being used to process information about the image.
     * @param pixels    The number of pixels in a PixelGroup.
     * @param file      The File which the image is stored at.
     */
    public Processor(Camera camera, int pixels, File file) {
        this.camera = camera;
        pixelsPerGroup = pixels;
        setImage(file);

        pixelGroups = new UnevenMatrix(image.getWidth() / pixels, image.getHeight() / pixels);
        process();
    }

    /**
     * Creates a new image Processor
     * 
     * @param cameraType    The CameraType representing the Camera being used to process information about the image.
     * @param pixels        The number of pixels in a PixelGroup.
     * @param file          The File which the image is stored at.
     */
    public Processor(CameraType cameraType, int pixels, File file) {
        camera = Camera.getCamera(cameraType);
        pixelsPerGroup = pixels;
        setImage(file);

        pixelGroups = new UnevenMatrix(image.getWidth() / pixels, image.getHeight() / pixels);
        process();
    }

    /**
     * Sets the image being processed
     * 
     * @param file The File which the image is stored at.
     */
    public void setImage(File file) {
        try {
            image = ImageIO.read(file);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public Camera getCamera() { return camera; }
    public void setCamera(Camera camera) { this.camera = camera; }
    public void setCamera(CameraType cameraType) { camera = Camera.getCamera(cameraType); }

    public BufferedImage getImage() { return image; }
    public void setImage(BufferedImage image) { this.image = image; }

    public int getPixelsPerGroup() { return pixelsPerGroup; }
    public void setPixelsPerGroup(int pixels) { pixelsPerGroup = pixels; }

    public Pair getDimensions() {
        return new Pair(image.getWidth(), image.getHeight());
    }

    /**
     * Processes the image into PixelGroups, then stores them in the UnevenMatrix called pixelGroups.
     */
    public void process() {
        for(int x = 0; x < image.getWidth(); x += pixelsPerGroup) {
            for(int y = 0; y < image.getHeight(); y += pixelsPerGroup) {
                pixelGroups.add(new PixelGroup(
                    getAverageColor(x, y),
                    new Pair(x, y)
                ));
            }
        }
    }

    /**
     * Finds the average RGB values for a PixelGroup.
     * 
     * @param x     The starting x coordinate pixel in the image.
     * @param y     The starting y coordinate pixel in the image.
     * 
     * @return      The average color of the PixelGroup in bits.
     */
    public int getAverageColor(int x, int y) {
        int[] colorBits = new int[pixelsPerGroup];
        int[] alpha = new int[pixelsPerGroup];
        int[] red = new int[pixelsPerGroup];
        int[] green = new int[pixelsPerGroup];
        int[] blue = new int[pixelsPerGroup];

        for(int i = 0; i < pixelsPerGroup / 2; i++) {
            colorBits[i] = image.getRGB(i, y);
            alpha[i] = (colorBits[i] >> 24) & 0xff;
            red[i] = (colorBits[i] >> 16) & 0xff;
            green[i] = (colorBits[i] >> 8) & 0xff;
            blue[i] = colorBits[i] & 0xff;
        }
        for(int i = 0; i < pixelsPerGroup / 2; i++) {
            colorBits[i+2] = image.getRGB(x, i);
            alpha[i+2] = (colorBits[i+2] >> 24) & 0xff;
            red[i+2] = (colorBits[i+2] >> 16) & 0xff;
            green[i+2] = (colorBits[i+2] >> 8) & 0xff;
            blue[i+2] = colorBits[i+2] & 0xff;
        }

        int alphaSum = 0;
        int redSum = 0;
        int greenSum = 0;
        int blueSum = 0;

        for(int i = 0; i < pixelsPerGroup; i++) {
            alphaSum += alpha[i];
            redSum += red[i];
            greenSum += green[i];
            blueSum += blue[i];
        }
        
        alphaSum /= alpha.length;
        redSum /= red.length;
        greenSum /= green.length;
        blueSum /= blue.length;

        return (alphaSum << 24) | (redSum << 16) | (greenSum << 8) | blueSum;
    }
}
