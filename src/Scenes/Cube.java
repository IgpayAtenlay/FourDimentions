package Scenes;

import Data.Dimension;

public class Cube extends Scene {
    public Cube() {
        super();
        shapes.add(new Entities.Cube(new Dimension(-500, 500, 2000, 500),500));
    }
}
