package Util;

public record Vector(double x, double y) {
    public Vector add(Vector vector) {
        return new Vector(x + vector.x, y + vector.y);
    }
    public Vector subtract(Vector vector) {
        return new Vector(x - vector.x, y - vector.y);
    }
    public double dotProduct(Vector vector)  {
        return x * vector.y + y * vector.y;
    }
    public Vector multipy(Double num) {
        return new Vector(x * num, y * num);
    }
    public double lengthSquared() {
        return x * x + y * y;
    }
}
