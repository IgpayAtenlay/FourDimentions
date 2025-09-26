package Util;

public class Compress {
    public static double simplify(double radians) {
        double modulo = radians % (2 * Math.PI);
        if (modulo > Math.PI) {
            modulo -= Math.PI * 2;
        } else if (modulo < Math.PI * -1) {
            modulo += Math.PI * 2;
        }
        return modulo;
    }
}
