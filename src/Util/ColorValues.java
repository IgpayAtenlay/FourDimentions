package Util;

import java.awt.*;

public class ColorValues {
    public static Color blendColors(Color base, Color toBlend, int opaqueness, int endingAlpha) {
        opaqueness = Math.min(opaqueness, 255);
        endingAlpha = Math.min(endingAlpha, 255);

        int red = (int) (base.getRed() * ((double)(255 - opaqueness) / 255) + toBlend.getRed() * ((double)(opaqueness) / 255));
        int green = (int) (base.getGreen() * ((double)(255 - opaqueness) / 255) + toBlend.getGreen() * ((double)(opaqueness) / 255));
        int blue = (int) (base.getBlue() * ((double)(255 - opaqueness) / 255) + toBlend.getBlue() * ((double)(opaqueness) / 255));

        return new Color(red, green, blue, endingAlpha);
    }
    public static Color blendColors(Color base, Color toBlend, int opaqueness) {
        return blendColors(base, toBlend, opaqueness, 255);
    }
}
