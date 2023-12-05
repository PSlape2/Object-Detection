package ObjectDetection.camera;

import ObjectDetection.camera.apple.IPhone12Mini;
import ObjectDetection.util.Dimensions;

/**
 * Class for camera constants.
 */
public class Camera {
    protected final double focalLength;
    protected final int imageHeight;
    protected final int sensorHeight;

    /**
     * Creates a new Camera object to store camera-specific constants.
     * 
     * @param focal         The distance from the center of the lens to the focal points in mm.
     * @param height        The height of the image/sensor in pixels.
     * @param sensorHeight  The height of the sensor in mm.
     */
    public Camera(double focal, int height, int sensorHeight) {
        focalLength = focal;
        imageHeight = height;
        this.sensorHeight = sensorHeight;
    }

    /**
     * Default constructor, not to be used outside of this class or subclasses.
     */
    protected Camera() {
        this(0, 0, 0);
    }

    /**
     * Gets the Camera represented by the CameraType.
     * 
     * @param type  The CameraType which represents a certain Camera.
     * @return      The Camera which type represents. Returns null if no Camera can be found.
     */
    public static Camera getCamera(CameraType type) {
        switch(type) {
            case APPLE_12M:
                return new IPhone12Mini();
            default:
                return null;
        }
    }

    /**
     * Gets the CameraType which represents a certain Camera.
     * Only works with predefined subclasses of Camera.
     * 
     * @param camera    The Camera to find the CameraType for.
     * @return          The CameraType of camera.
     */
    public static CameraType getCameraType(Camera camera) {
        if(camera instanceof IPhone12Mini) return CameraType.APPLE_12M;
        else return null;
    }

    /**
     * Gets an estimate for the distance to an object based on its height and camera-specific constants.
     *
     * @param objHeight The height of the object in mm.
     * @return          The distance to the object in mm.
     */
    public double getObjectDistance(double objHeight) {
        return Dimensions.getObjectDistance(focalLength, imageHeight, objHeight, sensorHeight);
    }
}
