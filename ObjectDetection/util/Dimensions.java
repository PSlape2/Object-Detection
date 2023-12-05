package ObjectDetection.util;

public class Dimensions {
    
    /**
     * Calculates the height of an object in mm using several dimensions.
     * 
     * @param imgHeight     The height of the object in pixels.
     * @param objHeight     The height of the image in pixels.
     * @param sensorHeight  The height of the sensor (camera) in mm.
     * @return The height to the object in mm.
     */
    public static double getObjectHeight(double imgHeight, double objHeight, double sensorHeight) {
        return objHeight / imgHeight * sensorHeight;
    }

    /**
     * Calculates teh distance to an object using several different dimensions.
     * 
     * @param focalLength   The distance from the center of the lens to the focal points in mm.
     * @param imgHeight     The height of the image in pixels.
     * @param objHeight     The height of the object in pixels.
     * @param sensorHeight  The height of the sensor in mm.
     * @return The distance to the object in mm.
     */
    public static double getObjectDistance(
        double focalLength, double imgHeight, double objHeight, double sensorHeight
    ) {
        return (focalLength * getObjectHeight(imgHeight, objHeight, sensorHeight) * imgHeight) 
        / (objHeight * sensorHeight);
    }
}
