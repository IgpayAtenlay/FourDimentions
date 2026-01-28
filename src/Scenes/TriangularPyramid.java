package Scenes;

import Data.Dimension;

public class TriangularPyramid extends Scene {
    public TriangularPyramid() {
        super();
        shapes.add(new Entities.TriangularPyramidMesh(new Dimension(-500, 500, 2000, 500),500));
    }
}
