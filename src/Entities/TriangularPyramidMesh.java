package Entities;

import Data.Dimension;

public class TriangularPyramidMesh extends Mesh {
    public TriangularPyramidMesh(Dimension start, int sideLength) {
        super();
        Dimension one = start.move(sideLength, new Dimension(1, 0,0 , 0));
        Dimension two = start.move(sideLength, new Dimension(0, 0, -1, 0));
        Dimension three = start.move(sideLength, new Dimension(0, 1, 0, 0));

        mesh.add(new TriangularPyramid(start, one, two, three));
    }
}
