package Controls;

import java.awt.*;

public class Settings {
    private static double solidRange = 50;
    private static double blurRange = 6000;
    private static double gradientRange = 200;
    private static int horizontalSpeed = 100;
    private static int verticalSpeed = 100;
    private static int forwardsSpeed = 100;
    private static int anaSpeed = 100;
    private static double yawSpeed = 0.05;
    private static double pitchSpeed = 0.05;
    private static double fourDRotateSpeed = 0.05;
    private static Color background = Color.WHITE;

    public static double getSolidRange() {
        return solidRange;
    }
    public static double getBlurRange() {
        return blurRange;
    }
    public static double getGradientRange() {
        return gradientRange;
    }

    public static int getHorizontalSpeed() {
        return horizontalSpeed;
    }
    public static int getVerticalSpeed() {
        return verticalSpeed;
    }
    public static int getForwardsSpeed() {
        return forwardsSpeed;
    }
    public static int getAnaSpeed() {
        return anaSpeed;
    }

    public static double getYawSpeed() {
        return yawSpeed;
    }
    public static double getPitchSpeed() {
        return pitchSpeed;
    }
    public static double getFourDRotateSpeed() {
        return fourDRotateSpeed;
    }

    public static Color getBackground() {
        return background;
    }
}
