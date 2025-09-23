package Util;

import Data.Dimention;

public class Distance {
    public static Vector closestPoint(Vector a, Vector b) {
        Vector ab = b.subtract(a);
        Vector ap = new Vector(0, 0).subtract(a);
        double projection = ap.dotProduct(ab);
        double lengthSquared = ab.lengthSquared();
        double distance = projection / lengthSquared;
        if (lengthSquared == 0) {
            return a;
        } else if (distance < 0) {
            return a;
        } else if (distance > 1) {
            return b;
        } else {
            return a.add(ab.multipy(distance));
        }
    }
    public static Dimention closestW(Dimention a, Dimention b) {
        if (a.w() < 0 && b.w() > 0 || a.w() > 0 && b.w() < 0) {
            return new Dimention(a.x(), a.y(), a.z() + a.w() * (b.z() - a.z()) / (a.w() - b.w()), 0);
        } else if (Math.abs(a.w()) == Math.abs(b.w())) {
            if (a.z() < b.z()) {
                return a;
            } else {
                return b;
            }
        } else if (Math.abs(a.w()) < Math.abs(b.w())) {
            return a;
        } else {
            return b;
        }
    }
}
