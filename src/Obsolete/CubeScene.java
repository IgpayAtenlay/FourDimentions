package Obsolete;

import Data.Dimention;

public class CubeScene extends Scene {
    public CubeScene() {
        super();
        shapes.add(new Obsolete.Cube(new Dimention(-500, 500, 2000, 500),500));
    }
}
