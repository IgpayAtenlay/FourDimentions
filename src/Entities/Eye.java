package Entities;

import Data.Dimention;
import Data.Rotation;
import Data.RotationDirections;

public class Eye extends Entity {
    private Dimention location;
    private Rotation direction;
    private Dimention displayRelativePosition;
    public Eye() {
        location = new Dimention(0, 0, 0, 0);
        direction = new Rotation(0, 0, 0);
        displayRelativePosition = new Dimention(0, 0, 700, 0);
    }
    public Dimention modifyCoordinates(Dimention dimention) {
        // move camera to 0,0,0,0
        Dimention relativeLocation = dimention.subtract(location);

        // rotate yz
        relativeLocation = rotateYZ(relativeLocation);
        // rotate wz
        relativeLocation = rotateWZ(relativeLocation);
        // rotate xz
        relativeLocation = rotateXZ(relativeLocation);

        // account for display
        relativeLocation = accountForDisplay(relativeLocation);

        return relativeLocation;
    }

    public Dimention rotateXZ(Dimention dimention) {
        // c 0 s 0
        // 0 1 0 0
        // -s 0 c 0
        // 0 0 0 1

        double cos = Math.cos(direction.xz());
        double sin = Math.sin(direction.xz());

        return new Dimention(
                dimention.x() * cos + dimention.z() * sin,
                dimention.y(),
                dimention.x() * sin * -1 + dimention.z() * cos,
                dimention.w()
        );
    }
    public Dimention rotateYZ(Dimention dimention) {
        // 1 0 0 0
        // 0 c -s 0
        // 0 s c 0
        // 0 0 0 1

        double cos = Math.cos(direction.yz());
        double sin = Math.sin(direction.yz());

        return new Dimention(
                dimention.x(),
                dimention.y() * cos + dimention.z() * sin * -1,
                dimention.y() * sin + dimention.z() * cos,
                dimention.w()
        );
    }
    public Dimention rotateWZ(Dimention dimention) {
        // 1 0 0 0
        // 0 1 0 0
        // 0 0 c -s
        // 0 0 s c

        double cos = Math.cos(direction.wz());
        double sin = Math.sin(direction.wz());

        return new Dimention(
                dimention.x(),
                dimention.y(),
                dimention.w() * sin * -1 + dimention.z() * cos,
                dimention.w() * cos + dimention.z() * sin
        );
    }
    public Dimention accountForDisplay(Dimention dimention) {
        double displayZ = displayRelativePosition.z() / dimention.z();
        return new Dimention(
                displayZ * dimention.x() + displayRelativePosition.x(),
                displayZ * dimention.y() + displayRelativePosition.y(),
                dimention.z(),
                dimention.w()
        );
    }
    public void move(int distance, Dimention direction) {
        location = location.move(distance, direction);
    }
    public void turn(double degree, RotationDirections direction) {
        this.direction = this.direction.protectedRotate(degree, direction);
        System.out.println(this.direction);
    }
}
