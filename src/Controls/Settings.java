package Controls;

import java.awt.*;

public class Settings {
    private static double solidRange = 50;
    private static double blurRange = 6000;
    private static double gradientRange = 200;
    private static int horizontalSpeed = 50;
    private static int forwardsSpeed = 50;
    private static int anaSpeed = 50;
    private static double xzTurn = 0.05;
    private static double yzTurn = 0.05;
    private static double wzTurn = 0.05;
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
    public static int getForwardsSpeed() {
        return forwardsSpeed;
    }
    public static int getAnaSpeed() {
        return anaSpeed;
    }

    public static double getXZTurn() {
        return xzTurn;
    }
    public static double getYZTurn() {
        return yzTurn;
    }
    public static double getWZTurn() {
        return wzTurn;
    }

    public static Color getBackground() {
        return background;
    }
}
