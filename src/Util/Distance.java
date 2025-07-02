package Util;

public class Distance {
    public static Vector closestPoint(Vector a, Vector b) {
        Vector ab = b.subtract(a);
        Vector ap = new Vector(0, 0).subtract(a);
        double projection = ap.dotProduct(ab);
        double lengthSquared = ab.lengthSquared();
        double distance = projection / lengthSquared;
        if (distance < 0) {
            return a;
        } else if (distance > 1) {
            return b;
        } else {
            return a.add(ab.multipy(distance));
        }
    }
}
