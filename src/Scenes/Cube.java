package Scenes;

import Data.Dimention;

public class Cube extends Scene {
    public Cube() {
        super();
        shapes.add(new Entities.Cube(
                new Dimention(0, 0, 2000, 0),
                new Dimention(500, 0, 2000, 0),
                new Dimention(0, 500, 2000, 0),
                new Dimention(0, 0, 2500, 0))
        );
    }
}
