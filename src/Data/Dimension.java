package Data;

import org.ejml.simple.SimpleMatrix;

public record Dimension(double x, double y, double z, double w) {
    public double distance() {
        return Math.sqrt(distanceSquared());
    }
    public double distanceSquared() {
        return x*x + y*y + z*z + w*w;
    }
    public double distance(Dimension dimension) {
        return subtract(dimension).distance();
    }
    public Dimension move(double distance, Dimension direction) {
        return new Dimension(
                x + direction.x() * distance / direction.distance(),
                y + direction.y() * distance / direction.distance(),
                z + direction.z() * distance / direction.distance(),
                w + direction.w() * distance / direction.distance()
        );
    }
    public Dimension move(Dimension start, Dimension end) {
        return move((int) start.distance(end), start.direction(end));
    }
    public Dimension direction(Dimension end) {
        return new Dimension(end.x - x, end.y - y, end.z - z, end.w - w);
    }
    public boolean isCloser(Dimension other) {
        double distance = distanceSquared();
        double otherDistance = other.distanceSquared();
        if (distance == otherDistance) {
            return Math.abs(w) < Math.abs(other.w);
        } else {
            return distance < otherDistance;
        }
    }
    public boolean isCloserW(Dimension other) {
        if (Math.abs(w) < Math.abs(other.w)) {
            return true;
        } else if (Math.abs(w) > Math.abs(other.w)) {
            return false;
        } else {
            return isCloser(other);
        }
    }
    public boolean isVisible() {
        return z > 0;
    }

    // matrix
    public SimpleMatrix getMatrix() {
        return new SimpleMatrix(
                new double[][] {
                        new double[] {x},
                        new double[] {y},
                        new double[] {z},
                        new double[] {w}
                }
        );
    }
    public static Dimension fromMatrix(SimpleMatrix matrix) {
        return new Dimension(matrix.get(0, 0), matrix.get(1, 0), matrix.get(2, 0), matrix.get(3, 0));
    }
    public Dimension add(Dimension dimension) {
        return new Dimension(this.x + dimension.x, this.y + dimension.y, this.z + dimension.z, this.w + dimension.w);
    }
    public Dimension subtract(Dimension dimension) {
        return new Dimension(this.x - dimension.x, this.y - dimension.y, this.z - dimension.z, this.w - dimension.w);
    }
}
