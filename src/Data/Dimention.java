package Data;

public record Dimention(double x, double y, double z, double w) {
    public double distance() {
        return Math.sqrt(x*x + y*y + z*z + w*w);
    }
    public Dimention move(int distance, Dimention direction) {
        return new Dimention(
                x + direction.x() * distance / direction.distance(),
                y + direction.y() * distance / direction.distance(),
                z + direction.z() * distance / direction.distance(),
                w + direction.w() * distance / direction.distance()
        );
    }
}
