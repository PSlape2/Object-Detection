package ObjectDetection.camera.apple;

import ObjectDetection.camera.Camera;

/**
 * Class representation for APPLE_12M CameraType. Contains constant values.
 */
public final class IPhone12Mini extends Camera{
    public static final double FOCAL_LENGTH = 26.0;
    public static final int IMAGE_HEIGHT = 4032;
    public static final int SENSOR_HEIGHT = 0; // Replace this

    public IPhone12Mini() {
        super(FOCAL_LENGTH, IMAGE_HEIGHT, SENSOR_HEIGHT);
    }
}
