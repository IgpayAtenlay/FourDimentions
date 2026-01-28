package Entities;

import Data.Dimension;
import Data.RotationDirection;

import java.util.ArrayList;

public abstract class Mesh extends Entity {
    public final ArrayList<TriangularPyramid> mesh;
    public Mesh() {
        this.mesh = new ArrayList<>();
    }
    public void move(int distance, Dimension direction) {
        mesh.forEach(e -> e.move(distance, direction));
    }
    public void turn(double degree, RotationDirection direction) {
        // not implimented
    }
    public void addRectangularPrism(Dimension middle, Dimension one, Dimension two, Dimension three) {
        Dimension oneTwo = one.move(middle, two);
        Dimension oneThree = one.move(middle, three);
        Dimension twoThree = two.move(middle, three);
        Dimension opposite = oneTwo.move(middle, three);
        mesh.add(new TriangularPyramid(middle, oneTwo, oneThree, twoThree));
        mesh.add(new TriangularPyramid(middle, one, oneTwo, oneThree));
        mesh.add(new TriangularPyramid(middle, two, oneTwo, twoThree));
        mesh.add(new TriangularPyramid(middle, three, oneThree, twoThree));
        mesh.add(new TriangularPyramid(opposite, oneTwo, oneThree, twoThree));
    }
}
