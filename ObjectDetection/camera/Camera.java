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

    public Camera(double focal, int height, int sensorHeight) {
        focalLength = focal;
        imageHeight = height;
        this.sensorHeight = sensorHeight;
    }

    protected Camera() {
        this(0, 0, 0);
    }

    public static Camera getCamera(CameraType type) {
        switch(type) {
            case APPLE_12M:
                return new IPhone12Mini();
            default:
                return new Camera();
        }
    }

    public double getObjectDistance(double objHeight) {
        return Dimensions.getObjectDistance(focalLength, imageHeight, objHeight, sensorHeight);
    }
}
