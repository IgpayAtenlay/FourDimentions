package Scenes;

import Data.Dimention;

public class Rectangle extends Scene {
    public Rectangle() {
        super();
        shapes.add(new Entities.Rectangle(
                new Dimention(500, 0, 100, 0),
                new Dimention(0, 0, 100, 0),
                new Dimention(500, 500, 100, 0))
        );
        shapes.add(new Entities.Rectangle(
                new Dimention(500, 0, 100, 0),
                new Dimention(0, 0, 100, 0),
                new Dimention(500, 0, 600, 0))
        );
    }
}
