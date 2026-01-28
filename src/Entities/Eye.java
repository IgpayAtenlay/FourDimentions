package Entities;

import Data.Dimension;
import Data.FacingDirection;
import Data.Rotation;
import Data.RotationDirection;
import org.ejml.simple.SimpleMatrix;

public class Eye extends Entity {
    private Dimension location;
    private Rotation direction;
    private Dimension displayRelativePosition;
    public Eye() {
        location = new Dimension(0, 0, 0, 0);
        direction = new Rotation(0.5, 0, 0);
        displayRelativePosition = new Dimension(0, 0, 700, 0);
    }
    public Dimension modifyCoordinates(Dimension dimension) {
        // move camera to 0,0,0,0
        dimension = dimension.subtract(location);

        // rotate
        dimension = intrinsicRotation(dimension);

        // account for display
        dimension = accountForDisplay(dimension);

        return dimension;
    }
    public Dimension intrinsicRotation(Dimension dimension) {
        return Dimension.fromMatrix(yawMatrix(true).mult(fourDRotateMatrix(true)).mult(pitchMatrix(true)).mult(dimension.getMatrix()));
    }
    public Dimension extrinsicRotation(Dimension dimension, boolean accountForPitch) {
        if (accountForPitch) {
            return Dimension.fromMatrix(pitchMatrix(false).mult(fourDRotateMatrix(false)).mult(yawMatrix(false)).mult(dimension.getMatrix()));
        } else {
            return Dimension.fromMatrix(fourDRotateMatrix(false).mult(yawMatrix(false)).mult(dimension.getMatrix()));
        }
    }
    private SimpleMatrix yawMatrix(boolean intrinsic) {
        double cosYaw = Math.cos(direction.yaw() * (intrinsic ? 1 : -1));
        double sinYaw = Math.sin(direction.yaw() * (intrinsic ? 1 : -1));
        return new SimpleMatrix(
                new double[][] {
                        new double[] {cosYaw, 0, sinYaw, 0},
                        new double[] {0, 1, 0, 0},
                        new double[] {sinYaw * -1, 0, cosYaw, 0},
                        new double[] {0, 0, 0, 1}
                }
        );
    }
    private SimpleMatrix pitchMatrix(boolean intrinsic) {
        double cosPitch = Math.cos(direction.pitch() * (intrinsic ? 1 : -1));
        double sinPitch = Math.sin(direction.pitch() * (intrinsic ? 1 : -1));
        return new SimpleMatrix(
                new double[][] {
                        new double[] {1, 0, 0, 0},
                        new double[] {0, cosPitch, sinPitch * -1, 0},
                        new double[] {0, sinPitch, cosPitch, 0},
                        new double[] {0, 0, 0, 1}
                }
        );
    }
    private SimpleMatrix fourDRotateMatrix(boolean intrinsic) {
        double cosFourDRotate = Math.cos(direction.fourDRotate() * (intrinsic ? 1 : -1));
        double sinFourDRotate = Math.sin(direction.fourDRotate() * (intrinsic ? 1 : -1));
        return new SimpleMatrix(
                new double[][] {
                        new double[] {1, 0, 0, 0},
                        new double[] {0, 1, 0, 0},
                        new double[] {0, 0, cosFourDRotate, sinFourDRotate * -1},
                        new double[] {0, 0, sinFourDRotate, cosFourDRotate}
                }
        );
    }
    public Dimension accountForDisplay(Dimension dimension) {
        double displayZ = displayRelativePosition.z() / dimension.z();
        return new Dimension(
                displayZ * dimension.x() + displayRelativePosition.x(),
                displayZ * dimension.y() + displayRelativePosition.y(),
                dimension.z(),
                dimension.w()
        );
    }
    public void move(int distance, Dimension direction) {
        location = location.move(distance, direction);
    }
    public void move(int distance, FacingDirection direction) {
        switch (direction) {
            case FORWARD_BACK -> move(distance, extrinsicRotation(new Dimension(0, 0, 100, 0), false));
            case LEFT_RIGHT -> move(distance, extrinsicRotation(new Dimension(100, 0, 0, 0), false));
            case ANA_KATA -> move(distance, extrinsicRotation(new Dimension(0, 0, 0, 100), false));
        }
    }
    public void turn(double degree, RotationDirection direction) {
        this.direction = this.direction.protectedRotate(degree, direction);
    }
}
