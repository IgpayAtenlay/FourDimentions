package Visuals;

import Records.Dimention;

public class Eye {
    public Dimention location;
    public Dimention direction;
    public Dimention displayRelativePosition;
    public Eye() {
        location = new Dimention(0, 0, 0, 0);
        direction = new Dimention(0, 0, 0, 0);
        displayRelativePosition = new Dimention(0, 0, 100, 0);
    }

    public Dimention modifyCoordinates(Dimention dimention) {
        double x = dimention.x() - location.x();
        double y = dimention.y() - location.y();
        double z = dimention.z() - location.z();
        double w = dimention.w() - location.w();

        // ignoring w right now
        Dimention rotated = new Dimention(
                Math.cos(direction.y()) * (
                        Math.sin(direction.z()) * y + Math.cos(direction.z()) * x
                ) - Math.sin(direction.y()) * z,
                Math.sin(direction.x()) * (
                    Math.cos(direction.y()) * z + Math.sin(direction.y()) * (
                        Math.sin(direction.z()) * y + Math.cos(direction.z()) * x
                    )
                ) + Math.cos(direction.x()) * (
                    Math.cos(direction.z()) * y - Math.sin(direction.z()) * x
                ),
                Math.cos(direction.x()) * (
                        Math.cos(direction.y()) * z + Math.sin(direction.y()) * (
                                Math.sin(direction.z()) * y + Math.cos(direction.z()) * x
                        )
                ) - Math.sin(direction.x()) * (
                        Math.cos(direction.z()) * y - Math.sin(direction.z()) * x
                ),
                w
        );

        if (rotated.z() > 0) {
            // print to page
            return new Dimention(
                    displayRelativePosition.z() / rotated.z() * rotated.x() + displayRelativePosition.x(),
                    displayRelativePosition.z() / rotated.z() * rotated.y() + displayRelativePosition.y(),
                    0,
                    0
            );
        } else {
            return new Dimention(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        }
    }
}
