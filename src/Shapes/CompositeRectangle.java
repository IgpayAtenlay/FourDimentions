package Shapes;

import Data.Dimention;

public class CompositeRectangle extends CompositeShape {
    public CompositeRectangle(Dimention cornerOne, Dimention cornerTwo, Dimention cornerThree) {
        super();
        double distOneToTwo = cornerOne.distance(cornerTwo);
        double distTwoToThree = cornerTwo.distance(cornerThree);

        int numTriOneToTwo = (int) (distOneToTwo / CompositeShape.MAX_TRIANGLE_SIZE);
        int numTriTwoToThree = (int) (distTwoToThree / CompositeShape.MAX_TRIANGLE_SIZE);
        for (int i = 0; i < numTriOneToTwo; i++) {
            for (int j = 0; j < numTriTwoToThree; j++) {
                Dimention corner2 = cornerTwo.move(MAX_TRIANGLE_SIZE * i, cornerTwo.direction(cornerOne)).move(MAX_TRIANGLE_SIZE * j, cornerTwo.direction(cornerThree));
                Dimention corner1 = corner2.move(MAX_TRIANGLE_SIZE, cornerTwo.direction(cornerOne));
                Dimention corner3 = corner2.move(MAX_TRIANGLE_SIZE, cornerTwo.direction(cornerThree));
                Dimention corner4 = corner3.move(MAX_TRIANGLE_SIZE, cornerTwo.direction(cornerOne));

                mesh.add(new Triangle(corner1, corner2, corner3));
                mesh.add(new Triangle(corner1, corner4, corner3));
            }
        }
    }

}
